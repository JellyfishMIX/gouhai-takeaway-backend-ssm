package com.jellyfishmix.gouhaitakeaway.exceptions;

public class OrderOperationException extends RuntimeException {
    private static final long serialVersionUID = 2567986192256532651L;

    public OrderOperationException(String errMsg) {
        super(errMsg);
    }
}
