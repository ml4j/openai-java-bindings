package org.ml4j.openai.completions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class GPT3CompletionResponseSerializationTest {

  @Test
    public void testResponseDeserialization() throws JsonProcessingException {
      String response = "{\"id\":\"cmpl-6yTDM4daLmH3JcN7jRrjbofv44Jl9\",\"object\":\"text_completion\",\"created\":1679870000,\"model\":\"text-curie-001\",\"choices\":[{\"text\":\"\\nThe song 'Hey Jude' was written by the Beatles.\",\"index\":0,\"logprobs\":null,\"finish_reason\":\"stop\"}],\"usage\":{\"prompt_tokens\":157,\"completion_tokens\":13,\"total_tokens\":170}}";
      ObjectMapper objectMapper = new ObjectMapper();
      GPT3CompletionResponse resp = objectMapper.readValue(response, GPT3CompletionResponse.class);
      System.out.println(resp);
  }
}
