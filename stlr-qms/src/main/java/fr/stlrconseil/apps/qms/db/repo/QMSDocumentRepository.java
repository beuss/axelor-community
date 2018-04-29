package fr.stlrconseil.apps.qms.db.repo;

import javax.persistence.PersistenceException;

import com.axelor.apps.base.service.administration.SequenceService;
import com.axelor.db.JPA;
import com.axelor.i18n.I18n;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

import fr.stlrconseil.apps.qms.db.QMSDocument;
import fr.stlrconseil.apps.qms.exception.IExceptionMessage;

public class QMSDocumentRepository extends AbstractQMSDocumentRepository {

	@Inject
	protected SequenceService sequenceService;

	@Override
	public QMSDocument save(QMSDocument entity) {
		if(Strings.isNullOrEmpty(entity.getReference())) {
			final String index = sequenceService.getSequenceNumber("qmsDocument", entity.getCompany());
			if(index == null) {
				throw new PersistenceException(String.format(I18n.get(IExceptionMessage.DOCUMENT_MISSING_SEQUENCE), entity.getCompany().getName()));
			}
			// TODO should we make pattern configurable?
			entity.setReference(String.format("%s-%s-%s", entity.getProcess().getCode(), entity.getType().getCode(), index));
		}
		return super.save(entity);
	}

	/**
	 * Removes documents that are not bound to a process anymore. Needed because of the m2m/m2o mess
	 */
	@Transactional
	public void cleanOrphanedDocuments() {
		JPA.em().createQuery("DELETE FROM QMSDocument d WHERE d.processes IS EMPTY").executeUpdate();
	}

}
