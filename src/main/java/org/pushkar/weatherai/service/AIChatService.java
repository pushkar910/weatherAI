package org.pushkar.weatherai.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
@Slf4j
public class AIChatService {

    private ChatClient chatClient;

    AIChatService(ChatClient.Builder builder){
        this.chatClient = builder
                .defaultSystem("You are an advanced AI assistant integrated into a Spring Boot application. Use external tools when needed instead of making assumptions. Available tools: currentWeatherFunction - Fetches real-time weather for a given location. The user must provide a city or region to get an accurate weather update. If required data is missing, ask the user to provide it. Ensure clarity and accuracy in responses.")
                .defaultFunctions("currentWeatherFunction")
                .build();
    }

    public Flux<String> getAIResponse(String message) {
        try {
            return chatClient.prompt()
                    .user(message)
                    .stream()
                    .content()
                    .cache(Duration.ofMinutes(5));
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching AI response, ex = " + e.getMessage());
        }
    }
}
