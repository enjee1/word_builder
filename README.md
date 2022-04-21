# word_builder

A simple web service using the Merriam-Webster dictionary and thesaurus APIs to model word entries into Java objects.

Current features include:
- Transforming a seed word into a password-like string. 
  - This is achieved by finding the synonyms of the seed word, concatenating those synonyms into a single string then using MD5 hash function to return the hash value of the string.  
