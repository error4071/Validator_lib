package hexlet.code.schemas;

public class StringSchema {
    public boolean required;
    public boolean minLength;
    public boolean contains;
    public String word;
    public int num;

    public StringSchema() {
        this.required = false;
        this.minLength = false;
        this.contains = false;
    }

    public StringSchema required() {
        return this;
    }

    public  StringSchema minLength(int num) {
        return this;
    }

    public StringSchema contains(String string) {
        return this;
    }

    public boolean isValid(String object) {
        if (object == null || object == "") {
            return true;
        }
        if (object.contains(word)) {
            return true;
        }
        else {
            return false;
        }
    }
}


