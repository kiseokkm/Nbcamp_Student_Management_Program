package camp;

import camp.model.Student;
import camp.model.Subject;

import java.util.*;

public class StudentManage
{
    public  static Map<String, Student> stu_list = new HashMap<>();
    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";

    // 이곳에서 수강생 등록 수행
    public static void createStudent(Scanner sc) {
        System.out.println("\n수강생을 등록합니다...");
        System.out.print("수강생 이름 입력: ");
        String studentName = sc.next();
        // 기능 구현 (필수 과목, 선택 과목)

        sc.nextLine();
        Student student = new Student(INDEX_TYPE_STUDENT + studentIndex++, studentName,
                SubjectManage.subjectSelect(sc));

        stu_list.put(student.getStudentId(),student);
    }

    // 임시 테스트용
    public static void inquiryStudent(){
        for(Student e : stu_list.values()) {
            System.out.println("ID: " + e.getStudentId() + " 이름: " + e.getStudentName());
            System.out.println("수강중인 과목들:");
            for(Subject f : e.getSubjectList())
            {
                System.out.printf("과목명: " + f.getSubjectName() + " ");
            }
            System.out.println();
        }
    }

}
