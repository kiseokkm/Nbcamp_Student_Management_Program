package camp;

import camp.model.Student;
import camp.model.Subject;

import java.util.*;

public class StudentManage {
    public static Map<String, Student> stu_list = new HashMap<>();
    private static int studentIndex = 0;
    private static final String INDEX_TYPE_STUDENT = "ST";

    // 이곳에서 수강생 등록 수행
    public static void createStudent(Scanner sc) {
        System.out.println("\n수강생을 등록합니다...");
        System.out.print("수강생 이름 입력: ");
        String studentName = sc.next();
        // 기능 구현 (필수 과목, 선택 과목)

        String status = "";
        while(true) {
            System.out.print("수강생 상태 입력 (green, yellow, red): ");
          
            status = sc.next();
            if (status.equalsIgnoreCase("green") || status.equalsIgnoreCase("yellow") || status.equalsIgnoreCase("red")) {
                break;
            }
            System.out.println("잘못된 상태입니다. 다시 입력하세요.");
        }
        status = status.toUpperCase();

        sc.nextLine();
        Student student = new Student(INDEX_TYPE_STUDENT + studentIndex++, studentName,
                SubjectManage.subjectSelect(sc), status);

        stu_list.put(student.getStudentId(), student);
    }

    // 목록 조회에 상태도 추가 함 + 등록된 수강생 없으면 없다 .
    public static void inquiryStudent() {
        if (stu_list.isEmpty()) {
            System.out.println("등록된 수강생이 없습니다.");
            return;
        }
        for (Student student : stu_list.values()) {
            System.out.println("ID: " + student.getStudentId() + ", 이름: " + student.getStudentName() + ", 상태: " + student.getStatus());
            System.out.print("수강중인 과목들: ");
            if (student.getSubjectList().isEmpty()) {
                System.out.print("과목 없음");
            } else {
                for (Subject subject : student.getSubjectList()) {
                    System.out.print(subject.getSubjectName() + " ");
                }
            }
            System.out.println("\n");
        }
    }
    public static void inquireSpecificStudent(Scanner sc) {
        System.out.print("학생의 고유번호를 알려주세요: ");
        String studentId = sc.next();
        Student student = getStudentByStudentId(studentId);

        if (student != null) {
            System.out.println("고유번호: " + student.getStudentId());
            System.out.println("이름: " + student.getStudentName());
            System.out.println("상태: " + student.getStatus());
            System.out.print("선택한 과목명: ");
            if (student.getSubjectList().isEmpty()) {
                System.out.println("과목 없음");
            } else {
                student.getSubjectList().forEach(subject -> System.out.print(subject.getSubjectName() + " "));
                System.out.println();
            }
        } else {
            System.out.println("등록된 수강생이 없습니다.");
        }
    }

    public static void modifyStudent(Scanner sc) {
        for (Student student : stu_list.values()) {
            System.out.println("ID: " + student.getStudentId() + ", 이름: " + student.getStudentName() + ", 상태: " + student.getStatus());
        }
        System.out.print("수정할 수강생 ID 입력: ");
        String id = sc.next();

        if (!stu_list.containsKey(id)) {
            System.out.println("정확한 수강생 ID를 입력해주세요");
            return;
        } else {
            Student student = stu_list.get(id);
            System.out.print("새로운 수강생 이름 입력: ");
            student.setStudentName(sc.next());

            String status = "";
            while (true) {
                System.out.print("새로운 수강생 상태 입력 (Green, Yellow, Red): ");
                status = sc.next();
                if (status.equalsIgnoreCase("Green") || status.equalsIgnoreCase("Yellow") || status.equalsIgnoreCase("Red")) {
                    break;
                }
                System.out.println("잘못된 상태입니다. 다시 입력하세요.");
            }

            status = status.toUpperCase();
            student.setStatus(status);
        }
    }

    public static void removeStudent(Scanner sc) {
        for (Student student : stu_list.values()) {
            System.out.println("ID: " + student.getStudentId() + ", 이름: " + student.getStudentName() + ", 상태: " + student.getStatus());
        }

        System.out.print("삭제할 수강생 ID 입력: ");
        String id = sc.next();

        if (!stu_list.containsKey(id)) {
            System.out.println("정확한 수강생 ID를 입력해주세요");
            return;
        }
        else {
            stu_list.remove(id);
        }
    }

    public static Student getStudentByStudentId(String studentId) {
        Student student = stu_list.get(studentId);
        if (student != null) {
            return stu_list.get(studentId);
        }
        return null;
    }

    public static boolean containsStudentKey(String studentId) {
        return stu_list.containsKey(studentId);
    }

    public static void inquiryStatusStudents(String status) {
        for (Student student : stu_list.values()) {
            if (student.getStatus().equalsIgnoreCase(status)) {
                System.out.println("ID: " + student.getStudentId()+ "  이름: " + student.getStudentName());
            }
        }
    }
 //바구니를 가지고 있다 다른 곳에 줄 바구니 사과를 담아서 황금사과만 가져와서 다른사람한테 줄거다
    public static List<Student> getStatusStudents(String status) {
        List<Student> result = new ArrayList<>();
        for (Student student : stu_list.values()) {
            if (student.getStatus().equalsIgnoreCase(status)) {
                result.add(student);
            }
        }
        return result;
    }
}
