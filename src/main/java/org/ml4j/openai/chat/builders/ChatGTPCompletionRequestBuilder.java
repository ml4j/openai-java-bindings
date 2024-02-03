package org.ml4j.openai.chat.builders;

import org.ml4j.openai.base.GTPCompletionRequestBuilderBase;
import org.ml4j.openai.chat.ChatGPTMessageRole;
import org.ml4j.openai.chat.ChatGTPMessage;
import org.ml4j.openai.chat.CreateChatGPTCompletionRequest;
import java.util.ArrayList;
import java.util.List;

public class ChatGTPCompletionRequestBuilder extends GTPCompletionRequestBuilderBase<ChatGTPCompletionRequestBuilder, CreateChatGPTCompletionRequest> {

    private List<ChatGTPMessage> messages;

    public ChatGTPCompletionRequestBuilder(String model, List<ChatGTPMessage> initialMessages) {
        super(model);
        this.messages = new ArrayList<>();
        if (!initialMessages.isEmpty()) {
            this.messages.addAll(initialMessages);
        }}
    public ChatGTPCompletionRequestBuilder(String model) {
        this(model, new ArrayList<>());
    }

    @Override
    protected ChatGTPCompletionRequestBuilder getInstance() {
        return this;
    }

    public ChatGTPCompletionRequestBuilder addChatGTPMessage(ChatGTPMessage message) {
        this.messages.add(message);
        return this;
    }

    public ChatGTPCompletionRequestBuilder addChatGTPMessage(ChatGPTMessageRole role, String content) {
        this.messages.add(new ChatGTPMessageBuilder(role, content).build());
        return this;
    }

    public CreateChatGPTCompletionRequest build() {
        CreateChatGPTCompletionRequest request = new CreateChatGPTCompletionRequest();
        setCommonAttributes(request);
        request.setMessages(messages);
        return request;
    }


}
