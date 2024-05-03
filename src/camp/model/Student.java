package camp.model;

import java.util.List;

public class Student {
    private String studentId;
    private String studentName;
    // 수강 신청 과목 id 저장 리스트
    private List<String> subjectIdList;

    public Student(String seq, String studentName) {
        this.studentId = seq;
        this.studentName = studentName;
    }

    public List<String> getSubjectList() {
        return this.subjectIdList;
    }

    public void setSubjectIdList(List<String> subjectIdList) {
        this.subjectIdList = subjectIdList;
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

}
