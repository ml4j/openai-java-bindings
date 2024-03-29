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

import org.ml4j.openai.base.GPTChoiceBase;

import java.io.Serializable;

/**
 * @author Michael Lavelle
 */
public class ChatGPTChoice extends GPTChoiceBase implements Serializable {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;

	public int getIndex() {
		return index;
	}

	private int index;

	private ChatGTPMessage message;

	public ChatGTPMessage getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "ChatGPTChoice{" +
				"index=" + index +
				", message=" + message +
				", finishReason='" + finishReason + '\'' +
				'}';
	}
}
