package com.sartorial.wordbuilder.controllers;

import com.sartorial.wordbuilder.models.dictionary.DictionaryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private final static String DICT_URL = "https://www.dictionaryapi.com/api/v3/references/collegiate/json/";
    private final static String THES_URL = "https://www.dictionaryapi.com/api/v3/references/thesaurus/json/";


    @GetMapping("/")
    public String getRootRoute() { return "Root Route";}

    @GetMapping("/dictionary/{word}")
    public Object[] getEntry(RestTemplate restTemplate, @PathVariable String word) {
        String URL = DICT_URL + word + "?key=" + env.getProperty("diction.key");
        Object[] entry = restTemplate.getForObject(URL, Object[].class);
        return  entry;
    }


}