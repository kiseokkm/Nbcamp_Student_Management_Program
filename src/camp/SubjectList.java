package camp;

import camp.model.Subject;

public enum SubjectList {
    JAVA("Java","MANDATORY"),
    OOP("객체지향","MANDATORY"),
    SPRING("Spring","MANDATORY"),
    JPA("JPA","MANDATORY"),
    MYSQL("MySQL","MANDATORY"),
    DESIGN_PETTERN("디자인패턴","CHOICE"),
    SPRING_SECURITY("Spring_Security","CHOICE"),
    REDIS("Redis","CHOICE"),
    MONGODB("MongoDB","CHOICE");

    public final String name;
    public final String type;

    SubjectList(String subName, String subType) {
        name = subName;
        type = subType;
    }
}
