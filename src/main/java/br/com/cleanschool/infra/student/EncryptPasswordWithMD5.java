package br.com.cleanschool.infra.student;

import br.com.cleanschool.domain.student.EncryptPassword;
import br.com.cleanschool.domain.utils.exceptions.CustomExceptions;
import br.com.cleanschool.domain.utils.exceptions.enums.ErrorCodes;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptPasswordWithMD5 implements EncryptPassword {

    @Override
    public String encrypt(String password) {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++){
                sb.append((Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1)));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e){
            throw new CustomExceptions(ErrorCodes.ERROR_ENCRYPT_PASS, "failed to encrypt password.");
        }
    }

    @Override
    public boolean validateEnryptedPassword(String encryptedPassword, String password) {
        return encryptedPassword.equals(encrypt(password));
    }
}
