package fr.stlrconseil.apps.qms.exception;

public interface IExceptionMessage {
	static final String IMPROVEMENT_FORM_MISSING_SEQUENCE = /*$$(*/ "Company %s has no sequence configured for improvement forms" /*)*/ ;
	static final String DOCUMENT_MISSING_SEQUENCE = /*$$(*/ "Company %s has no sequence configured for QMS documents" /*)*/ ;
	static final String PROCESS_DATA_CYCLE = /*$$(*/ "Process %s is the source of data %s, it cannot be one of its consumers" /*)*/ ;
	static final String PROCESS_DATA_NO_CONSUMER = /*$$(*/ "Data %s has no consumer" /*)*/;

}
