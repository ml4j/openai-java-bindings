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
package org.ml4j.openai.api;

import org.ml4j.openai.chat.ChatGTPCompletionResponse;
import org.ml4j.openai.chat.CreateChatGPTCompletionRequest;
import org.ml4j.openai.completions.GPT3CompletionResponse;
import org.ml4j.openai.completions.GPT3CreateCompletionRequest;
import org.ml4j.openai.transcriptions.WhisperTranscriptionRequest;
import org.ml4j.openai.transcriptions.WhisperTranscriptionResponse;

/**
 * @author Michael Lavelle
 */
public interface OpenAIApi {

	GPT3CompletionResponse getResponse(GPT3CreateCompletionRequest request);
	ChatGTPCompletionResponse getResponse(CreateChatGPTCompletionRequest request);
	String getResponseAsString(WhisperTranscriptionRequest transcriptionRequest);
	WhisperTranscriptionResponse getResponse(WhisperTranscriptionRequest transcriptionRequest);

}
