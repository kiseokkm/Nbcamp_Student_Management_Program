package camp.model;

import java.util.List;

public class Student {
    private String studentId;
    private String studentName;
    // 수강 신청 과목 id 저장 리스트
    private List<String> subjectList;




    public Student(String seq, String studentName) {
        this.studentId = seq;
        this.studentName = studentName;
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

}
