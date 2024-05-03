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

    public Score(String seq) {
        this.scoreId = seq;
    }

    // Getter
    public String getScoreId() {
        return scoreId;
    }

}
