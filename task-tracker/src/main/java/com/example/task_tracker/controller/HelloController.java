package com.example.task_tracker.controller;

// Spring MVC
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// OpenAPI (springdoc)
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(
    name = "Hello",
    description = "Простейший тестовый контроллер для проверки, что API работает"
)
public class HelloController {

    @GetMapping("/api/hello") //слушать HTTP GET-запросы по пути /api/hello;когда приходит запрос, выполнить этот метод и вернуть его результат.
    @Operation(
        summary = "Тестовый endpoint",
        description = "Возвращает простое приветственное сообщение. "
                    + "Нужен для проверки, что приложение запущено и отвечает."
    )
    public String hello() {
        
        return "Hello from Task Tracker API!"; // Возвращаем простую строку — Spring сам обернёт её в HTTP-ответ.
    }
}
