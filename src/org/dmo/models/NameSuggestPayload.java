package org.dmo.models;

public class NameSuggestPayload {
	public String uri;

    public NameSuggestPayload() {
      this.uri = "";
    }

    public NameSuggestPayload(String payloadUri) {
      this.uri = payloadUri;
    }
}
