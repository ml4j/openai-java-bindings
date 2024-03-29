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
package org.ml4j.openai.chat;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.ml4j.openai.base.GPTRequestBase;

import java.io.Serializable;
import java.util.List;

/**
 * @author Michael Lavelle
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateChatGPTCompletionRequest extends GPTRequestBase implements Serializable {
	
	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;

	private List<ChatGTPMessage> messages;

	@Override
	public String toString() {
		return "GPT3CreateChatCompletionRequest{" +
				"messages=" + messages +
				'}';
	}

	public List<ChatGTPMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<ChatGTPMessage> messages) {
		this.messages = messages;
	}
}
