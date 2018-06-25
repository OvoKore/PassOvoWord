package codigo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json {
	
	private JSONObject json = new JSONObject();
	private JSONArray list = new JSONArray();
	private JSONParser parser = new JSONParser();
	public static final String arquivo = "passOvoWord.json";
	
	public boolean Save(String loginLug, String SenhaLug, String loginRag, String senhaRag, 
			String loginEmail, String senhaEmail, String urlLug) {
		
		if (new File(arquivo).exists())
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
			FileWriter write = new FileWriter(arquivo);
			write.write(list.toString());
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public void Edit(Object[][] obj) {
		for (int row = 0; row < obj.length; row++) {
			json = new JSONObject();
			
			json.put("loginLug", obj[row][0]);
			json.put("senhaLug", obj[row][1]);
			json.put("loginRag", obj[row][2]);
			json.put("senhaRag", obj[row][3]);
			json.put("loginEmail", obj[row][4]);
			json.put("senhaEmail", obj[row][5]);
			json.put("urlLug", obj[row][6]);
			
			list.add(json);
		}
		
		try {
			FileWriter write = new FileWriter(arquivo);
			write.write(list.toString());
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Delete(int[] rows) {
		if (new File(arquivo).exists())
			list = ReadJson();

		for (int i = rows.length - 1; i >= 0 ; i--) {
			list.remove(rows[i]);
		}
		
		try {
			FileWriter write = new FileWriter(arquivo);
			write.write(list.toString());
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public JSONArray ReadJson() {
		try {
			FileReader read = new FileReader(arquivo);
			return (JSONArray) parser.parse(read);
		} catch (IOException | ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao ler PassOvoWord.json");
		}
		return null;
	}
	
	public Object[][] ReadObj() {
		if (new File(arquivo).exists())
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
