package com.sartorial.wordbuilder.controllers;

import com.sartorial.wordbuilder.payloads.api.response.Entry;
import com.sartorial.wordbuilder.utilities.StringConcatenation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

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

    @GetMapping("/thesaurus/hash/{word}")
    public String makePassword(RestTemplate restTemplate, @PathVariable String word) throws NoSuchAlgorithmException {
        String URL = THES_URL + word + "?key=" + env.getProperty("thesaur.key");
        Entry[] entries = restTemplate.getForObject(URL, Entry[].class);
        ArrayList<String> synonyms = new ArrayList<>();

        // Iterate through each entry
        for (Entry entry : entries) {
            // Find the entries whose ID matches the path variable exactly
            if (entry.getMetaData().getId().equals(word)) {
                String[][] allSynonyms = entry.getMetaData().getSynonyms();
                for (int i = 0; i < allSynonyms.length  ; i++) {
                    synonyms.addAll(Arrays.asList(allSynonyms[i]));
                }
            }
        }
        String starterString = StringConcatenation.concatenateList(synonyms);

        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] messageDigest = md.digest(starterString.getBytes());

        return StringConcatenation.toHexString(messageDigest);


    }

}