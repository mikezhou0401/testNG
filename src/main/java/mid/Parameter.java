package mid;

import java.util.Objects;

public enum Parameter {
    A1_A1(1, "A1-A1.txt"),
    A1_A2(2, "A1-A2.txt"),
    A2_A1(3, "A2-A1.txt"),
    A2_A2(4, "A2-A2.txt"),

    A1_B1(1, "AA1-BB1.txt"),
    A1_B2(2, "AA1-BB2.txt"),
    A2_B1(3, "AA2-BB1.txt"),
    A2_B2(4, "AA2-BB2.txt"),

    B1_A1(5, "BB1-AA1.txt"),
    B1_A2(6, "BB1-AA2.txt"),
    B2_A1(7, "BB2-AA1.txt"),
    B2_A2(8, "BB2-AA2.txt"),

    B1_C1(9, "BB1-CC1.txt"),
    B1_C2(10, "BB1-CC2.txt"),
    B2_C1(11, "BB2-CC1.txt"),
    B2_C2(12, "BB2-CC2.txt"),

    C1_A1(13, "CC1-AA1.txt"),
    C1_A2(14, "CC1-AA2.txt"),
    C2_A1(15, "CC2-AA1.txt"),
    C2_A2(16, "CC2-AA2.txt");

    int value;
    String name;

    Parameter(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public  String getName() {
        return name;
    }
}
