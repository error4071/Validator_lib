package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addCheck(
                "required",
                value -> Objects.nonNull(value)
        );
        return this;

    }
    public NumberSchema positive() {
        addCheck(
                "positive",
                value -> value == null || ((Integer) value) > 0
        );
        return this;
    }

    public NumberSchema range(Integer max, Integer min) {
        addCheck(
                "range",
                value -> value == null || (((Integer) value) >= max && ((Integer) value) <= min)
        );
        return this;
    }
}
