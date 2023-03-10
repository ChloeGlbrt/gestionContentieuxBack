package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Document;
import com.inti.service.interfaces.IDocumentService;

@RestController
@CrossOrigin
public class DocumentController {
	@Autowired
	IDocumentService documentService;

	@GetMapping("/documents")
	public List<Document> findAll() {
		return documentService.findAll();
	}

	@GetMapping("/documents/{idDocument}")
	public Document findOne(@PathVariable("idDocument") Long id) {
		return documentService.findOne(id);
	}

	@PostMapping("/documents")
	public Document saveDocument(@RequestBody Document document) {
		return documentService.save(document);
	}

	@DeleteMapping("/documents/{idDocument}")
	public void deleteDocument(@PathVariable("idDocument") Long id) {
		documentService.delete(id);
	}

	@PutMapping("/documents/{idDocument}")
	public Document updateDocumentWithPut(@PathVariable("idDocument") Long id, @RequestBody Document document) {
		Document currentDocument = documentService.findOne(id);
		currentDocument.setNom(document.getNom());
		currentDocument.setDescription(document.getDescription());
		return documentService.save(currentDocument);
	}

	@PatchMapping("/documents/{idDocument}")
	public Document updateDocumentWithPatch(@PathVariable("idDocument") Long id, @RequestBody Document document) {
		Document currentDocument = documentService.findOne(id);
		currentDocument.setDescription(document.getDescription());
		currentDocument.setNom(document.getNom());

		return documentService.save(currentDocument);
	}
}
