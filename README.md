### Процедура запуска автотестов ###
#### Подготовка к запуску ####
* установить ПО среды разработки IntelliJ IDEA;
* установить Git и синхронизировать его с GitHub;
* установить Docker desktop и синхронизировать его с DockerHub 
* командой *docker pull* скачать с DockerHub следующие образы:
1. mysql:latest
2. postgres:latest
3. node:latest
#### Запуск ####
1. Запустить Docker desktop;
2. Склонировать проект и открыть его в IntelliJ IDEA;
3. Для запуска контейнеров в первой вкладке терминала IDEA ввести команду **docker-compose up**;
4. Для запуска приложения во второй вкладке терминала ввести команду:
* **Для MySQL:**
  java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar
* **Для PostgreSQL:**
  java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar
5. Для запуска автотестов в новой вкладке терминала ввести:
* **Для MySQL:**
  ./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"
* **Для PostgreSQL:**
  ./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app
6. После прогона всех тестов остановить работу контейнеров командой в терминале **docker-compose down**

