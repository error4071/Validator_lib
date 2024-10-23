# Data validator.

### Hexlet tests and linter status:
[![Actions Status](https://github.com/error4071/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/error4071/java-project-78/actions) ![Java CI](https://github.com/error4071/java-project-71/workflows/Java%20CI/badge.svg)

### Code Climate and test Coverage status:
[![Test Coverage](https://api.codeclimate.com/v1/badges/75b3f29acd1e05d8d1ef/test_coverage)](https://codeclimate.com/github/error4071/java-project-78/test_coverage)  [![Maintainability](https://api.codeclimate.com/v1/badges/75b3f29acd1e05d8d1ef/maintainability)](https://codeclimate.com/github/error4071/java-project-78/maintainability)

### Description.
Data validator is a library that can be used to check the correctness of any data. To use a validator, you need to create a validator object and define a data validation scheme. The schema is an object that contains data validation rules.

## Library Features:

1. String validation:
+ null restriction;
+ minimum length limit;
+ content limit.

2. Number validation:
+ null restriction;
+ sign limit;
+ allowable range.

3. Validation of objects of type Map:
+ null restriction;
+ size limit;
+ structure check support.

## Usage example.


    import hexlet.code.Validator;
    import hexlet.code.schemas.StringSchema;
    import hexlet.code.schemas.NumberSchema;
    import hexlet.code.schemas.MapSchema;
    import hexlet.code.schemas.BaseSchema;

    Validator v = new Validator();

    // Strings
    StringSchema schema = v.string().required().minLength(5).contains("hex");
    schema.isValid("hexlet"); // true
    schema.isValid(""); // false
    
    // Numbers
    NumberSchema schema = v.number().required().positive().range(5, 10);
    schema.isValid(-10); // false
    schema.isValid(10); // true
    
    // Map object with structure checking support
    Map<String, BaseSchema> schemas = new HashMap<>();
    schemas.put("name", v.string().required());
    schemas.put("age", v.number().positive());
    
    MapSchema schema = v.map().sizeof(2).shape(schemas);
    
    Map<String, Object> human1 = new HashMap<>();
    human1.put("name", "Kolya");
    human1.put("age", 100);
    schema.isValid(human1); // true
    
    Map<String, Object> human2 = new HashMap<>();
    human2.put("name", "");
    human2.put("age", null);
    schema.isValid(human1); // false

#### Author
Sergey Tsoy / error4071
