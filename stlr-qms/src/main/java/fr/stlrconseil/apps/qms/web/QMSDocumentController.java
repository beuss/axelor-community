package fr.stlrconseil.apps.qms.web;

import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import fr.stlrconseil.apps.qms.db.QMSDocument;
import fr.stlrconseil.apps.qms.db.repo.QMSDocumentRepository;
import fr.stlrconseil.apps.qms.service.QMSDocumentService;

@Singleton
public class QMSDocumentController {
	protected QMSDocumentRepository documentRepository;
	protected QMSDocumentService documentService;

	@Inject
	public QMSDocumentController(QMSDocumentRepository documentRepository, QMSDocumentService documentService) {
		this.documentRepository = documentRepository;
		this.documentService = documentService;
	}



	public void addDocumentToProcess(ActionRequest request, ActionResponse response) {
		QMSDocument document = documentRepository.find(request.getContext().asType(QMSDocument.class).getId());
		documentService.addDocumentToProcess(document);
	}
}
