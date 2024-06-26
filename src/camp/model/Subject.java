package camp.model;

import camp.SubjectList;

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

    /**
     * 해당하는 과목 ID가 있는지 확인
     * @param subjectId 확인할 과목 ID
     * @return 확인 여부
     */
    public boolean hasSubjectId(String subjectId){
        return Objects.equals(this.subjectId, subjectId);
    }

    // 과목 Name 의 Type 을 반환
    public static String subjectNameToType(String subjectName) {
        for (SubjectList subject : SubjectList.values()) {
            if (subject.name.equals(subjectName)) {
                return subject.type;
            }
        }
        return null;
    }
}
