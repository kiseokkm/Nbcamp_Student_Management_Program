package camp;

import camp.model.Subject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SubjectManage {

    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static final String REG_InputCheck = "^[1-9][0-9 ,]+[0-9]$";

    public static void subjectListView() {
        int count = 1;
        for (SubjectList list : SubjectList.values()) {
            System.out.println(count + "번 과목명: " + list.name + "(" + list.type + ")");
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
                subjectType = SubjectList.JAVA.type;
            }
            case 2 -> {
                subjectName = SubjectList.OOP.name;
                subjectType = SubjectList.OOP.type;
            }
            case 3 -> {
                subjectName = SubjectList.SPRING.name;
                subjectType = SubjectList.SPRING.type;
            }
            case 4 -> {
                subjectName = SubjectList.JPA.name;
                subjectType = SubjectList.JPA.type;
            }
            case 5 -> {
                subjectName = SubjectList.MYSQL.name;
                subjectType = SubjectList.MYSQL.type;
            }
            case 6 -> {
                subjectName = SubjectList.DESIGN_PETTERN.name;
                subjectType = SubjectList.DESIGN_PETTERN.type;
            }
            case 7 -> {
                subjectName = SubjectList.SPRING_SECURITY.name;
                subjectType = SubjectList.SPRING_SECURITY.type;
            }
            case 8 -> {
                subjectName = SubjectList.REDIS.name;
                subjectType = SubjectList.REDIS.type;
            }
            case 9 -> {
                subjectName = SubjectList.MONGODB.name;
                subjectType = SubjectList.MONGODB.type;
            }
            default -> throw new InputMismatchException();
        }
        return new Subject(subjectId, subjectName, subjectType);
    }

    public static List<Subject> subjectSelect(Scanner sc) {
        int mandatoryCnt = 0;
        int choiceCnt = 0;
        List<Subject> subjectList = new ArrayList<>();

        LOOP1:
        while (true) {

            subjectList.clear();
            try {
                Thread.sleep(300);
            } catch (Exception e) {}

            System.out.println("============================================");
            subjectListView();
            System.out.println("필수과목 최소 3개, 선택과목 최소 2개");
            System.out.print("과목들을 선택하세요 (,또는 space로구분): ");

            String selectNum = sc.nextLine();

            if (!Pattern.matches(REG_InputCheck, selectNum)) {
                System.out.println("잘못된 입력입니다 숫자를 입력해주세요");
                continue;
            }

            String[] numArr = selectNum.split("[ ,]");

            for (String e : numArr) {
                int choiceNum = Integer.parseInt(e);
                if (choiceNum < 1 || choiceNum > SubjectList.values().length) {
                    System.out.println("잘못된 입력입니다 범위내로 입력해주세요");
                    continue LOOP1;
                }
                if (subjectList.contains(createSubject(choiceNum))) {
                    System.out.println("과목은 중복해서 들을 수 없습니다 다시 입력해주세요");
                    continue LOOP1;
                }
                Subject choiceSubject = createSubject(choiceNum);
                if (choiceSubject.getSubjectType().equals("MANDATORY")) {
                    mandatoryCnt++;
                } else {
                    choiceCnt++;
                }
                subjectList.add(createSubject(choiceNum));
            }

            if (mandatoryCnt < 3 || choiceCnt < 2) {
                System.out.println("과목이 부족합니다! 다시 입력해주세요");
            }
            else {
                System.out.println("선택이 완료되었습니다! 선택확정: ok입력, 다시선택: 아무키나 입력하세요");
                if (sc.next().equalsIgnoreCase("ok")) {
                    break;
                }
            }
        }
        return subjectList;
    }
}
