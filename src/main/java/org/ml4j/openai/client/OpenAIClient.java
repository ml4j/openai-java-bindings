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
package org.ml4j.openai.client;

import org.ml4j.openai.api.OpenAIApi;
import org.ml4j.openai.chat.ChatGTPCompletionResponse;
import org.ml4j.openai.chat.CreateChatGPTCompletionRequest;
import org.ml4j.openai.completions.GPT3CreateCompletionRequest;
import org.ml4j.openai.completions.GPT3CompletionResponse;
import org.ml4j.openai.transcriptions.WhisperTranscriptionRequest;
import org.ml4j.openai.transcriptions.WhisperTranscriptionResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * This is the beginnings of a client for the GPT-3 and ChatGPT APIs
 **
 * @author Michael Lavelle
 *
 */
public class OpenAIClient implements OpenAIApi {

	private RestTemplate restTemplate;
	private String apiKey;
	private String urlProtocolAndHostPrefix;
	private String organisation;
	
	public OpenAIClient(RestTemplate restTemplate, String urlProtocolAndHostPrefix, String modelName, String apiKey) {
		this.restTemplate = restTemplate;
		this.apiKey = apiKey;
		this.urlProtocolAndHostPrefix = urlProtocolAndHostPrefix;
	}

	public OpenAIClient withOrganisation(String organisation) {
		this.organisation = organisation;
		return this;
	}
	
	@Override
	public GPT3CompletionResponse getResponse(GPT3CreateCompletionRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+ apiKey);
		if (organisation != null) {
			headers.set("OpenAI-Organization", organisation);
		}
		String url = urlProtocolAndHostPrefix + "/v1/completions";
		HttpEntity<GPT3CreateCompletionRequest> entity = new HttpEntity<GPT3CreateCompletionRequest>(request,headers);
		return restTemplate.postForObject(url, entity, GPT3CompletionResponse.class);
	}

	@Override
	public ChatGTPCompletionResponse getResponse(CreateChatGPTCompletionRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+ apiKey);
		if (organisation != null) {
			headers.set("OpenAI-Organization", organisation);
		}
		String url = urlProtocolAndHostPrefix + "/v1/chat/completions";
		HttpEntity<CreateChatGPTCompletionRequest> entity = new HttpEntity<CreateChatGPTCompletionRequest>(request,headers);
		String result = restTemplate.postForObject(url, entity, String.class);
		System.out.println(result);
		return restTemplate.postForObject(url, entity, ChatGTPCompletionResponse.class);
	}

	@Override
	public WhisperTranscriptionResponse getResponse(WhisperTranscriptionRequest transcriptionRequest) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		headers.set("Authorization", "Bearer "+ apiKey);
		if (organisation != null) {
			headers.set("OpenAI-Organization", organisation);
		}

		String url = urlProtocolAndHostPrefix + "/v1/audio/transcriptions";
		MultiValueMap<String, Object> body
				= new LinkedMultiValueMap<>();
		body.add("file", transcriptionRequest.getAudioResource());
		body.add("model", transcriptionRequest.getModel());
		if (transcriptionRequest.getResponseFormat() != null) {
			body.add("response_format", transcriptionRequest.getResponseFormat().name().toLowerCase());
		}
		if (transcriptionRequest.getPrompt() != null) {
			body.add("prompt", transcriptionRequest.getPrompt());
		}
		if (transcriptionRequest.getTemperature() != null) {
			body.add("temperature", transcriptionRequest.getTemperature().toString());
		}
		if (transcriptionRequest.getLanguage() != null) {
			body.add("language", transcriptionRequest.getTemperature().toString());
		}
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(body,headers);
		return restTemplate.postForObject(url, entity, WhisperTranscriptionResponse.class);
	}

	@Override
	public String getResponseAsString(WhisperTranscriptionRequest transcriptionRequest) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		headers.set("Authorization", "Bearer "+ apiKey);
		if (organisation != null) {
			headers.set("OpenAI-Organization", organisation);
		}

		String url = urlProtocolAndHostPrefix + "/v1/audio/transcriptions";
		MultiValueMap<String, Object> body
				= new LinkedMultiValueMap<>();
		body.add("file", transcriptionRequest.getAudioResource());
		body.add("model", transcriptionRequest.getModel());
		if (transcriptionRequest.getResponseFormat() != null) {
			body.add("response_format", transcriptionRequest.getResponseFormat().name().toLowerCase());
		}
		if (transcriptionRequest.getPrompt() != null) {
			body.add("prompt", transcriptionRequest.getPrompt());
		}
		if (transcriptionRequest.getTemperature() != null) {
			body.add("temperature", transcriptionRequest.getTemperature().toString());
		}
		if (transcriptionRequest.getLanguage() != null) {
			body.add("language", transcriptionRequest.getTemperature().toString());
		}
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(body,headers);
		return restTemplate.postForEntity(url, entity, String.class).getBody();
	}

}
