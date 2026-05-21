package com.wanted.object.b_array;

public class Application04 {

    public static void main(String[] args) {
        
        // 출력 예시 : 당신이 뽑은 카드는 SPADE ACE 입니다.
        // 필요한 값 : 카드 넘버, 문양
        
        String[] shapes = {"SPADE", "CLOVER", "HEART", "DIAMOND"};
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "JACK", "QUEEN", "KING", "ACE"};
    
        // Math 클래스 -> 수학적 요소(합계, 평균, 올림,내림, 등등)
        // 우리같은 수학을 싫어하는 사람들을 위해 개발자들이 미리 만들어둠.
        int randomShape = (int)(Math.random() * shapes.length);
        System.out.println("randomShape = " + randomShape);
        int randomNumbers = (int)(Math.random() * numbers.length);
        System.out.println("randomNumbers = " + randomNumbers);

        System.out.println("당신이 뽑은 카드는 " + shapes[randomShape] + " " + numbers[randomNumbers] + "입니다.");
        
    }
    
    
    
}
