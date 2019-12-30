package com.ittc.Exception;

public class FetchTimeIntervalException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5403487319360222829L;

	public FetchTimeIntervalException() {
		super();
	}

	public FetchTimeIntervalException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FetchTimeIntervalException(String message, Throwable cause) {
		super(message, cause);
	}

	public FetchTimeIntervalException(String message) {
		super(message);
	}

	public FetchTimeIntervalException(Throwable cause) {
		super(cause);
	}

}
