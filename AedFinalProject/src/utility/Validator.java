/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Validator {
public static String ACCOUNT_ACTIVATION="Your Account has been Activated.";
public static String HOMELESS_FOUND= "Homeless request has been raised.";
public static String WILLING_TO_SERVE= "Homeless person will be brought to you shortly";
public static String DISASTER_REQUEST="A Disaster Request has been raised.";
public static String EVENT_REQUEST="Your event request is completed";
    //Validating Name with regular Expression.
    public static boolean validateName(String name) {
        Pattern pattern;
        Matcher matcher;
        String NAME_PATTERN = "^[A-Za-z]{1,}[\\s]{0,1}[A-Za-z]{0,}$" ;
        pattern = Pattern.compile(NAME_PATTERN);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean validateUserName(String name) {
        Pattern pattern;
        Matcher matcher;
        String NAME_PATTERN = "^[A-Za-z]{1,}[\\._]{0,1}[A-Za-z]{0,}$";
        pattern = Pattern.compile(NAME_PATTERN);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    /**
     * Validate hex with regular expression
     *
     * @param hex hex for validation
     * @return true valid hex, false invalid hex
     */
    public static boolean validateEmail(String hex) {
        Pattern pattern;
        Matcher matcher;
        String EMAIL_PATTERN
                = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }

    /**
     * Password check ^ # start-of-string (?=.*[0-9]) # a digit must occur at
     * least once (?=.*[a-z]) # a lower case letter must occur at least once
     * (?=.*[A-Z]) # an upper case letter must occur at least once
     * (?=.*[@#$%^&+=]) # a special character must occur at least once (?=\S+$)
     * # no whitespace allowed in the entire string .{8,} # anything, at least
     * eight places though $ # end-of-string
     *
     * @param pwd
     * @return
     */
    public static boolean validatePassword(String pwd) {
        Pattern pattern;
        Matcher matcher;
        String PASSWORD_PATTERN
                = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=~|?])(?=\\S+$).{8,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(pwd);
        return matcher.matches();
    }

    public static void onlyString(KeyEvent evt, JTextField field) {
        char c = evt.getKeyChar();
        if (!((c >= 'A') && (c <= 'Z') || (c >= 'a') && (c <= 'z') || (c == evt.VK_SPACE) || (c == evt.VK_CAPS_LOCK) || (c == evt.VK_SHIFT)
                || (c == evt.VK_BACK_SPACE)
                || (c == evt.VK_DELETE))) {

            JOptionPane.showMessageDialog(null, "Enter Alphabets only");
            field.setText("");
        }
    }

    public static void onlyInteger(KeyEvent evt, JTextField field) {
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == evt.VK_BACK_SPACE)
                || (c == evt.VK_DELETE))) {

            JOptionPane.showMessageDialog(null, "Enter Integers only");
            field.setText("");
        }
    }

    public static void sendMessage(String emailId, String mes) throws SendFailedException {
        // Recipient's email ID needs to be mentioned.
        String to = emailId;

        String from = "poojithsshetty";
        String pass = "Fall@2017";

        // Get system properties
        Properties properties = System.getProperties();
        String host = "smtp.gmail.com";

        properties.put("mail.smtp.starttls.enable", "true");

        properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.smtp.user", from);
        // properties.put("mail.smtp.password", pass);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Volunteer Management");

            message.setText(mes);
            // Send message
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            //mex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid email id");
        }
    }

    public static void sendMessageText(String phone, String network) {
        try {
            Validator.sendMessage("8573089756@tmomail.net","Test");

        } catch (SendFailedException ex) {
            Logger.getLogger(Validator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String generateHash(String input) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (byte a :hashedBytes) 
                        {
				byte b = a;
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			
		}

		return hash.toString();
	}

}
