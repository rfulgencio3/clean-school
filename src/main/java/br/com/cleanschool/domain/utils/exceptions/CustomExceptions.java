package br.com.cleanschool.domain.utils.exceptions;

import br.com.cleanschool.domain.utils.exceptions.enums.ErrorCodes;

public class CustomExceptions extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final Integer errorCode;

    public CustomExceptions(ErrorCodes errorCode, String message){
        super(message);
        this.errorCode = errorCode.getCode();
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}

