package org.ml4j.openai.chat.builders;

import org.ml4j.openai.chat.ChatGPTMessageRole;
import org.ml4j.openai.chat.ChatGTPMessage;

public class ChatGTPMessageBuilder {

    private String content;
    private ChatGPTMessageRole role;

    public ChatGTPMessageBuilder(ChatGPTMessageRole role, String content) {
        this.content = content;
        this.role = role;
    }

    public ChatGTPMessage build() {
        ChatGTPMessage message = new ChatGTPMessage();
        message.setRole(role.getRoleName());
        message.setContent(content);
        return message;
    }

}
