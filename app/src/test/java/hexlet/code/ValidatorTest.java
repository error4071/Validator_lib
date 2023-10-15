package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import hexlet.code.schemes.StringSchema;
import hexlet.code.schemes.NumberSchema;

public class ValidatorTest {

    @Test
    public void stringSchemaTest() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertThat(schema.isValid("")).isTrue();

        schema.required();
        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("hexlet")).isTrue();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid(null)).isFalse();

        schema.minLength(7);
        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("hexlet")).isFalse();

        assertThat(schema.contains("what").isValid("what does the fox say")).isTrue();

        assertThat(schema.contains("whatthe").isValid("what does the fox say")).isFalse();
    }

    @Test
    public void numberSchemeTest() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
    }
}
