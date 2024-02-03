package org.ml4j.openai.completions.builders;

import org.ml4j.openai.base.GTPCompletionRequestBuilderBase;
import org.ml4j.openai.completions.GPT3CreateCompletionRequest;

public class GTP3CompletionRequestBuilder extends GTPCompletionRequestBuilderBase<GTP3CompletionRequestBuilder, GPT3CreateCompletionRequest> {

    private String prompt;

    private String suffix;

    private Integer bestOf;

    private Boolean echo;

    private Integer logProbs;


    public GTP3CompletionRequestBuilder(String model) {
        super(model);
    }

    public GTP3CompletionRequestBuilder withPrompt(String prompt) {
        this.prompt = prompt;
        return getInstance();
    }

    public GTP3CompletionRequestBuilder withSuffix(String suffix) {
        this.suffix = suffix;
        return getInstance();
    }

    public GTP3CompletionRequestBuilder withBestOf(int bestOf) {
        this.bestOf = bestOf;
        return getInstance();
    }

    public GTP3CompletionRequestBuilder withLogProbs(int logProbs) {
        this.logProbs = logProbs;
        return getInstance();
    }

    public GTP3CompletionRequestBuilder withEcho(boolean echo) {
        this.echo = echo;
        return getInstance();
    }

    @Override
    protected GTP3CompletionRequestBuilder getInstance() {
        return this;
    }

    public GPT3CreateCompletionRequest build() {
        GPT3CreateCompletionRequest request = new GPT3CreateCompletionRequest();
        setCommonAttributes(request);
        if (prompt != null) {
            request.setPrompt(prompt);
        }
        if (suffix != null) {
            request.setSuffix(suffix);
        }
        if (logProbs != null) {
            request.setLogProbs(logProbs);
        }
        if (bestOf != null) {
            request.setBestOf(bestOf);
        }
        if (echo != null) {
            request.setEcho(echo);
        }
        return request;
    }


}
