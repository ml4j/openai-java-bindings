package org.ml4j.openai.transcriptions;

import java.io.Serializable;

public class WhisperTranscriptionResponse implements Serializable {
    private String text;

    public String getText() {
        return text;
    }
}
