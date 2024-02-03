package org.ml4j.openai.base;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class GTPCompletionRequestBuilderBase<B extends GTPCompletionRequestBuilderBase, R extends GPTRequestBase> {

    protected String model;

    private BigDecimal temperature;

    private Integer maxTokens;
    private BigDecimal topP;
    private Integer n;
    private Boolean stream;
    private List<String> stop;

    private String user;

    private BigDecimal presencePenalty;

    private BigDecimal frequencyPenalty;

    private Map<String, BigDecimal> logitBias;


    public GTPCompletionRequestBuilderBase(String model) {
        this.model = model;
    }

    protected abstract B getInstance();

    public B withMaxTokens(int maxTokens) {
        this.maxTokens = maxTokens;
        return getInstance();
    }

    public B withTopP(String topP) {
        this.topP = new BigDecimal(topP);
        return getInstance();
    }

    public B withLogitBias(Map<String, BigDecimal> logitBias) {
        this.logitBias = logitBias;
        return getInstance();
    }

    public B withStream(boolean stream) {
        this.stream = stream;
        return getInstance();
    }
    public B withStop(String... stop) {
        this.stop = Arrays.asList(stop);
        return getInstance();
    }

    public B withUser(String user) {
        this.user = user;
        return getInstance();
    }

    public B withPresencePenalty(String presencePenalty) {
        this.presencePenalty = new BigDecimal(presencePenalty);
        return getInstance();
    }

    public B withFrequencyPenalty(String frequencyPenalty) {
        this.frequencyPenalty = new BigDecimal(frequencyPenalty);
        return getInstance();
    }

    public B withN(int n) {
        this.n = n;
        return getInstance();
    }

    public B withTemperature(String temperature) {
        this.temperature = new BigDecimal(temperature);
        return getInstance();
    }

    protected void setCommonAttributes(R request) {
        request.setModel(model);
        if (temperature != null) {
            request.setTemperature(temperature);
        }
        if (maxTokens != null) {
            request.setMaxTokens(maxTokens);
        }
        if (topP != null) {
            request.setTopP(topP);
        }
        if (stream != null) {
            request.setStream(stream);
        }
        if (stop != null && !stop.isEmpty()) {
            request.setStop(stop);
        }
        if (user != null) {
            request.setUser(user);
        }
        if (user != null) {
            request.setUser(user);
        }
        if (presencePenalty != null) {
            request.setPresencePenalty(presencePenalty);
        }
        if (frequencyPenalty != null) {
            request.setFrequencyPenalty(frequencyPenalty);
        }
        if (logitBias != null) {
            request.setLogitBias(logitBias);
        }
    }

    public abstract R build();

}
