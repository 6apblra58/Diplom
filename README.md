# Дипломный проект профессии «Тестировщик ПО»
## О проекте
Дипломный проект представляет собой автоматизацию тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.
База данных хранит информацию о заказах, платежах, статусах карт, способах оплаты.
Приложение предлагает купить тур по определённой цене с помощью двух способов:

1. Обычная оплата по дебетовой карте
2. Уникальная технология: выдача кредита по данным банковской карты

Данные по картам обрабатываются отдельными сервисами:

* Сервис платежей - Payment Gate
* Кредитный сервис - Credit Gate

Полные условия и все исходные данные можно посмотреть по ![ссылке](https://github.com/netology-code/qa-diploma)
## Запуск приложения
1. Запустить необходимые базы данных. Параметры для запуска хранятся в файле *docker-compose.yml*. Для запуска необходимо ввести в терминале команду:
*docker-compose up*
2. В новой вкладке терминала ввести следующую команду в зависимости от базы данных:
* ***java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app_db -jar artifacts/aqa-shop.jar*** - для базы данных MySQL
* ***java -Dspring.datasource-postgresql.url=jdbc:postgresql://localhost:5432/app_db -jar artifacts/aqa-shop.jar*** - для базы данных PostgreSQL
3. Приложение должно запуститься по адресу http://localhost:8080/

## Запуск тестов
В новой вкладке терминала ввести команду, в зависимости от запущенной БД, в п.2 запуска:
* ***gradlew clean test -Ddb.url=jdbc:mysql://localhost:3306/app_db*** - для MySQL
* ***gradlew clean test -Ddb.url=jdbc:postgresql://localhost:5432/app_db*** - для PostgreSQL

## Формирование отчета AllureReport
В новой вкладке терминала или нажав двойной Ctrl ввести команду:
* ***gradlew AllureServe***
## Документация
![План автоматизации тестирования веб-формы сервиса покупки туров интернет-банка](https://github.com/6apblra58/Diplom/blob/master/reports/Plan.md)

![Отчет о проведенном тестировании](https://github.com/6apblra58/Diplom/blob/master/reports/Report.md)

![Отчетный документ по итогам автоматизации](https://github.com/6apblra58/Diplom/blob/master/reports/Summary.md)
