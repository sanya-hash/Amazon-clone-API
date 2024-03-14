package com.clone.amazon.exceptions;

public class CartException extends amazonException{
    private static final long serialVersionUID = 1L;

    private final String identifier;

    public CartException(final String identifier, final String args) {
        super(args,identifier);
        this.identifier = identifier;
    }

    
    public String getIdentifier() {
        return this.identifier;
    }


}
