package hexlet.code.schemes;

import java.util.Objects;

public class StringSchema extends BaseSchema {
    public StringSchema required() {
        addCheck(
                "required",
                value -> Objects.nonNull(value) && !value.toString().isEmpty()
        );
        return this;
    }

    public StringSchema minLength(int minStringLength) {
        addCheck(
                "minLength",
                value -> value == null || value.toString().length() >= minStringLength
        );
        return this;
    }

    public StringSchema contains(String str) {
        addCheck(
                "contains",
                input -> input == null || input.toString().contains(str)
        );
        return this;
    }
}
