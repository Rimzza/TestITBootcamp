Тестовое задание для IT BOOTCAMP. Основные ссылки для работы:
http://localhost:8080/users - для вывода всех пользователей отсортированных по email
http://localhost:8080/users/new - для создание нового пользователя
http://localhost:8080/users/{id}/edit - для изменения существующего пользователя (id - индекс пользователя)

Для создания структуры базы данныхЮ необходимо создать базу данных в MySQL и выполнить данный SQL код

CREATE TABLE `users` (

  `id` int NOT NULL AUTO_INCREMENT,
  
  `surname` varchar(40) NOT NULL,
  
  `name` varchar(20) NOT NULL,
  
  `patronymic` varchar(40) NOT NULL,
  
  `role` varchar(30) DEFAULT NULL,
  
  `email` varchar(50) NOT NULL,
  
  PRIMARY KEY (`id`)

  В файле application.properties во пути src/main/resource, для работы, необходимо заполнить данные 

spring.datasource.url

spring.datasource.password

spring.datasource.username

