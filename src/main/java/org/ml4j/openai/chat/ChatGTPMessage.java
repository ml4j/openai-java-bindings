package org.ml4j.openai.chat;

import java.io.Serializable;

public class ChatGTPMessage implements Serializable {
    private String role;
    private String content;

    @Override
    public String toString() {
        return "GTP3ChatMessage{" +
                "role='" + role + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
