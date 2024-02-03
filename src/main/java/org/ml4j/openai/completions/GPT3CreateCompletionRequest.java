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
package org.ml4j.openai.completions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.ml4j.openai.base.GPTRequestBase;

import java.io.Serializable;

/**
 * @author Michael Lavelle
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GPT3CreateCompletionRequest extends GPTRequestBase implements Serializable {
	
	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;

	private String prompt;

	private String suffix;

	private Boolean echo;

	@JsonProperty("best_of")
	private Integer bestOf;

	public void setBestOf(Integer bestOf) {
		this.bestOf = bestOf;
	}

	public void setLogProbs(Integer logProbs) {
		this.logProbs = logProbs;
	}

	@JsonProperty("logprobs")
	private Integer logProbs;

	public Boolean getEcho() {
		return echo;
	}

	public void setEcho(Boolean echo) {
		this.echo = echo;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
}
