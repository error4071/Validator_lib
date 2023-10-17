package hexlet.code.schemes;

public class StringSchema extends BaseSchema {
    public boolean required;
    private boolean minLength;
    private boolean contains;
    private String word;
    private int number;

    public StringSchema() {
        this.required = false;
        this.minLength = false;
        this.contains = false;
    }

    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema minLength(int number) {
        return this;
    }

    public StringSchema contains(String word) {
        return this;
    }

    public boolean isValid(String str) {
        if (!isRequired && (str == null || str.equals(""))) {
            return true;
        }
        if (str instanceof String || str.contains(word)) {
            return true;
        }
        if (str.length() > number) {
            return false;
        } else {
            return false;
        }
    }
}
