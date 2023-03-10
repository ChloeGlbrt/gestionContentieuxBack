package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Document;

public interface IDocumentService {

	List<Document> findAll();

	Document findOne(Long id);

	Document save(Document document);

	void delete(Long id);

}
