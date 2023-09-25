package hexlet.code.schemes;

public class NumberSchema {
    private boolean required;
    private boolean positive;
    private boolean range;
    private Integer number;

    public NumberSchema() {
        this.required = false;
        this.positive = false;
        this.range = false;
    }

    public NumberSchema required() {
        return this;
    }

    public NumberSchema positive() {
        return this;
    }

    public NumberSchema inRange(Integer beginNum, Integer endNum) {
        return this;
    }

    public boolean isValid(Integer number) {
        if (number == 0 || number == (null) ) {
            return true;
        }
        if (positive && (number == null)) {
            return true;
        } else {
            return false;
        }
    }
}
