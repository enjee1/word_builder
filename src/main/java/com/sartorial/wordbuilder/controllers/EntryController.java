package com.sartorial.wordbuilder.controllers;

import com.sartorial.wordbuilder.payloads.api.response.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/mw")
public class EntryController {

    @Autowired
    private Environment env;

    private final String DICT_URL = "https://www.dictionaryapi.com/api/v3/references/collegiate/json/";
    private final String THES_URL = "https://www.dictionaryapi.com/api/v3/references/thesaurus/json/";

    @GetMapping("/dictionary/{word}")
    public Entry[] getDictEntry(RestTemplate restTemplate, @PathVariable String word) {
        String URL = DICT_URL + word + "?key=" + env.getProperty("diction.key");
        return restTemplate.getForObject(URL, Entry[].class);
    }

    @GetMapping("/thesaurus/{word}")
    public Entry[] getThesEntry(RestTemplate restTemplate, @PathVariable String word) {
        String URL = THES_URL + word + "?key=" + env.getProperty("thesaur.key");
        return restTemplate.getForObject(URL, Entry[].class);
    }


}