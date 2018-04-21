package fr.stlrconseil.apps.qms.exception;

public interface IExceptionMessage {
	static final String IMPROVEMENT_FORM_MISSING_SEQUENCE = /*$$(*/ "Company %s has no sequence configured for improvement forms" /*)*/ ;
	static final String DOCUMENT_MISSING_SEQUENCE = /*$$(*/ "Company %s has no sequence configured for QMS documents" /*)*/ ;
	static final String PROCESS_DATA_CYCLE = /*$$(*/ "Source %s is both an input and an output for process %s" /*)*/;
	static final String PROCESS_DATA_NO_CONSUMER = /*$$(*/ "Data %s has no consumer" /*)*/;
}
