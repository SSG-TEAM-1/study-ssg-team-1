package com.kyungbae.model.dao;

import com.kyungbae.model.dto.StudentDto;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.kyungbae.common.JDBCTemplate.close;

public class StudentDao {
    Properties prop = new Properties();

    public StudentDao(){
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/kyungbae/mapper/chun-query.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<StudentDto> avgStudentPointByClass(Connection conn, String className){
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<StudentDto> list = new ArrayList<>();
        String query = prop.getProperty("AvgStudentPointByClass");
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, className);
            rset = pstmt.executeQuery();

            while(rset.next()){
                StudentDto student = new StudentDto(
                        rset.getString("student_no"),
                        rset.getString("student_name"),
                        rset.getDouble("point")
                );
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return list;
    }

    public List<String> selectDepartmentList(Connection conn) {
        List<String> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = prop.getProperty("selectDepartmentName");

        try {
            pstmt = conn.prepareStatement(query);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                list.add(rset.getString("department_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return list;
    }

}
