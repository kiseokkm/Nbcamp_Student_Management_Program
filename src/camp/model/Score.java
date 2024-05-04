package camp.model;

public class Score {
    private String studentId;
    // 과목 정보
    private String subjectId;
    // 등급
    private String grade;
    // 회차
    private int testCnt;
    private String scoreId;
    // 점수
    private int score;

    public Score(String seq) {
        this.scoreId = seq;
    }

    public Score(String seq, int testCnt, String studentId, String subjectId, int score) {
        this.scoreId = seq;
        this.testCnt = testCnt;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.score = score;
    }

    // Getter
    public String getScoreId() {
        return scoreId;
    }

    public int getScore() {
        return score;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public int getTestCnt() {
        return testCnt;
    }

    public String getStudentId() {
        return studentId;
    }
}
