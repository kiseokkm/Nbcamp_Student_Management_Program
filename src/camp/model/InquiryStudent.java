package camp.model;

import camp.CampManagementApplication;

import java.util.Map;

public class InquiryStudent {

    private String studentName;
    private String studentId;

    public InquiryStudent(String studentName, String studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
    }
    public String getStudentName(Map stu_list, String studentId) {
        return stu_list.get(studentId).getstudentName();
    }
    public String getStudentId(Map stu_list) {
        return studentId;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    public static void inquiryStudent() {
        for (Student e : stu_list.values()) {
            System.out.println("ID: " + e.getStudentId() + " 이름: " + e.getStudentName());

        }
    }
}