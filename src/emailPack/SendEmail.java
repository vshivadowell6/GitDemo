package emailPack;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail {

	public static void main(String[] args)
    {
        // change accordingly
        String to = "vshivadowell@gmail.com";

        // change accordingly
        String from = "vshivadowell@gmail.com";

        // or IP address
        //String host = "localhost";
        String host =  "172.25.74.157";

        // mail id
        final String username = "vshivadowell@gmail.com";

        // correct password for gmail id
        final String password = "Hanuman1234";

        System.out.println("TLSEmail Start");
        // Get the session object

        // Get system properties
        Properties properties = System.getProperties();
       System.out.println("Host Property = "+properties.getProperty(""	,to));
      // properties.getProperty(username, password);
        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // SSL Port
        properties.put("mail.smtp.port", "8080");

        // enable authentication
        properties.put("mail.smtp.auth", "true");

        // SSL Factory
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");

        // creating Session instance referenced to
        // Authenticator object to pass in
        // Session.getInstance argument
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {

                // override the getPasswordAuthentication
                // method
                @Override
				protected PasswordAuthentication
                        getPasswordAuthentication() {
                    return new PasswordAuthentication(username,
                                                    password);
                }
            });


//compose the message
try {
    // javax.mail.internet.MimeMessage class is mostly
    // used for abstraction.
    MimeMessage message = new MimeMessage(session);

    // header field of the header.
    message.setFrom(new InternetAddress(from));

    message.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(to));
    message.setSubject("subject");
    message.setText("Hello, aas is sending email ");
    System.out.println("Hanuman");
    // Send message
    Transport.send(message);
    System.out.println("Yo it has been sent..");
}
catch (MessagingException mex) {
    mex.printStackTrace();
}
}
}