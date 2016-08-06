package com.hand.service;

import com.hand.dao.LanguageDao;
import com.hand.dao.impl.LanguageDaoImpl;
import com.hand.entity.Language;

public class LanguageService {
	private LanguageDao languageDao = new LanguageDaoImpl();
	
	public Language getName(Byte id){
		return languageDao.getName(id);
	}
}
