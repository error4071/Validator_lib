package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import hexlet.code.schemes.StringSchema;
import hexlet.code.schemes.NumberSchema;
import hexlet.code.schemes.MapSchema;
import hexlet.code.schemes.BaseSchema;

import java.util.HashMap;
import java.util.Map;

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

        assertThat(schema.contains("what")
                .isValid("what does the fox say")).isTrue();

        assertThat(schema.contains("whatthe")
                .isValid("what does the fox say")).isFalse();
    }

    @Test
    public void numberSchemaTest() {
        Validator n = new Validator();
        NumberSchema schema = n.number();

        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid("3")).isTrue();

        schema.required();
        assertThat(schema.isValid(10)).isTrue();
        assertThat(schema.positive()
                .isValid(-10)).isFalse();
        assertThat(schema.positive()
                .isValid(5)).isTrue();
    }

    @Test
    public void mapSchemaTest() {
        Validator m = new Validator();
        MapSchema schema = m.map();

        assertThat(schema.isValid(null)).isTrue();

        schema.required();

        assertThat(schema.isValid(null)).isTrue();
        Map<String, String> data = new HashMap<>();
        assertThat(schema.isValid(data)).isTrue();
        data.put("key1", "value1");
        assertThat(schema.isValid(data)).isTrue();



        Map<String, BaseSchema> schemas = new HashMap<>();

        schemas.put("name", m.string().required());
        schemas.put("age", m.number().positive());

        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertThat(schema.isValid(human1)).isTrue();

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertThat(schema.isValid(human3)).isFalse();

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        assertThat(schema.isValid(human4)).isFalse();

    }
}
