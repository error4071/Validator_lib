package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema {
    public MapSchema required() {
        addCheck(
                "required",
                value -> Objects.nonNull(value)
        );
        return this;
    }

    public MapSchema sizeof(int theSize) {
        addCheck(
                "sizeof",
                value -> value == null || ((Map<?, ?>) value).size() >= theSize
        );
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addCheck(
                "shape",
                value -> value == null || schemas.keySet()
                        .stream().allMatch(key -> {
                            Object valueInput = ((Map<?, ?>) value).get(key);
                            return schemas.get(key).isValid(valueInput);
                        })
        );
        return this;
    }
}


