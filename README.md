### Hexlet tests and linter status:
[![Actions Status](https://github.com/error4071/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/error4071/java-project-78/actions) ![Java CI](https://github.com/error4071/java-project-71/workflows/Java%20CI/badge.svg)

### Code Climate and test Coverage status:
[![Test Coverage](https://api.codeclimate.com/v1/badges/75b3f29acd1e05d8d1ef/test_coverage)](https://codeclimate.com/github/error4071/java-project-78/test_coverage)  [![Maintainability](https://api.codeclimate.com/v1/badges/75b3f29acd1e05d8d1ef/maintainability)](https://codeclimate.com/github/error4071/java-project-78/maintainability)

## Валидатор данных.

Данный проект - библиотека, предназначенная для валидации данных по заданным критериям. Всего реализовано три типа даннх (Map, String, Integer).

## Список схем для валидации:

#### 1) StringScheme
#### 2) NumberScheme
#### 3) MapScheme

## Описание функций.

### 1. StringSchema содержит такой набор методов:

+ required() — делает данные обязательными для заполнения. Иными словами добавляет в схему ограничение, которое не позволяет использовать null или пустую строку в качестве значения
+ minLength() — добавляет в схему ограничение минимальной длины для строки. Строка должна быть равна или длиннее указанного числа
+ contains() — добавляет в схему ограничение по содержимому строки. Строка должна содержать определённую подстроку.

### 2. NumberSchema содержит такой набор методов:

+ required() — добавляет в схему ограничение, которое не позволяет использовать null в качестве значения
+ positive() — добавляет ограничение на знак числа. Число должно быть положительным
+ range() — добавляет допустимый диапазон, в который должно попадать значение числа включая границы.

### 3. MapSchema содержит следующие методы:

+ required() — добавляет в схему ограничение, которое не позволяет использовать null в качестве значения. Требуется тип данных Map
+ sizeof() — добавляет ограничение на размер словаря. Количество пар ключ-значений в объекте Map должно быть равно заданному.