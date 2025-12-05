package com.example.task_tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(
    name = "Hello",
    description = "Простейший тестовый контроллер для проверки работы API"
)
public class HelloController {

    @GetMapping("/api/hello")
    @Operation(
        summary = "Тестовый endpoint",
        description = "Возвращает приветственное сообщение для проверки, что приложение запущено"
    )
    public String hello() {
        return "Hello from Task Tracker API!";
    }
}
