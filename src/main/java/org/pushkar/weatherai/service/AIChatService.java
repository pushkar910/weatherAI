package org.pushkar.weatherai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class AIChatService {

    private ChatClient chatClient;

    AIChatService(ChatClient.Builder builder){
        this.chatClient = builder
                .defaultSystem("You are a helpful AI assistant helping people with their queries")
                .defaultFunctions("currentWeatherFunction","fetchJobsRelatedToKeyword")
                .build();
    }

    public Flux<String> getAIResponse(String message) {
        return chatClient.prompt()
                .user(message)
                .stream()
                .content();
    }
}
