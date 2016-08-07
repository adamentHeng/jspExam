package com.hand.dao;

import java.util.List;

import com.hand.entity.Language;

public abstract class LanguageDao {
	public abstract Language getName(Byte id);
	
	public abstract List<Language> getAll();
}
