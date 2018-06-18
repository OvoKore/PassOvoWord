package codigo;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
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
import com.sun.mail.pop3.POP3SSLStore;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;

public class Reset {
	private Selenium selenium;		
	
	public void requestEmail(String login, String senha, String url) {
		PhantomJSDriverService service = new PhantomJSDriverService.Builder().usingPhantomJSExecutable(new File("phantomjs.exe")).build();
		PhantomJSDriver driver = new PhantomJSDriver(service, new DesiredCapabilities());
		selenium = new WebDriverBackedSelenium(driver, "https://minhaconta.levelupgames.com.br/");
		selenium.open("https://minhaconta.levelupgames.com.br/web/login");
		selenium.type("id=Username", login);
		selenium.type("id=Password", senha);
		selenium.click("css=input.btn");
		selenium.open(url);
		selenium.click("css=button.btngray");
		selenium.close();
		driver.quit();
	}
	
	public String checkEmail(String loginEmail, String senhaEmail, String loginRag) throws MessagingException, InterruptedException, IOException {
		Properties pop3Props = new Properties();
        pop3Props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        pop3Props.setProperty("mail.pop3.socketFactory.fallback", "false");
        pop3Props.setProperty("mail.pop3.port", "995");
        pop3Props.setProperty("mail.pop3.socketFactory.port", "995");
		
        URLName url = new URLName("pop3", "outlook.office365.com", 995, "", loginEmail, senhaEmail);
        Session session = Session.getDefaultInstance(System.getProperties(), new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
            	return new PasswordAuthentication(loginEmail, senhaEmail);
            }
        });
        
        Store store = new POP3SSLStore(session, url);
		store.connect();
		
		for(int count = 0; count < 24; count++) {
			TimeUnit.SECONDS.sleep(5);
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
	                    	//message.setFlags(new Flags(Flags.Flag.DELETED), true);
	                        folder.close(true);
	                        store.close();
	                        return m2.group(1);
	                    }
	                }
	        	}
	        	else if (InternetAddress.toString(message.getFrom()).equals("naoresponder@levelup.com.br")) {
	        		message.setFlags(new Flags(Flags.Flag.DELETED), true);
	        	}
			}
	        folder.close(true);
		}
        store.close();
		return null;
	}
	
	
	public WebDriver driver(String driverName, String binaryDriver) {
		
		if (driverName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			op.setBinary(binaryDriver);
			return new ChromeDriver(op);
		}
		//else if (driverName.equals("FireFox")) {
		//	System.setProperty("webdriver.gecko.driver", "geckodriver.exe");	
		//	FirefoxBinary bin = new FirefoxBinary(new File(binaryDriver));
		//	FirefoxProfile profile = new FirefoxProfile().set;
		//	return new FirefoxDriver(bin, profile);
		//}
		return null;
	}
	
	public void changePassword(WebDriver driver, String loginLug, String senhaLug, String senhaRag, String url) {
		selenium = new 	WebDriverBackedSelenium(driver, "https://minhaconta.levelupgames.com.br/");
		selenium.open(url);
		selenium.type("id=Username", loginLug);
		selenium.type("id=Password", senhaLug);
		selenium.click("css=input.btn");
		selenium.type("id=Password", senhaRag);
		selenium.type("id=ConfirmPassword", senhaRag);
	}
	
	public void reset(String loginLug, String senhaLug, String loginRag, String senhaRag, String loginEmail,
				String senhaEmail, String urlLug) {
		
		Reset reset = new Reset();
		reset.requestEmail(loginLug, senhaLug, urlLug);
		String url = null;
		try {
			url = reset.checkEmail(loginEmail, senhaEmail, loginRag);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		//String binaryDriver = "C:\\Users\\note\\AppData\\Local\\Mozilla Firefox\\firefox.exe";
		//String browser = "FireFox";

		String binaryDriver = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
		String browser = "Chrome";

		if (url != null) {
			WebDriver driver = reset.driver(browser, binaryDriver);
			if (driver != null) {
				reset.changePassword(driver, loginLug, senhaLug, senhaRag, url);
			}
		}
	}
}
