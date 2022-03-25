package com.sartorial.wordbuilder.payloads.api.response;

import java.util.List;

public class EntryResponse {

    private List<Entry> entries;

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}
