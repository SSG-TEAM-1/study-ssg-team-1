package com.kyungbae.run;

import com.kyungbae.model.dao.StudentDao;
import com.kyungbae.model.dto.StudentDto;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import static com.kyungbae.common.JDBCTemplate.close;
import static com.kyungbae.common.JDBCTemplate.getConnection;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDao studentDao = new StudentDao();
        Connection conn = getConnection();

        // 학과정보 출력
        System.out.println("----- 학과 리스트 -----");
        List<String> departmentList = studentDao.selectDepartmentList(conn);
        departmentList.forEach(System.out::println);

        // 찾을 학과 입력받기
        System.out.print("\n학과 입력 :");
        String className = sc.nextLine();

        List<StudentDto> list = studentDao.avgStudentPointByClass(conn, className);
        for (StudentDto student : list) {
            System.out.println(student.getStudentNo() + " - " + student.getStudentName() + " : " + student.getPoint());
        }
        close(conn);
    }
}
