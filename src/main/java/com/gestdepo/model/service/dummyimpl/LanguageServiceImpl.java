package com.gestdepo.model.service.dummyimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.gestdepo.model.service.LanguageService;

public class LanguageServiceImpl implements LanguageService {
	
	@Override
	public List<Locale> getPossibleLanguages(Locale locale) {
		
		//TODO get languages from DDBB depending on the locale of the user
		
		List<Locale> languages = new ArrayList<Locale>();
		languages.add(new Locale("es"));
		languages.add(new Locale("en"));
		return languages;
	}
	
}
