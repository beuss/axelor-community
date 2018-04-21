package fr.stlrconseil.apps.qms.module;

import com.axelor.app.AxelorModule;

import fr.stlrconseil.apps.qms.db.repo.QMSDocumentManagementRepository;
import fr.stlrconseil.apps.qms.db.repo.QMSDocumentRepository;
import fr.stlrconseil.apps.qms.service.ImprovementFormService;
import fr.stlrconseil.apps.qms.service.ImprovementFormServiceImpl;
import fr.stlrconseil.apps.qms.service.QMSDocumentService;
import fr.stlrconseil.apps.qms.service.QMSDocumentServiceImpl;
import fr.stlrconseil.apps.qms.service.QMSDocumentVersionService;
import fr.stlrconseil.apps.qms.service.QMSDocumentVersionServiceImpl;

public class QMSModule extends AxelorModule {

	@Override
	protected void configure() {
		bind(ImprovementFormService.class).to(ImprovementFormServiceImpl.class);
		bind(QMSDocumentService.class).to(QMSDocumentServiceImpl.class);
		bind(QMSDocumentVersionService.class).to(QMSDocumentVersionServiceImpl.class);
		bind(QMSDocumentRepository.class).to(QMSDocumentManagementRepository.class);
	}

}
