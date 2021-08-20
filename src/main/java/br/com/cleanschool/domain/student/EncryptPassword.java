package br.com.cleanschool.domain.student;

public interface EncryptPassword {
    String encrypt(String password);

    boolean validateEnryptedPassword(String encryptedPassword, String password);
}
