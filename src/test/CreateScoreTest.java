package test;

import camp.CampManagementApplication;
import camp.StudentManage;
import camp.SubjectList;
import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreateScoreTest {
    // 데이터 저장소
//    private static List<Score> scoreStore;

    public static void main(String[] args) {
        // given
        initData();
        // 수강생의 과목별 시험 회차 및 점수 등록
        Student student = StudentManage.stu_list.get("ST01");
        // 중복 회차 확인용
        initScoreData(student);

        // when
        for (int i=0; i<5; i++) {
            CampManagementApplication.createScore();
        }

        // test
        Map<String, List<Score>> myScores = student.getScoreMap();
        for (int i=0; i<myScores.size(); i++) {
            List<String> keys = myScores.keySet().stream().toList();
            for (Score score : student.getScoreMap().get(keys.get(i))) {
                System.out.printf("\n%s과목의 회차: %d, 점수: %d", score.getSubject().getSubjectName(), score.getTestCnt(), score.getScore());
            }
        }
    }

    public static void initData(){
        // 수강 과목 리스트 생성
        List<Subject> subjectList = List.of(
                new Subject("SU01", SubjectList.MYSQL.name, Subject.SUBJECT_TYPE_CHOICE),
                new Subject("SU02", SubjectList.MONGODB.name, Subject.SUBJECT_TYPE_CHOICE),
                new Subject("SU03", SubjectList.REDIS.name, Subject.SUBJECT_TYPE_CHOICE),
                new Subject("SU04", SubjectList.DESIGN_PETTERN.name, Subject.SUBJECT_TYPE_CHOICE),
                new Subject("SU05", SubjectList.SPRING.name, Subject.SUBJECT_TYPE_CHOICE),
                new Subject("SU06", SubjectList.JAVA.name, Subject.SUBJECT_TYPE_CHOICE)
        );

        // 학생 추가 ( 상태추가 )
        StudentManage.stu_list.put("ST01", new Student("ST01", "name1", subjectList, "Green"));
    }

    public static void initScoreData(Student student){
        Subject subject = new Subject("SU01", SubjectList.MYSQL.name, Subject.SUBJECT_TYPE_CHOICE);
        student.saveScore(
                new Score("SO01", 1,"ST01", subject, 10)
        );
    }
}
