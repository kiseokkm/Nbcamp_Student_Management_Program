package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.*;

import static camp.StudentManage.getStatusStudents;

/**
 * Notification
 * Java, 객체지향이 아직 익숙하지 않은 분들은 위한 소스코드 틀입니다.
 * main 메서드를 실행하면 프로그램이 실행됩니다.
 * model 의 클래스들과 아래 (// 기능 구현...) 주석 부분을 완성해주세요!
 * 프로젝트 구조를 변경하거나 기능을 추가해도 괜찮습니다!
 * 구현에 도움을 주기위한 Base 프로젝트입니다. 자유롭게 이용해주세요!
 */
public class CampManagementApplication {
    // 데이터 저장소
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> scoreStore;


    // index 관리 필드
    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex;
    private static final String INDEX_TYPE_SCORE = "SC";

    // 스캐너
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        setInitData();
        try {
            displayMainView();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("\n오류 발생!\n프로그램을 종료합니다.");
        }
    }

    // 초기 데이터 생성
    private static void setInitData() {
        studentStore = new ArrayList<>();
        subjectStore = List.of(
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Java",
                        Subject.SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "객체지향",
                        Subject.SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring",
                        Subject.SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "JPA",
                        Subject.SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MySQL",
                        Subject.SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "디자인 패턴",
                        Subject.SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring Security",
                        Subject.SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Redis",
                        Subject.SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MongoDB",
                        Subject.SUBJECT_TYPE_CHOICE
                )
        );
        scoreStore = new ArrayList<>();
    }

    // index 자동 증가
    private static String sequence(String type) {
        switch (type) {
            case INDEX_TYPE_STUDENT -> {
                studentIndex++;
                return INDEX_TYPE_STUDENT + studentIndex;
            }
            case INDEX_TYPE_SUBJECT -> {
                subjectIndex++;
                return INDEX_TYPE_SUBJECT + subjectIndex;
            }
            default -> {
                scoreIndex++;
                return INDEX_TYPE_SCORE + scoreIndex;
            }
        }
    }

    private static void displayMainView() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> displayStudentView(); // 수강생 관리
                case 2 -> displayScoreView(); // 점수 관리
                case 3 -> flag = false; // 프로그램 종료
                default -> {
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                    Thread.sleep(2000);
                }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    private static void displayStudentView() {
        boolean flag = true;
        Scanner sc = new Scanner(System.in); //

        while (flag) {
            try {
                System.out.println("==================================");
                System.out.println("수강생 관리 실행 중...");
                System.out.println("1. 수강생 등록");
                System.out.println("2. 수강생 목록 조회");
                System.out.println("3. 수강생 상태별 목록 조회");
                System.out.println("4. 수강생 정보(개인) 조회");
                System.out.println("5. 수강생 정보 수정");
                System.out.println("6. 수강생 정보 삭제");
                System.out.println("7. 메인 화면 이동");
                System.out.print("관리 항목을 선택하세요...");
                int input = sc.nextInt();

                switch (input) {
                    case 1 -> createStudent(sc); // 수강생 등록
                    case 2 -> inquireStudent(); // 수강생 목록 조회
                    case 3 -> inquireStatusListBySubject(sc);  // 수강생 상태별 목록 조회
                    case 4 -> inquireSpecificStudent(sc); // 수강생 정보(개인) 조회
                    case 5 -> modifyStudent(sc); // 수강생 정보 수정
                    case 6 -> removeStudent(sc); // 수강생 정보 삭제
                    case 7 -> flag = false; // 메인 화면 이동
                    default -> System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                }
            } catch(InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                sc.next(); 
            }
        }
    }
    
    // 수강생 등록
    private static void createStudent(Scanner sc) {
        // 기능 구현 (필수 과목, 선택 과목)
        StudentManage.createStudent(CampManagementApplication.sc);
        
        System.out.println("수강생 등록 성공!\n");
    }
    // 수강생 목록 조회
    private static void inquireStudent() {
        System.out.println("\n수강생 목록을 조회합니다...");
        StudentManage.inquiryStudent();
        // 기능 구현
        System.out.println("\n수강생 목록 조회 성공!");
    }
    private static void inquireSpecificStudent(Scanner sc) {
        System.out.println("\n수강생 정보 조회를 시작합니다...");
        StudentManage.inquireSpecificStudent(CampManagementApplication.sc);
        System.out.println("\n수강생 정보 조회를 완료했습니다.");
    }

    private static void modifyStudent(Scanner sc) {
        System.out.println("\n수강생 정보를 수정합니다...");
        StudentManage.modifyStudent(CampManagementApplication.sc);
        System.out.println("\n수강생 정보 수정 종료!");
    }

    private static void removeStudent(Scanner sc) {
        System.out.println("\n수강생 정보를 삭제합니다...");
        StudentManage.removeStudent(CampManagementApplication.sc);
        System.out.println("\n수강생 정보 삭제 종료!");
    }

    // 수강생 상태별 목록 조회
    private static void inquireStatusListBySubject(Scanner sc) {
        System.out.println("조회할 상태를 입력해주세요(green, yellow, red): ");
        String statusSubject = sc.next();
        getStatusStudents(statusSubject);
        System.out.println("[" + statusSubject + "] 상태인 수강생 조회 완료.");
    }

    private static void displayScoreView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 수강생의 과목별 평균 등급 조회");
            System.out.println("5. 특정 상태 수강생들의 필수 과목 평균 등급 조회");
            System.out.println("6. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createScore(); // 수강생의 과목별 시험 회차 및 점수 등록
                case 2 -> updateRoundScoreBySubject(); // 수강생의 과목별 회차 점수 수정
                case 3 -> inquireRoundGradeBySubject(); // 수강생의 특정 과목 회차별 등급 조회
                case 4 -> inquiryAverageGradeBySubject(); // 수강생의 과목별 평균 등급 조회
                case 5 -> flag = false; // 아직 미구현
                case 6 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    private static String getStudentId() {
        System.out.print("\n관리할 수강생의 번호를 입력하시오...");
        return sc.next();
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    public static void createScore() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        System.out.println("시험 점수를 등록합니다...");
        // 기능 구현
        // 학생 정보에 관리할 수강생이 없는 경우 등록 불가
        if (!StudentManage.containsStudentKey(studentId)){
            System.out.println("해당하는 학생이 없습니다.");
            return;
        }
        // 수강생 목록에서 관리할 수강생 정보를 가져온다.
        Student student = StudentManage.getStudentByStudentId(studentId);
        // 수강생의 수강 과목 목록 출력
        student.printSubjectList();

        System.out.println("등록하실 수강 과목의 번호를 입력해주세요.");
        int inputNumber = sc.nextInt();
        Subject inputSubject = student.getSubjectByIndex(inputNumber);

        if (inputSubject == null) {
            System.out.println("해당하는 번호가 없으므로 입력 불가합니다.");
            return;
        }

        String inputSubjectId = inputSubject.getSubjectId();

        // 회차 등록
        System.out.println("점수를 등록하실 회차를 입력해주세요.(1~10)");
        int inputScoreTestCnt = sc.nextInt();

        if (!Score.validationTestCnt(inputScoreTestCnt)) {
            System.out.println("회차 입력은 1미만 10초과의 수가 저장될 수 없습니다.");
            return;
        }

        if (student.hasScoreTestCnt(inputSubjectId, inputScoreTestCnt)){
            System.out.printf("%s과목에 해당하는 %d회차의 점수가 있으므로 저장할 수 없습니다.\n", inputSubject.getSubjectName(), inputScoreTestCnt);
            return;
        }

        // 점수 등록
        System.out.println("점수를 입력해주세요.(0~100)");
        int inputScore = sc.nextInt();
        if (!Score.validationScore(inputScore)) {
            System.out.println("점수는 100을 초과하거나 음수가 저장될 수 없습니다.");
            return;
        }

        // 점수 입력
        student.saveScore(
                new Score(sequence(INDEX_TYPE_SCORE), inputScoreTestCnt, studentId, inputSubject, inputScore)
        );
        System.out.println("\n점수 등록 성공!");
    }

    // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject() {
        System.out.println("시험 점수를 수정합니다...");
        System.out.println("관리할 수강생의 번호를 입력하시오...");

        sc.nextLine();
        String studentId = sc.nextLine();

        if (!StudentManage.containsStudentKey(studentId)) {
            System.out.println("해당하는 학생이 없습니다.");
            return;
        }

        Student student = StudentManage.getStudentByStudentId(studentId);
        student.printSubjectList();

        System.out.println("수정할 과목의 번호를 입력하세요.");
        int subjectIndex = sc.nextInt();
        sc.nextLine();
        Subject subject = student.getSubjectByIndex(subjectIndex);

        if (subject == null) {
            System.out.println("잘못된 과목 번호입니다.");
            return;
        }

        System.out.println("수정할 회차를 입력하세요. (1~10)");
        int testCnt = sc.nextInt();
        sc.nextLine();
        if (!Score.validationTestCnt(testCnt)) {
            System.out.println("유효하지 않은 회차입니다.");
            return;
        }

        if (!student.hasScoreTestCnt(subject.getSubjectId(), testCnt)) {
            System.out.println("해당 회차의 점수가 등록되어 있지 않습니다.");
            return;
        }

        System.out.println("새로운 점수를 입력하세요. (0~100)");
        int newScore = sc.nextInt();
        sc.nextLine();
        if (!Score.validationScore(newScore)) {
            System.out.println("점수는 0에서 100 사이여야 합니다.");
            return;
        }

        student.updateScore(subject.getSubjectId(), testCnt, newScore);
        System.out.println("\n점수 수정 성공!");
    }

    // 수강생의 특정 과목 회차별 등급 조회
    private static void inquireRoundGradeBySubject() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 입력한 학생이 존재하지 않을 경우 종료
        Student student = StudentManage.getStudentByStudentId(studentId);
        if (student == null) {
            System.out.println("해당 학생은 등록되어 있지 않거나 등급(점수)가 등록되어 있지 않습니다\n다시 시도해주세요");
            return;
        }

        // 해당 학생이 가지고 있는 과목 출력
        student.printSubjectList();

        System.out.println("조회할 과목을 입력하세요(ex: Java, 객체지향, Spring ...): ");
        String subjectName = sc.next();
        System.out.println("조회할 회차를 입력하세요: ");
        int selectedTestCnt = sc.nextInt();

        // 입력받은 과목 Name 으로 과목 ID 반환
        String subjectId = Student.findSubjectIdBySubjectName(student, subjectName);
        if (subjectId == null) {
            System.out.println("해당 과목은 수강생의 과목 목록에 없습니다.");
            return;
        }

        // 입력받은 과목 Name 으로 과목 Type 반환
        String subjectType = Subject.subjectNameToType(subjectName);

        // 특정 과목의 회차별 등급 조회 구현
        List<Score> scores = student.getScoresBySubjectId(subjectId);
        System.out.println(student.getStudentName() + " 학생의 [" + student.findSubjectBySubjectId(subjectId).getSubjectName() +"] 과목의 회차별 등급");
        for (Score score : scores) {
            if (score.getTestCnt() == selectedTestCnt && subjectType!= null) {
            System.out.println(score.getTestCnt() + " 회차 => 등급: " + score.getGrade());
            return;
            }
        }
    }

    // 수강생의 과목별 평균 등급 조회
    public static void inquiryAverageGradeBySubject() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        System.out.println("수강생의 과목별 평균 등급을 조회합니다...");
        Student student = StudentManage.getStudentByStudentId(studentId);
        student.inquiryAverageGradeBySubject();
        System.out.println("\n평균 등급 조회 성공!");
    }
}