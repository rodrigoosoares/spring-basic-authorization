# Initialize the Application

## 1. Start MongoDB docker container
```shell
docker-compose up -f docker/docker-compose.yml
```

## 2. Execute the application
```shell
./gradlew bootRun
```

# Application features

This application implements the Spring Security Basic Authentication. It has an MongoDB Docker container that pre load 2
Users, one Admin and another a common user.

A Custom UserDetailService ([MongoUserDetailsService](src/main/java/com/personal/study/basicauthorizationapp/commons/security/services/MongoUserDetailsService.java)) is used to retrieve the users information from the MongoDB

More information at: https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/index.html
## 1. Get User by username endpoint
This endpoint access any authenticated user, regardless of role (USER or ADMIN)
```shell
curl --location 'http://localhost:8080/user?username=Admin' \
--header 'Authorization: Basic QWRtaW46MTIz'
```
```shell
curl --location 'http://localhost:8080/user?username=Admin' \
--header 'Authorization: Basic Um9kcmlnbzoxMjM='
```

## 2. Create a new user
This endpoint can only be accessed by an user with ADMIN role
```shell
curl --location 'http://localhost:8080/user' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic QWRtaW46MTIz' \
--data '{
    "username": "New User",
    "password": "Pass123",
    "roles": [ "USER" ]
}'
```

So if you try to access using the user authentication, a 401 status will be returned
```shell
curl --location 'http://localhost:8080/user' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic VXNlcjoxMjM=' \
--data '{
    "username": "New User",
    "password": "Pass123",
    "roles": [ "USER" ]
}'
```