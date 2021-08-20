package br.com.cleanschool.domain.utils.exceptions.enums;

public enum ErrorCodes {

    ERROR_ENCRYPT_PASS(80),
    ERROR_SEND_EMAIL(81),
    INVALID_PERSONAL_IDENTIFICATION_FORMAT(70),
    INVALID_PHONE_NUMBER_FORMAT(71),
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