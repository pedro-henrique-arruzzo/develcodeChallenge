# Develcode Challenge - Backend Position

This application was developed as a test for Develcode

## Used Stack

• Spring boot
• Java 11
• PostgreSQL

## Steps to run the application

1 - Run the DB via Docker

```docker run --name challenge -e "POSTGRES_PASSWORD=admin123" -e "POSTGRES_DB=challenge" -p 5432:5432 -d postgres```

2 - Run the application

```./mvnw spring-boot:run```

## How to test

First ensure the app is running in port 8081

Then, use Postman to run the tests

![image](https://user-images.githubusercontent.com/76009721/136308814-74f043cb-3051-4e9a-969a-84c2f789ad1d.png)

The results should be like this

![image](https://user-images.githubusercontent.com/76009721/136308863-ce46fd60-c59a-470b-88a7-9e04f754baaf.png)
