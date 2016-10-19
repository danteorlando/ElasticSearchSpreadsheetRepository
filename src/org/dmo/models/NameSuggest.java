package org.dmo.models;

import java.util.ArrayList;
import java.util.List;

public class NameSuggest {
	
	public List<String> input;

    public String output;

    public NameSuggestPayload payload;

    public NameSuggest() {
      this.input = new ArrayList<String>();
      this.output = "";
      this.payload = new NameSuggestPayload("");
    }

    public NameSuggest(String display, String payloadUri) {
      this.input = new ArrayList<String>();
      this.output = display;
      this.payload = new NameSuggestPayload(payloadUri);
    }

    public void setSuggestionInputStrings(String[] inputValues) {
      for (int i = 0; i < inputValues.length; i++)
        this.input.add(inputValues[i]);
    }

    public void setPayloadId(String payloadUri) {
      this.payload.uri = payloadUri;
    }
}
