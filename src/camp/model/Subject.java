package camp.model;

import java.util.Objects;

public class Subject {
    // 과목 타입
    public static String SUBJECT_TYPE_MANDATORY = "MANDATORY";
    public static String SUBJECT_TYPE_CHOICE = "CHOICE";

    private String subjectId;
    private String subjectName;
    private String subjectType;

    public Subject(String seq, String subjectName, String subjectType) {
        this.subjectId = seq;
        this.subjectName = subjectName;
        this.subjectType = subjectType;
    }

    // Getter
    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(!(o instanceof Subject)) {
            return false;
        }
        Subject subject = (Subject) o;
        return Objects.equals(this.subjectName, subject.subjectName);
    }
}
