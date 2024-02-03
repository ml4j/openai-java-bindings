package org.ml4j.openai.transcriptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.core.io.Resource;

import java.math.BigDecimal;

public class WhisperTranscriptionRequest {
    @JsonProperty("file")
    private Resource audioResource;
    private String model;

    @JsonProperty("response_format")
    private WhisperTranscriptionResponseFormat responseFormat;

    private BigDecimal temperature;

    private String prompt;

    private String language;

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Resource getAudioResource() {
        return audioResource;
    }

    public WhisperTranscriptionResponseFormat getResponseFormat() {
        return responseFormat;
    }

    public void setResponseFormat(WhisperTranscriptionResponseFormat responseFormat) {
        this.responseFormat = responseFormat;
    }

    public void setAudioResource(Resource audioResource) {
        this.audioResource = audioResource;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
