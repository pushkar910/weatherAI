package org.pushkar.weatherai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIChatService {

    private ChatClient chatClient;

    AIChatService(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    public String getWeatherInfo(String query){
        return chatClient.prompt(query)
                .functions("getWeather")
                .call().content();
    }

    public String getAIResponse(String message) {
        return chatClient.prompt(message).call().content();
    }
}
