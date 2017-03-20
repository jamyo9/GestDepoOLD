package com.gestdepo.model.service;

import java.util.List;
import java.util.Locale;

public interface LanguageService {
	
	public List<Locale> getPossibleLanguages(Locale locale);
		
}
