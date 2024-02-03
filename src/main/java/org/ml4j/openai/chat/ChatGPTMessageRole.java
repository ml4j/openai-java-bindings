package org.ml4j.openai.chat;

public enum ChatGPTMessageRole {
    SYSTEM, USER, ASSISTANT;

    public String getRoleName() {
        return name().toLowerCase();
    }
}
