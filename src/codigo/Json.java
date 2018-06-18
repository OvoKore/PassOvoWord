package codigo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import net.sourceforge.htmlunit.corejs.javascript.json.JsonParser;

public class Json {
	
	JSONObject json = new JSONObject();
	JSONArray list = new JSONArray();
	JSONParser parser = new JSONParser();
	
	public boolean Save(String loginLug, String SenhaLug, String loginRag, String senhaRag, 
			String loginEmail, String senhaEmail, String urlLug) {
		
		if (new File("json.json").exists())
			list = ReadJson();
	
		json.put("loginLug", loginLug);
		json.put("senhaLug", SenhaLug);
		json.put("loginRag", loginRag);
		json.put("senhaRag", senhaRag);
		json.put("loginEmail", loginEmail);
		json.put("senhaEmail", senhaEmail);
		json.put("urlLug", urlLug);
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(json))
				return false;
		}
		
		list.add(json);
		
		try {
			FileWriter write = new FileWriter("json.json");
			write.write(list.toString());
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public JSONArray ReadJson() {
		try {
			FileReader read = new FileReader("json.json");
			try {
				return (JSONArray) new JSONParser().parse(read);
			} catch (ParseException e) {
				e.printStackTrace();
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Object[][] ReadObj() {
		if (new File("json.json").exists())
			list = ReadJson();
		
		Object[][] contas = new Object[list.size()][7];
		
		for (int i = 0; i < list.size(); i++) {
			JSONObject obj = (JSONObject) list.get(i);
			
			contas[i][0] = obj.get("loginLug");
			contas[i][1] = obj.get("senhaLug");
			contas[i][2] = obj.get("loginRag");
			contas[i][3] = obj.get("senhaRag");
			contas[i][4] = obj.get("loginEmail");
			contas[i][5] = obj.get("senhaEmail");
			contas[i][6] = obj.get("urlLug");
		}
		
		return contas;
	}
}
