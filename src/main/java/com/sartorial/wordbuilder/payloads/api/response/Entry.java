package com.sartorial.wordbuilder.payloads.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Entry {

    private Meta metaData;
    private String partOfSpeech;
    private String[] shortDef;
    public Meta getMetaData() {
        return metaData;
    }

    // The below annotation is used to change the default key name when serializing JSON from the external API.
    @JsonProperty("meta")
    public void setMetaData(Meta metaData) {
        this.metaData = metaData;
    }
    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    // The below annotation is used to change the default key name when serializing JSON from the external API.
    @JsonProperty("fl")
    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }
    public String[] getShortDef() {
        return shortDef;
    }

    // The below annotation is used to change the default key name when serializing JSON from the external API.
    @JsonProperty("shortdef")
    public void setShortDef(String[] shortDef) {
        this.shortDef = shortDef;
    }

    public static class Meta{
        private String id;
        private String uuid;
        private String source;
        private String[] stems;
        //This field is only populated when the entry is from the thesaurus
        private String[][] synonyms;
        //This field is only populated when the entry is from the thesaurus
        private String[][] antonyms;

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

        public String[][] getSynonyms() {
            return synonyms;
        }

        @JsonProperty("syns")
        public void setSynonyms(String[][] synonyms) {
            this.synonyms = synonyms;
        }

        public String[][] getAntonyms() {
            return antonyms;
        }

        @JsonProperty("ants")
        public void setAntonyms(String[][] antonyms) {
            this.antonyms = antonyms;
        }
    }

}
