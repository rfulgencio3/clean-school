package br.com.cleanschool.application.indication;

import br.com.cleanschool.domain.student.Student;

import javax.mail.internet.MimeMessage;

public interface SendIndicationEmail {
    static void prepareEmailMessage(MimeMessage message, String to, String title, String html) { }

}
