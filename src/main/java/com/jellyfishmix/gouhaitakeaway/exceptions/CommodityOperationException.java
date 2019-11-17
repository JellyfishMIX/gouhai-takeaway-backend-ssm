package com.jellyfishmix.gouhaitakeaway.exceptions;

public class CommodityOperationException extends RuntimeException {
    private static final long serialVersionUID = -430800302544176442L;

    public CommodityOperationException(String errMsg) {
        super(errMsg);
    }
}
