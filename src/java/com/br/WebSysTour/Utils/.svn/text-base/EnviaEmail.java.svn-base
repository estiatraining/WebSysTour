package com.br.WebSysTour.Utils;

import com.br.WebSysTour.Constants.Constantes;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author Maycon
 */
public class EnviaEmail {
    
    public  void email(String assunto, String msg) {
            Properties props = new Properties();
            /** ParÃ¢metros de conexÃ£o com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication()
                             {
                                   return new PasswordAuthentication(Constantes.EMAIL, Constantes.SENHA);
                             }
                        });

            session.setDebug(true);

            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(Constantes.EMAIL_REMETENTE)); //Remetente

                  Address[] toUser = InternetAddress //DestinatÃ¡rio(s)
                  .parse(Constantes.EMAIL_DESTINATARIO);

                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject(assunto);//Assunto
                  message.setText(msg);
                  /**MÃ©todo para enviar a mensagem criada*/
                  Transport.send(message);

             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
      }
}
    
