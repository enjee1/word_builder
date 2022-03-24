package com.sartorial.wordbuilder.models.dictionary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DictionaryEntry {
    private Meta[] metadata;
    /*
    When a headword is a less common spelling of another word with the same meaning, there will be a cognate
    cross-reference pointing to the headword with the more common spelling. A set of cognate cross-references
    is contained in a cxs.
     */
    private Object[] cxs;
    private String partOfSpeech;
    private String[] definition;

    class Meta {
        private String id;
        private String uuid;
        private String source;
        private String[] stems;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getSource() {
            return source;
        }

        // The below annotation is used to change the default key name when serializing JSON from the external API.
        @JsonProperty("src")
        public void setSource(String source) {
            this.source = source;
        }

        public String[] getStems() {
            return stems;
        }

        public void setStems(String[] stems) {
            this.stems = stems;
        }
    }

    /*public Meta getMetadata() {
        return metadata;
    }

    // The below annotation is used to change the default key name when serializing JSON from the external API.
    @JsonProperty("meta")
    public void setMetadata(Meta metadata) {
        this.metadata = metadata;
    }*/

    public Meta[] getMetadata() {
        return metadata;
    }

    // The below annotation is used to change the default key name when serializing JSON from the external API.
    @JsonProperty("meta")
    public void setMetadata(Meta[] metadata) {
        this.metadata = metadata;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    // The below annotation is used to change the default key name when serializing JSON from the external API.
    @JsonProperty("fl")
    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public String[] getDefinition() {
        return definition;
    }

    // The below annotation is used to change the default key name when serializing JSON from the external API.
    @JsonProperty("shortdef")
    public void setDefinition(String[] definition) {
        this.definition = definition;
    }
}
