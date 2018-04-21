package fr.stlrconseil.apps.qms.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

import fr.stlrconseil.apps.qms.db.QMSDocument;
import fr.stlrconseil.apps.qms.db.QMSProcess;
import fr.stlrconseil.apps.qms.db.repo.QMSProcessRepository;

@Singleton
public class QMSDocumentServiceImpl implements QMSDocumentService {
	protected QMSProcessRepository processRepository;

	@Inject
	public QMSDocumentServiceImpl(QMSProcessRepository processRepository) {
		this.processRepository = processRepository;
	}

	@Override
	@Transactional
	public void addDocumentToProcess(QMSDocument document) {
		if(document.getProcesses().size() == 1 && document.getProcesses().contains(document.getProcess())) {
			return;
		}
		for(final QMSProcess process : document.getProcesses()) {
			process.removeDocument(document);
			processRepository.save(process);
		}
		document.getProcess().addDocument(document);
		processRepository.save(document.getProcess());
	}
}
