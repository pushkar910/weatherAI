package org.pushkar.weatherai.controller;


import org.pushkar.weatherai.service.AIChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai-chat")
public class AIChatController {

    private final AIChatService aiChatService;

    public AIChatController(AIChatService aiChatService) {
        this.aiChatService = aiChatService;
    }


    @GetMapping
    public Flux<String> getAIChatResponse(@RequestParam String message) {
        return aiChatService.getAIResponse(message);
    }


}
