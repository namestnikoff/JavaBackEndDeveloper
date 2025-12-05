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

### 1. Запустить базу данных

docker compose up -d



### 2. Запустить приложение

Windows:
gradlew.bat bootRun



Linux/macOS:
./gradlew bootRun



Приложение запустится на `http://localhost:8080`

### 3. Работа со Swagger UI

#### Открыть документацию API

Swagger UI доступен по адресу: `http://localhost:8080/swagger-ui.html`

#### Как авторизоваться в Swagger UI

Большинство endpoints требуют JWT токен. Чтобы получить токен:

**Шаг 1: Зарегистрировать пользователя**

В Swagger UI найдите раздел **auth-controller** → `POST /api/auth/register`
- Нажмите "Try it out"
- Введите:
{
"email": "test@test.com",
"password": "12345"
}


- Нажмите "Execute"

**Шаг 2: Получить JWT токен**

В разделе **auth-controller** → `POST /api/auth/login`
- Нажмите "Try it out"
- Введите те же данные:
{
"email": "test@test.com",
"password": "12345"
}


- Нажмите "Execute"
- Скопируйте значение `token` из ответа (длинная строка вида `eyJhbGciOiJIUzI1NiJ9...`)

**Шаг 3: Авторизоваться**

- Нажмите кнопку **"Authorize"** (замок) справа вверху в Swagger UI
- Вставьте скопированный токен в поле **Value** (БЕЗ слова "Bearer")
- Нажмите "Authorize"
- Нажмите "Close"

Теперь все запросы будут автоматически отправляться с JWT токеном!

**Шаг 4: Тестировать endpoints**

Теперь можно тестировать любые endpoints в Swagger UI:
- `GET /api/tasks` — получить свои задачи
- `POST /api/tasks` — создать задачу
- `GET /api/groups` — получить группы
- И т.д.

#### Создание ADMIN пользователя

По умолчанию все пользователи создаются с ролью USER. Чтобы получить доступ к админским endpoints:

1. Зарегистрируйте нового пользователя `admin@admin.com`
2. Выполните в терминале:
Windows PowerShell
Invoke-RestMethod -Method Post -Uri "http://localhost:8080/api/admin/promote/1"

Linux/macOS (curl)
curl -X POST http://localhost:8080/api/admin/promote/1


(Замените `1` на ID вашего пользователя)

3. Залогиньтесь с этим пользователем и получите новый токен
4. Теперь доступны админские endpoints в разделе **admin-controller**

## Использование API через командную строку

### Регистрация пользователя

Windows PowerShell:
Invoke-RestMethod -Method Post -Uri "http://localhost:8080/api/auth/register" -ContentType "application/json" -Body '{"email":"user@example.com","password":"password123"}'



Linux/macOS:
curl -X POST http://localhost:8080/api/auth/register
-H "Content-Type: application/json"
-d '{"email":"user@example.com","password":"password123"}'



### Логин и получение токена

Windows PowerShell:
$response = Invoke-RestMethod -Method Post -Uri "http://localhost:8080/api/auth/login" -ContentType "application/json" -Body '{"email":"user@example.com","password":"password123"}'
$token = $response.token
Write-Host "Ваш токен: $token"



Linux/macOS:
curl -X POST http://localhost:8080/api/auth/login
-H "Content-Type: application/json"
-d '{"email":"user@example.com","password":"password123"}'



### Использование токена в запросах

Windows PowerShell:
$headers = @{"Authorization"="Bearer $token"}
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks" -Headers $headers



Linux/macOS:
TOKEN="your-jwt-token-here"
curl http://localhost:8080/api/tasks
-H "Authorization: Bearer $TOKEN"



## Основные endpoints

### Авторизация (доступно всем)
- `POST /api/auth/register` — регистрация
- `POST /api/auth/login` — логин

### Задачи (требуется авторизация)
- `GET /api/tasks` — получить свои задачи
- `POST /api/tasks` — создать задачу
- `PUT /api/tasks/{id}` — обновить задачу

### Группы задач (требуется авторизация)
- `GET /api/groups` — получить все группы
- `POST /api/groups` — создать группу
- `DELETE /api/groups/{id}` — удалить группу

### Админские endpoints (только для ADMIN)
- `GET /api/admin/users` — список всех пользователей
- `GET /api/admin/tasks` — все задачи в системе
- `GET /api/admin/stats` — статистика по задачам
- `POST /api/admin/promote/{userId}` — повысить пользователя до ADMIN

## Примеры запросов

### Создать задачу

POST /api/tasks
{
"title": "Изучить Spring Boot",
"description": "Пройти туториал",
"status": "PLANNED",
"groupId": 1
}



Доступные статусы: `PLANNED`, `IN_PROGRESS`, `DONE`

### Создать группу задач

POST /api/groups
{
"name": "Работа",
"description": "Рабочие задачи"
}



## База данных

Настройки подключения (см. `application.properties`):
- URL: `jdbc:postgresql://localhost:5432/tasktracker`
- User: `postgres`
- Password: `postgres`

Hibernate автоматически создаст таблицы при запуске.

Для подключения через DBeaver или pgAdmin используйте эти же параметры.

## Безопасность

- Пароли хешируются с помощью BCrypt
- JWT токены не сохраняются в БД
- Срок действия токена: 24 часа
- Разграничение доступа:
  - `/api/auth/**` — доступно всем
  - `/api/**` — только авторизованным пользователям
  - `/api/admin/**` — только пользователям с ролью ADMIN

## Структура проекта

task-tracker/
├── src/main/java/com/example/task_tracker/
│ ├── controller/ # REST контроллеры
│ ├── dto/ # Data Transfer Objects
│ ├── model/ # JPA сущности
│ ├── repository/ # Spring Data репозитории
│ ├── security/ # JWT и Spring Security
│ └── service/ # Бизнес-логика
├── src/main/resources/
│ └── application.properties
├── compose.yaml # Docker Compose для PostgreSQL
└── build.gradle



## Решение проблем

### Приложение не запускается

Проверьте, что:
1. Docker контейнер с PostgreSQL запущен: `docker ps`
2. Порт 8080 свободен
3. Java 17 установлена: `java -version`

### Ошибка подключения к БД

Перезапустите Docker контейнер:
docker compose down
docker compose up -d



### Gradle ошибки

Очистите кеш:
gradlew clean
gradlew --stop



## Автор

Система разработана как учебный проект для демонстрации навыков работы с Spring Boot, Spring Security и JWT авторизацией.