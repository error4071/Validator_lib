package hexlet.code.schemes;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private final Map<String, Predicate<Object>> checks;
    public boolean isRequired = false;

    public final void setRequired(boolean required) {
        isRequired = required;
    }

    protected BaseSchema() {
        this.checks = new HashMap<>();
    }

    protected final void addCheck(String name, Predicate<Object> check) {
        checks.put(name, check);
    }

    public final boolean isValid(Object object) {
        return checks.values()
                .stream()
                .allMatch(check -> check.test(object));
    }
}
