package enums;

public enum PredicateType {
    AND(1),
    OR(2);

    int value;

    PredicateType(int value) {
        this.value = value;
    }
}
