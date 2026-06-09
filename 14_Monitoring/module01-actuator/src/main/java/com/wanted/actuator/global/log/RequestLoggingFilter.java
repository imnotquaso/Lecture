package com.wanted.actuator.global.log;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.MDC;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RequestLoggingFilter {

//    private static final Logger log = LoggerFactory.getLogger(RequestLoggingFilter.class);

    public static final String REQUEST_ID_HEADER = "X-Request-Id";
    public static final String TRACE_ID_MDC_KEY = "traceId";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String traceId = resolveTraceId(request);
        long startAt = System.nanoTime();

        MDC.put(TRACE_ID_MDC_KEY, traceId);
        response.setHeader(REQUEST_ID_HEADER , traceId);

        try {

            log.info("event=request_started method={} uri={}", request.getMethod(), request.getRequestURI());
            // 다음 필터 동작 , 없으면 Controller
            filterChain.doFilter(request , response);
        } finally {

            // 소요 시간
            long durationMs = (System.nanoTime() - startAt) / 1_000_000;

            log.info(
                    "event=request_completed method={} uri={} status={} durationMs={}",
                    request.getMethod(),
                    request.getRequestURI(),
                    response.getStatus(),
                    durationMs
            );

            MDC.remove(TRACE_ID_MDC_KEY);
        }

    }

    private String resolveTraceId(HttpServletRequest request) {
        // 사용자 요청 헤더에서 requestID 꺼내기
        String requestId = request.getHeader(REQUEST_ID_HEADER);
        if(requestId == null || requestId.isBlank()) {
            return UUID.randomUUID().toString();
        }
        // 요청 별 식별 id 반환
        return requestId;
    }
}
