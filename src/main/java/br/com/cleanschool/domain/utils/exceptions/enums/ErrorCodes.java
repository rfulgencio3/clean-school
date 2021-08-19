package br.com.cleanschool.domain.utils.exceptions.enums;

public enum ErrorCodes {

    STUDENT_NOT_FOUND(90),
    STUDENT_NOT_CREATED(91);

    private final int errorCode;

    ErrorCodes(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getCode() {
        return errorCode;
    }
}