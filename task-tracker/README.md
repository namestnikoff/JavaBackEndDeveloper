# Task Tracker API

Бэкенд-сервис для управления задачами с JWT авторизацией.

## Технологии

- Java 17
- Spring Boot 3.5.7
- Spring Data JPA
- Spring Security + JWT
- PostgreSQL 16
- Docker Compose
- Gradle

## Требования

- Java 17+
- Docker Desktop
- Gradle (или используйте gradlew)

## Запуск проекта

### 1.Запустить базу данных

docker compose up -d



### 2.Запустить приложение

Windows:
gradlew.bat bootRun


Linux/macOS:
./gradlew bootRun



Приложение запустится на `http://localhost:8080`

### 3. Документация API

Swagger UI доступен по адресу: `http://localhost:8080/swagger-ui.html`

## Использование API

### Регистрация пользователя

POST /api/auth/register
Content-Type: application/json

{
"email": "user@example.com",
"password": "password123"
}



### Логин

POST /api/auth/login
Content-Type: application/json

{
"email": "user@example.com",
"password": "password123"
}



Ответ:
{
"token": "eyJhbGciOiJIUzI1NiJ9..."
}



### Работа с задачами (требуется авторизация)
Все запросы должны содержать заголовок:
Authorization: Bearer <your-jwt-token>



#### Получить свои задачи
GET /api/tasks



#### Создать задачу
POST /api/tasks
Content-Type: application/json

{
"title": "Новая задача",
"description": "Описание",
"status": "PLANNED",
"groupId": 1
}



Статусы: `PLANNED`, `IN_PROGRESS`, `DONE`

#### Обновить задачу
PUT /api/tasks/{id}
Content-Type: application/json

{
"title": "Обновленная задача",
"description": "Новое описание",
"status": "IN_PROGRESS",
"groupId": 1
}



### Работа с группами

#### Получить все группы
GET /api/groups



#### Создать группу
POST /api/groups
Content-Type: application/json

{
"name": "Работа",
"description": "Рабочие задачи"
}


#### Удалить группу
DELETE /api/groups/{id}



### Админские endpoints (требуется роль ADMIN)

#### Список всех пользователей
GET /api/admin/users



#### Все задачи системы
GET /api/admin/tasks



#### Статистика по задачам
GET /api/admin/stats



Возвращает количество задач по каждому статусу.

#### Повысить пользователя до ADMIN
POST /api/admin/promote/{userId}



## Структура проекта

task-tracker/
├── src/main/java/com/example/task_tracker/
│ ├── controller/ # REST контроллеры
│ ├── dto/ # Data Transfer Objects
│ ├── model/ # JPA сущности
│ ├── repository/ # Spring Data репозитории
│ ├── security/ # JWT и Spring Security конфигурация
│ └── service/ # Бизнес-логика
├── src/main/resources/
│ └── application.properties
├── compose.yaml # Docker Compose для PostgreSQL
└── build.gradle



## База данных

Настройки подключения (см. `application.properties`):
- URL: `jdbc:postgresql://localhost:5432/tasktracker`
- User: `postgres`
- Password: `postgres`

Hibernate автоматически создаст таблицы при запуске (`spring.jpa.hibernate.ddl-auto=update`).

## Безопасность

- Пароли хешируются с помощью BCrypt
- JWT токены не сохраняются
- Срок действия токена: 24 часа
- азграничение доступа:
  - `/api/auth/**` — доступно всем
  - `/api/**` — только авторизованным пользователям
  - `/api/admin/**` — только пользователям с ролью ADMIN

## Примеры запросов (PowerShell)

Регистрация
Invoke-RestMethod -Method Post -Uri "http://localhost:8080/api/auth/register" -ContentType "application/json" -Body '{"email":"user@test.com","password":"12345"}'

Логин и получение токена
$response = Invoke-RestMethod -Method Post -Uri "http://localhost:8080/api/auth/login" -ContentType "application/json" -Body '{"email":"user@test.com","password":"12345"}'
$token = $response.token

Использование токена
$headers = @{"Authorization"="Bearer $token"}
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks" -Headers $headers



## Автор

Система разработана как учебный проект для демонстрации навыков работы с Spring Boot, Spring Security и JWT.