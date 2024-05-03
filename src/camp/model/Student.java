package camp.model;

import java.util.List;
import java.util.Objects;

public class Student {
    private String studentId;
    private String studentName;
    // 수강 신청 과목 id 저장 리스트
    private List<Subject> subjectList;

    public Student(String seq, String studentName, List<Subject> list) {
        this.studentId = seq;
        this.studentName = studentName;
        this.subjectList = list;
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }
}