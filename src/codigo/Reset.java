package codigo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;
import com.sun.mail.pop3.POP3SSLStore;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Reset {
	private Selenium selenium;		
	
	public boolean requestEmail(String loginLug, String senhaLug, String url) {
		try {
			PhantomJSDriverService service = new PhantomJSDriverService.Builder().usingPhantomJSExecutable(new File("phantomjs.exe")).build();
			PhantomJSDriver driver = new PhantomJSDriver(service, new DesiredCapabilities());
			selenium = new WebDriverBackedSelenium(driver, "https://minhaconta.levelupgames.com.br/");
			selenium.open("https://minhaconta.levelupgames.com.br/web/login");
			selenium.type("id=Username", loginLug);
			selenium.type("id=Password", senhaLug);
			selenium.click("css=input.btn");
			selenium.open(url);
			selenium.click("css=button.btngray");
			selenium.close();
			driver.quit();
			return true;
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao acessar o site da Lug para solicitar o e-mail para: " + loginLug);
		}
		return false;
	}
	
	public String checkEmail(String loginEmail, String senhaEmail, String loginRag) {
		
        URLName url = new URLName("pop3", "outlook.office365.com", 995, "", loginEmail, senhaEmail);
        Session session = Session.getDefaultInstance(System.getProperties(), new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
            	return new PasswordAuthentication(loginEmail, senhaEmail);
            }
        });
        
        Store store = new POP3SSLStore(session, url);
		try {
			store.connect();
			String link = null;
			
			for(int count = 0; count < 12; count++) {
				TimeUnit.SECONDS.sleep(10);
		        Folder folder = store.getFolder("inbox");
		        folder.open(Folder.READ_WRITE);
		        Message[] msg = folder.getMessages();
		        
		        for (Message message : msg) {
		        	if (InternetAddress.toString(message.getFrom()).equals("Equipe Level Up <registro@levelupgames.com.br>")) {
		        		Object content = message.getContent();
		        		if (content instanceof String) {
		                    String body = (String)content;
		                    Pattern p1 = Pattern.compile(loginRag, Pattern.CASE_INSENSITIVE);
		                    Matcher m1 = p1.matcher(body);
		                    Pattern p2 = Pattern.compile("<a href=\"(.*?)\" target=\"blank\">");
		                    Matcher m2 = p2.matcher(body);
		                    while(m1.find() && m2.find()) {
		                    	message.setFlags(new Flags(Flags.Flag.DELETED), true);
		                        link = m2.group(1);
		                    }
		                }
		        	}
		        	else if (InternetAddress.toString(message.getFrom()).equals("naoresponder@levelup.com.br")) {
		        		message.setFlags(new Flags(Flags.Flag.DELETED), true);
		        	}
				}
		        folder.close(true);
		        
		        if (link != null) {
		        	store.close();
		        	return link;
		        }
			}
			store.close();
			JOptionPane.showMessageDialog(null, "Email de reset não encontrado para: " + loginEmail + " - " + loginRag);
		} catch (MessagingException | InterruptedException | IOException e) {
			JOptionPane.showMessageDialog(null, "Erro em verificar o email de: " + loginEmail + " - " + loginRag);
		}
		
		return null;
	}
	
	public void reset(String loginLug, String senhaLug, String loginRag, String senhaRag, String loginEmail,
				String senhaEmail, String urlLug) {
		
		Reset reset = new Reset();
		boolean checkRequest = reset.requestEmail(loginLug, senhaLug, urlLug);
		
		String url = null;
		if (checkRequest)
			 url = reset.checkEmail(loginEmail, senhaEmail, loginRag);

		if (url != null) {
			try {
				FileWriter atalho = new FileWriter(loginLug + " - " + senhaLug + " - " + senhaRag + ".url");
				atalho.write("[InternetShortcut]\nURL=" + url + "\nIDList=\nHotKey=0\n");
				atalho.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao criar atalho url para: " + loginLug + " - " + loginRag);
			}
		}
	}
}
