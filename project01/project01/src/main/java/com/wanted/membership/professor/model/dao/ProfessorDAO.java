package com.wanted.membership.professor.model.dao;

import com.wanted.membership.professor.global.utils.QueryUtil;
import com.wanted.membership.professor.model.dto.ProfessorDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public List<ProfessorDTO> finaAll() {
    String query = QueryUtil.getquery("professor.findAll");
    List<professorDTO> professorList = new ArrayList<>();

    try (PreparedStatement pstmt = connection.prepareStatement(query)){

        ResultSet rset = pstmt.executeQuery();

        while (rset.next()) {
            ProfessorDTO professor = new ProfessorDTO(
                    rset.getString("professor_id"),
                    rset.getString("professor_pwd"),
                    rset.getString("professor_name"),
                    rset.getString("professor_eamil"),
                    rset.getString("professor_phone"),
                    rset.getString("professor_address"),
                    rset.getString("professor_code")

            );
            professorList.add(professor);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return professorList;
}
        public int insertProfesor (ProfessorDTO professor) {

    }

