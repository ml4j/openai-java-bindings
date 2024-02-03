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

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.ml4j.openai.base.GPTChoiceBase;

/**
 * @author Michael Lavelle
 */
public class GPT3CompletionChoice extends GPTChoiceBase implements Serializable {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("logprobs")
	private Float logprobs;

	public Float getLogprobs() {
		return logprobs;
	}

	public int getIndex() {
		return index;
	}

	private int index;

	private String text;

	public String getText() {
		return text;
	}

	public Float getLogProbs() {
		return logprobs;
	}

	@Override
	public String toString() {
		return "GPT3Choice{" +
				"logprobs=" + logprobs +
				", text='" + text + '\'' +
				", finishReason='" + finishReason + '\'' +
				'}';
	}
}
