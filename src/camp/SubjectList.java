package camp;

import camp.model.Subject;

public enum SubjectList {
    JAVA("Java"),
    OOP("객체지향"),
    SPRING("Spring"),
    JPA("JPA"),
    MYSQL("MySQL"),
    DESIGN_PETTERN("디자인패턴"),
    SPRING_SECURITY("Spring_Security"),
    REDIS("Redis"),
    MONGODB("MongoDB");

    public final String name;

    SubjectList(String subName) {
        name = subName;
    }
}
