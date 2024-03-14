package com.clone.amazon.exceptions;

public class amazonException extends Exception{

    private static final long serialVersionUID = 1L;

    private final String identifier;
    public amazonException() {
        super();
        identifier="";
    }

    public amazonException(final String arg0, String id) {
        super(arg0);
        identifier=id;
    }


	public String getIdentifier() {
		return identifier;
	} 


}
