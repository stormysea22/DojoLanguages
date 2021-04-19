package com.theismann.dojolanguages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.theismann.dojolanguages.models.Language;
import com.theismann.dojolanguages.repositories.LanguageRepository;

@Service
public class LanguageService {
	 // adding the book repository as a dependency
    private final LanguageRepository languageRepository;
    
    //this is constructor
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the books
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a book
    public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }
    // retrieves a book
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
     // update book
	public Language updateLanguage(Long id, String name, String creator, Integer version) {
		Language toUpdate = this.languageRepository.findById(id).orElse(null);
		if(toUpdate == null) {
			return null;
		} else{
			toUpdate.setName(name);
			toUpdate.setCreator(creator);
			toUpdate.setVersion(version);
			
		 return this.languageRepository.save(toUpdate);
		}
	}
	
	public Language updateLanguage(Language language) {
		return this.languageRepository.save(language);
	}
	
	public void deleteLanguage(Long id) {
		this.languageRepository.deleteById(id);		
	}
	
}
