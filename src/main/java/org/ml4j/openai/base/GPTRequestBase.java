/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.ml4j.openai.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Michael Lavelle
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GPTRequestBase implements Serializable {
	
	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("max_tokens")
	private Integer maxTokens;
	@JsonProperty("top_p")
	private BigDecimal topP;
	private Integer n;
	private Boolean stream;
	private List<String> stop;
	private BigDecimal temperature;

	private String user;

	@JsonIgnore
	private BigDecimal presencePenalty;

	@JsonIgnore
	private BigDecimal frequencyPenalty;

	@JsonProperty("logit_bias")
	private Map<String,BigDecimal> logitBias;

	public void setUser(String user) {
		this.user = user;
	}

	public void setPresencePenalty(BigDecimal presencePenalty) {
		this.presencePenalty = presencePenalty;
	}

	public void setFrequencyPenalty(BigDecimal frequencyPenalty) {
		this.frequencyPenalty = frequencyPenalty;
	}

	public void setLogitBias(Map<String, BigDecimal> logitBias) {
		this.logitBias = logitBias;
	}

	private String model;

	public Integer getMaxTokens() {
		return maxTokens;
	}
	public void setMaxTokens(Integer maxTokens) {
		this.maxTokens = maxTokens;
	}
	public BigDecimal getTemperature() {
		return temperature;
	}
	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigDecimal getTopP() {
		return topP;
	}
	public void setTopP(BigDecimal topP) {
		this.topP = topP;
	}
	public Integer getN() {
		return n;
	}
	public void setN(Integer n) {
		this.n = n;
	}
	public Boolean getStream() {
		return stream;
	}
	public void setStream(Boolean stream) {
		this.stream = stream;
	}
	public List<String> getStop() {
		return stop;
	}
	public void setStop(List<String> stop) {
		this.stop = stop;
	}


	@Override
	public String toString() {
		return "GPT3RequestBase{" +
				"maxTokens=" + maxTokens +
				", topP=" + topP +
				", n=" + n +
				", stream=" + stream +
				", stop='" + stop + '\'' +
				", temperature=" + temperature +
				", presencePenalty=" + presencePenalty +
				", frequencyPenalty=" + frequencyPenalty +
				", logitBias=" + logitBias +
				", user='" + user + '\'' +
				", model='" + model + '\'' +
				'}';
	}
}
