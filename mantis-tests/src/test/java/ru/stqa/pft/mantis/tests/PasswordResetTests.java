package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class PasswordResetTests extends TestBase {

    long now = System.currentTimeMillis();
    private String user = String.format("user%s" ,now);
    private String password = "password";
    private String email = String.format("user%s@localhost.localdomain", now);

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @BeforeMethod
    public void prepareUser() throws IOException, MessagingException {
        app.registration().start(user, email);
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
        String confirmationLink = findConfirmationLink(mailMessages, email);
        app.registration().finish(confirmationLink, password);

    }

    @Test
    public void testPasswordReset() throws IOException, MessagingException {
        HttpSession session = app.newSession();
        session.login("administrator", "root");
        app.manageUser().gotoManageUsersPage();
        app.manageUser().selectUser(By.linkText(user));
        app.manageUser().resetPassword();
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
        String changePassLink = findPasswordChangeLink(mailMessages, email);


    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    private String findPasswordChangeLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }
}
