package camp.model;

import java.util.*;

public class Student {
    private String studentId;
    private String studentName;
    // 수강 신청 과목 저장 리스트
    private List<Subject> subjectList;
    // 점수 저장 리스트 key: 수강 신청 과목, value: 점수
    private Map<String, List<Score>> scoreMap = new HashMap<>();
    private String status;
    private Score[] scores;

    public Student(String seq, String studentName, List<Subject> list, String status) {
        this.studentId = seq;
        this.studentName = studentName;
        this.subjectList = list;
        this.status = status;
    }

    public void getMyAverageScore() {

        if (status != "green" && status != "red" && status != "yellow") {
            System.out.println("수강생의 상태를 입력해주세요.");
        }

        for (Subject subject : subjectList) {

            String key = subject.getSubjectId();
            List<Score> scores = scoreMap.get(key);

            if (subjectList.equals(Subject.SUBJECT_TYPE_MANDATORY)) {

                int result2 = 0;
                double result = 0;
                double sum = 0;

                for (int i = 0; i < scores.size(); i++) {
                    sum += scores.get(i).getScore();
                    result = sum / scores.size();
                    result2 = (int) result;
                }
                Score.calculationGrade(subject.getSubjectType(), result2);
                System.out.println("상태 : " + status + "수강생 이름 : " + studentName + "필수과목 평균등급 : " + result2);
            }
        }
    }

    // Getter
    public String getStudentId() {return studentId; }

    public String getStudentName() {
        return studentName;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public Map<String, List<Score>> getScoreMap() {
        return scoreMap;
    }

    public String getStatus() {return status; }

    public void setStatus(String status) {this.status = status;}

    /**
     * index로 강의 정보를 찾는다.
     * @param index 입력 index
     * @return 해당하는 index의 강의 정보
     */
    public Subject getSubjectByIndex(int index) {
        // 인덱스 값이 1 이상이고 subjectList 크기 이하인지 검증
        if (index >= 1 && index <= subjectList.size()) {
            return subjectList.get(index - 1); // 사용자는 1부터 시작하는 인덱스를 사용
        }
        return null; // 범위 밖의 인덱스 입력 시 null 반환
    }

    /**
     * 수강생의 점수를 저장한다.
     * @param score 점수 정보
     */
    public void saveScore(Score score){
        String key = score.getSubject().getSubjectId();
        List<Score> scores = scoreMap.get(key);
        if (scores == null){
            scores = new ArrayList<>();
        }
        scores.add(score);
        scoreMap.put(score.getSubject().getSubjectId(), scores);
    }

    /**
     * 수강생의 전체 강의 목록 출력
     */
    public void printSubjectList() {
        System.out.println("========================================");
        System.out.printf("[수강생 ID: %s]등록된 %s 학생의 과목 정보를 출력합니다.\n", studentId, studentName);
        int index = 1;
        for (Subject subject : subjectList) {
            System.out.printf("%d. %s\n", index++, subject.getSubjectName());
        }
    }

    /**
     * 강의 ID로 수강 과목 정보를 찾는다.
     * @param subjectId 찾을 과목 아이디
     * @return 해당하는 ID의 과목 정보
     */
    public Subject findSubjectBySubjectId(String subjectId) {
        for (Subject subject : subjectList) {
            if (subject.getSubjectId().equals(subjectId)) {
                return subject;
            }
        }
        return null;
    }

    /**
     * 해당하는 과목을 가지고 있는지 확인
     * @param subjectId 확인할 과목 아이디
     * @return 있으면 true, 없으면 false
     */
    public boolean hasSubject(String subjectId){
        for (Subject subject : subjectList) {
            if (subject.hasSubjectId(subjectId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 해당하는 과목의 점수가 있는지 확인
     * @param subjectId 과목 아이디
     * @return 있으면 true 없으면 false
     */
    public boolean existsScoreBySubjectId(String subjectId) {
        return scoreMap.containsKey(subjectId);
    }

    /**
     * 해당 과목 점수에 입력한 회차 점수 등록 여부 확인
     * @param scoreTestCnt 확인할 회차
     * @return 중복이면 true 아니면 false
     */
    public boolean hasScoreTestCnt(String subjectId, int scoreTestCnt){
        if (!existsScoreBySubjectId(subjectId)){
            return false;
        }
        for (Score score : scoreMap.get(subjectId)) {
            if (score.hasTestCnt(scoreTestCnt)){
                return true;
            }
        }
        return false;
    }

    // 과목 이름을 받아서 과목 고유 ID로 바꾸기
    public static String findSubjectIdBySubjectName(Student student, String subjectName) {
        List<Subject> subjectList = student.getSubjectList();
        for (Subject subject : subjectList) {
            if (subject.getSubjectName().equals(subjectName)) {
                return subject.getSubjectId();
            }
        }
        return null;
    }

    // scoreMap 에 저장된 과목 아이디에 해당하는 점수 리스트 반환
    public List<Score> getScoresBySubjectId(String subjectId) {
        return scoreMap.get(subjectId);
    }


    // 과목별 평균 등급 조회
    public void inquiryAverageGradeBySubject(){
        // 수강 신청 과목 리스트
        for (Subject subject : subjectList){
            String key = subject.getSubjectId();
            List<Score> scores = scoreMap.get(key);
            if (scores != null) {
                double sum = scores.stream()
                        .mapToInt(Score::getScore)
                        .sum();
                double avg = sum / scores.size();
                System.out.printf("%s의 과목의 평균 점수는 %f이고, 평균 등급은 %s입니다.\n",
                        subject.getSubjectName(), avg, Score.calculationGrade(subject.getSubjectType(), (int) avg));
            }
        }
    }

    public void setStudentName(String name) {
        this.studentName = name;
    }

    public void updateScore(String subjectId, int testCnt, int newScore) {
        List<Score> scores = scoreMap.get(subjectId);
        if (scores != null) {
            for (Score score : scores) {
                if (score.getTestCnt() == testCnt) {
                    score.setScore(newScore);
                    System.out.println("점수와 등급이 업데이트 되었습니다.");
                    return;
                }
            }
        }
        System.out.println("해당 회차의 점수를 찾을 수 없습니다.");
    }
}