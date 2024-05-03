package camp;

import camp.model.Subject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SubjectManage {

    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";

    public static void subjectListView() {
        int count = 1;
        for (SubjectList list : SubjectList.values()) {
            System.out.println(count + "번 과목명: " + list.name);
            count++;
        }
    }

    public static Subject createSubject(int num) {
        String subjectName;
        String subjectId = INDEX_TYPE_SUBJECT + subjectIndex++;
        String subjectType;
        switch (num) {
            case 1 -> {
                subjectName = SubjectList.JAVA.name;
                subjectType = Subject.SUBJECT_TYPE_MANDATORY;
            }
            case 2 -> {
                subjectName = SubjectList.OOP.name;
                subjectType = Subject.SUBJECT_TYPE_MANDATORY;
            }
            case 3 -> {
                subjectName = SubjectList.SPRING.name;
                subjectType = Subject.SUBJECT_TYPE_MANDATORY;
            }
            case 4 -> {
                subjectName = SubjectList.JPA.name;
                subjectType = Subject.SUBJECT_TYPE_MANDATORY;
            }
            case 5 -> {
                subjectName = SubjectList.MYSQL.name;
                subjectType = Subject.SUBJECT_TYPE_MANDATORY;
            }
            case 6 -> {
                subjectName = SubjectList.DESIGN_PETTERN.name;
                subjectType = Subject.SUBJECT_TYPE_CHOICE;
            }
            case 7 -> {
                subjectName = SubjectList.SPRING_SECURITY.name;
                subjectType = Subject.SUBJECT_TYPE_CHOICE;
            }
            case 8 -> {
                subjectName = SubjectList.REDIS.name;
                subjectType = Subject.SUBJECT_TYPE_CHOICE;
            }
            case 9 -> {
                subjectName = SubjectList.MONGODB.name;
                subjectType = Subject.SUBJECT_TYPE_CHOICE;
            }
            default -> throw new InputMismatchException();
        }
        return new Subject(subjectId, subjectName, subjectType);
    }

    public static List<Subject> subjectSelect(Scanner sc){
        int mandatoryCnt = 0;
        int choiceCnt = 0;
        List<Subject> subjectList = new ArrayList<>();

        while(true)
        {
            try
            {
                Thread.sleep(300);
            }catch (Exception e) {}


            System.out.println("============================================");
            subjectListView();
            System.out.println("필수과목 최소 3개, 선택과목 최소 2개");
            System.out.print("과목을 선택하세요 (번호입력): ");
            int selectNum = sc.nextInt();
            if(selectNum < 1 || selectNum > 9) {
                System.out.println("잘못된 입력입니다");
                continue;
            }

            if(selectNum < 6) {
                mandatoryCnt++;
            }
            else {
                choiceCnt++;
            }
            if(subjectList.contains(createSubject(selectNum))){
                System.out.println("이미 선택한 과목입니다!");
                continue;
            }
            else {
                subjectList.add(createSubject(selectNum));
            }

            System.out.print("과목 선택을 종료하시겠습니까? (exit입력): ");
            if(sc.next().equals("exit")){
                if(mandatoryCnt < 3 || choiceCnt < 2) {
                    System.out.println("과목을 더 선택해야합니다!");
                }
                else{
                    break;
                }
            }
        }

        return subjectList;
    }
}
