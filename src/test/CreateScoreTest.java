package test;

import camp.CampManagementApplication;
import camp.StudentManage;
import camp.SubjectList;
import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.List;
import java.util.Map;

public class CreateScoreTest {
    // 데이터 저장소
//    private static List<Score> scoreStore;

    public static void main(String[] args) {
        // given
        initData();
        // 수강생의 과목별 시험 회차 및 점수 등록
        Student student = StudentManage.stu_list.get("ST01");
        Student student2 = StudentManage.stu_list.get("ST02");

        // 점수 데이터 생성
        initScoreData(student);
        initScoreData(student2);

        student2.saveScore(
                new Score("SO99", 1, student2.getStudentId(),
                        new Subject("SU03", SubjectList.REDIS.name, SubjectList.REDIS.type)
                        , 90)
        );

        // 수강생 별 점수 등록 테스트
//        for (int i=0; i<5; i++) {
//            CampManagementApplication.createScore();
//        }

        // test
        Map<String, List<Score>> myScores = student.getScoreMap();
        for (int i=0; i<myScores.size(); i++) {
            List<String> keys = myScores.keySet().stream().toList();
            for (Score score : student.getScoreMap().get(keys.get(i))) {
                System.out.printf("\n%s과목의 회차: %d, 점수: %d", score.getSubject().getSubjectName(), score.getTestCnt(), score.getScore());
            }
        }

        System.out.println();
        // 과목별 평균 등급 조회 테스트
        CampManagementApplication.inquiryAverageGradeBySubject();
    }

    public static void initData(){
        // 수강 과목 리스트 생성
        List<Subject> subjectList = List.of(
                new Subject("SU01", SubjectList.MYSQL.name, SubjectList.MYSQL.type),
                new Subject("SU02", SubjectList.MONGODB.name, SubjectList.MONGODB.type),
                new Subject("SU03", SubjectList.REDIS.name, SubjectList.REDIS.type),
                new Subject("SU04", SubjectList.DESIGN_PETTERN.name, SubjectList.DESIGN_PETTERN.type),
                new Subject("SU05", SubjectList.SPRING.name, SubjectList.SPRING.type),
                new Subject("SU06", SubjectList.JAVA.name, SubjectList.JAVA.type)
        );

        // 학생 추가
        StudentManage.stu_list.put("ST01", new Student("ST01", "name1", subjectList,"Green"));
        StudentManage.stu_list.put("ST02", new Student("ST02", "name2", subjectList, "Green"));
    }

    public static void initScoreData(Student student){
        Subject subject = new Subject("SU01", SubjectList.MYSQL.name, SubjectList.MYSQL.type);
        Subject subject2 = new Subject("SU02", SubjectList.MONGODB.name, SubjectList.MONGODB.type);

        // 학생 1
        // 과목 1
        int index = 1;
        student.saveScore(
                new Score("SO" + index++, 1, student.getStudentId(), subject, 10)
        );
        student.saveScore(
                new Score("SO" + index++, 2,student.getStudentId(), subject, 50)
        );
        student.saveScore(
                new Score("SO" + index++, 3,student.getStudentId(), subject, 70)
        );
        student.saveScore(
                new Score("SO" + index++, 4,student.getStudentId(), subject, 80)
        );
        student.saveScore(
                new Score("SO" + index++, 5,student.getStudentId(), subject, 90)
        );

        // 과목2
        student.saveScore(
                new Score("SO" + index++, 1,student.getStudentId(), subject2, 20)
        );
        student.saveScore(
                new Score("SO" + index++, 2,student.getStudentId(), subject2, 50)
        );
        student.saveScore(
                new Score("SO" + index++, 3,student.getStudentId(), subject2, 70)
        );
        student.saveScore(
                new Score("SO" + index++, 4,student.getStudentId(), subject2, 80)
        );
        student.saveScore(
                new Score("SO" + index++, 5,student.getStudentId(), subject2, 90)
        );
    }
}
