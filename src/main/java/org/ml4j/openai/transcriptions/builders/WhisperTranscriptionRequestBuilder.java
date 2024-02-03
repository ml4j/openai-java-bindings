package org.ml4j.openai.transcriptions.builders;

import org.ml4j.openai.transcriptions.WhisperTranscriptionRequest;
import org.ml4j.openai.transcriptions.WhisperTranscriptionResponseFormat;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.math.BigDecimal;

public class WhisperTranscriptionRequestBuilder {

    private String model;
    private Resource resource;

    private BigDecimal temperature;

    private String prompt;

    private WhisperTranscriptionResponseFormat responseFormat;

    private String language;


    public WhisperTranscriptionRequestBuilder(String model) {
        this.model = model;
    }

    public WhisperTranscriptionRequestBuilder withResource(Resource resource)  {
        if (this.resource != null) {
            throw new IllegalStateException("Resource already set on builder");
        }
        this.resource = resource;
        return this;
    }

    public WhisperTranscriptionRequestBuilder withFile(File file) {
        if (this.resource != null) {
            throw new IllegalStateException("Resource already set on builder");
        }
        this.resource = new FileSystemResource(file);
        return this;
    }

    public WhisperTranscriptionRequestBuilder withLanguage(String language) {
        this.language = language;
        return this;
    }

    public WhisperTranscriptionRequestBuilder withResponseFormat(WhisperTranscriptionResponseFormat responseFormat) {
        this.responseFormat = responseFormat;
        return this;
    }

    public WhisperTranscriptionRequestBuilder withPrompt(String prompt) {
        this.prompt = prompt;
        return this;
    }

    public WhisperTranscriptionRequestBuilder withTemperature(String temperature) {
        this.temperature = new BigDecimal(temperature);
        return this;
    }

    public WhisperTranscriptionRequest build() {
        WhisperTranscriptionRequest request = new WhisperTranscriptionRequest();
        request.setModel(model);
        request.setTemperature(temperature);
        request.setLanguage(language);
        request.setResponseFormat(responseFormat);
        request.setPrompt(prompt);
        request.setAudioResource(resource);
        return request;
    }
}
