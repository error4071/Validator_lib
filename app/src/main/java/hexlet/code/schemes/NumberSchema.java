package hexlet.code.schemes;

public final class NumberSchema extends BaseSchema {
    public NumberSchema positive() {
        addCheck(
                "positive",
                value -> ((int) value) > 0
        );
        return this;
    }

    public NumberSchema range(Integer max, Integer min) {
        addCheck(
                "range",
                value -> (int) value <= max && (int) value >= min
        );
        return this;
    }
}
