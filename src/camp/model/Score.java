package camp.model;

public class Score {
    private String studentId;
    // 과목 정보
    private Subject subject;
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

    public Score(String seq, int testCnt, String studentId, Subject subject, int score) {
        this.scoreId = seq;
        this.testCnt = testCnt;
        this.studentId = studentId;
        this.subject = subject;
        this.score = score;
        // TODO grade 계산
        // this.grade =
    }

    // Getter
    public String getScoreId() {
        return scoreId;
    }

    public int getScore() {
        return score;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getTestCnt() {
        return testCnt;
    }

    public String getStudentId() {
        return studentId;
    }

    // TODO input회차 validation
    public static boolean validationTestCnt(int inputTestCnt) {
        if (0 >= inputTestCnt || inputTestCnt > 10){
            return false;
        }
        return true;
    }

    // TODO 회차 계산
    public boolean hasTestCnt(int testCnt) {
        return this.testCnt == testCnt;
    }

    // TODO input점수 validation
    public static boolean validationScore(int inputScore){
        if (inputScore > 100 || 0 > inputScore) {
            return false;
        }
        return true;
    }

    // TODO 등급 계산
}
