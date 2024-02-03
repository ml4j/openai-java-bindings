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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.ml4j.openai.base.GPTResponseBase;

/**
 * @author Michael Lavelle
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GPT3CompletionResponse extends GPTResponseBase<GPT3CompletionChoice> implements Serializable {

	@Override
	public String toString() {
		return "GPT3Response{" +
				"id='" + id + '\'' +
				", object='" + object + '\'' +
				", created=" + created +
				", model='" + model + '\'' +
				", usage=" + usage +
				", choices=" + choices +
				'}';
	}
}
