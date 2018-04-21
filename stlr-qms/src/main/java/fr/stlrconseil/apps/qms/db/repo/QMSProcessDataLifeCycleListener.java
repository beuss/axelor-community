package fr.stlrconseil.apps.qms.db.repo;

import javax.persistence.PersistenceException;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.commons.collections.CollectionUtils;

import com.axelor.i18n.I18n;

import fr.stlrconseil.apps.qms.db.QMSProcessData;
import fr.stlrconseil.apps.qms.exception.IExceptionMessage;

public class QMSProcessDataLifeCycleListener {
	@PrePersist
	@PreUpdate
	public void onSave(QMSProcessData data) {
		// If l10n data are not loaded yet we're screwed since we'll attempt to load from database which will cause an infinite
		// loop. This seems to be an acceptable bet.
		if(data.getInternalConsumers() != null && data.getInternalConsumers().contains(data.getInternalSource())) {
			throw new PersistenceException(String.format(I18n.get(IExceptionMessage.PROCESS_DATA_CYCLE), data.getInternalSource().getTitle(), data.getTitle()));
		}
		if(CollectionUtils.isEmpty(data.getInternalConsumers()) && CollectionUtils.isEmpty(data.getExternalConsumers())) {
			throw new PersistenceException(String.format(I18n.get(IExceptionMessage.PROCESS_DATA_NO_CONSUMER), data.getTitle()));
		}
	}
}
