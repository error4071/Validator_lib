package hexlet.code.schemes;

public class StringSchema {
    private boolean required;
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
        this.required = false;
        return this;
    }

    public  StringSchema minLength(int number) {
        return this;
    }

    public StringSchema contains(String word) {
        return this;
    }

    public boolean isValid(String str) {
        if (str instanceof String && str.length() >= 0 && required) {
            return false;
        }
        if (str.equals(null) || str.equals("")) {
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
