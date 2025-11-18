package com.example.SpringAI_Tutorial.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatClient chatClient;
    private final OpenAiImageModel imageModel;

//    public ChatController(OpenAiChatModel openAiChatModel) {
//        this.chatClient = ChatClient.create(openAiChatModel); // static method
//    }

    public ChatController(OpenAiChatModel openAiChatModel, ChatClient.Builder builder, OpenAiImageModel imageModel) {
        this.imageModel = imageModel;
        this.chatClient = builder.build(); // static method
    }

    @GetMapping("/api/{prompt}")
    public String generateResult(@PathVariable("prompt") String prompt) {
        return chatClient.prompt(prompt).call().content();
    }

    @GetMapping("/image/{prompt}")
    public String generateImage(@PathVariable("prompt") String prompt)
    {
        ImagePrompt imagePrompt = new ImagePrompt(prompt);
        ImageResponse imageResponse = imageModel.call(imagePrompt);
        System.out.println(imageResponse.getResult().getMetadata());
        String url = imageResponse.getResult().getOutput().getUrl();
        return url;
    }
}
