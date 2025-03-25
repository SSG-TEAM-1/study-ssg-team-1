package com.kyungbae.model.dto;

public class StudentDto {
    private String studentNo;
    private String studentName;
    private double point;

    public StudentDto(){}

    public StudentDto(String studentNo, String studentName, double point) {
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.point = point;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "studentNo='" + studentNo + '\'' +
                ", studentName='" + studentName + '\'' +
                ", point=" + point +
                '}';
    }
}
