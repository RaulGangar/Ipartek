package com.ipartek.formacion.crudconsola.dal;

public class DalException extends RuntimeException {

	public DalException() {
		super();
	}

	public DalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DalException(String message, Throwable cause) {
		super(message, cause);
	}

	public DalException(String message) {
		super(message);
	}

	public DalException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = 5086325899198360099L;

}
