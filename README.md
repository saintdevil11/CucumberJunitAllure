Проект пример1

Сборка: java8, junit5, selenide, rest assured, cucumber, allure
Сборка выполнена на указании входных констант через test.properties напрямую

#Запуск -
mvn clean test -Dcucumber.filter.tags="@001ui"

#Построение отчета -
mvn allure:serve

#Пареллельный запуск -
в pom файле меняется значение у parallelCount
или в строке запуска -DparallelCount=3

#Для запуска на selenoid
локально: в проперти разкомментировать строку remote.url
или в строке запуска -Dremote.url=http://*******