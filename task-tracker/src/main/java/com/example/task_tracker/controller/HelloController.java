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
    description = "РџСЂРѕСЃС‚РµР№С€РёР№ С‚РµСЃС‚РѕРІС‹Р№ РєРѕРЅС‚СЂРѕР»Р»РµСЂ РґР»СЏ РїСЂРѕРІРµСЂРєРё, С‡С‚Рѕ API СЂР°Р±РѕС‚Р°РµС‚"
)
public class HelloController {

    @GetMapping("/api/hello") //СЃР»СѓС€Р°С‚СЊ HTTP GET-Р·Р°РїСЂРѕСЃС‹ РїРѕ РїСѓС‚Рё /api/hello;РєРѕРіРґР° РїСЂРёС…РѕРґРёС‚ Р·Р°РїСЂРѕСЃ, РІС‹РїРѕР»РЅРёС‚СЊ СЌС‚РѕС‚ РјРµС‚РѕРґ Рё РІРµСЂРЅСѓС‚СЊ РµРіРѕ СЂРµР·СѓР»СЊС‚Р°С‚.
    @Operation(
        summary = "РўРµСЃС‚РѕРІС‹Р№ endpoint",
        description = "Р’РѕР·РІСЂР°С‰Р°РµС‚ РїСЂРѕСЃС‚РѕРµ РїСЂРёРІРµС‚СЃС‚РІРµРЅРЅРѕРµ СЃРѕРѕР±С‰РµРЅРёРµ. "
                    + "РќСѓР¶РµРЅ РґР»СЏ РїСЂРѕРІРµСЂРєРё, С‡С‚Рѕ РїСЂРёР»РѕР¶РµРЅРёРµ Р·Р°РїСѓС‰РµРЅРѕ Рё РѕС‚РІРµС‡Р°РµС‚."
    )
    public String hello() {
        
        return "Hello from Task Tracker API!"; // Р’РѕР·РІСЂР°С‰Р°РµРј РїСЂРѕСЃС‚СѓСЋ СЃС‚СЂРѕРєСѓ вЂ” Spring СЃР°Рј РѕР±РµСЂРЅС‘С‚ РµС‘ РІ HTTP-РѕС‚РІРµС‚.
    }
}

