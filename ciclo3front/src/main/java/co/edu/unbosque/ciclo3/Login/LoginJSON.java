package co.edu.unbosque.ciclo3.Login;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import co.edu.unbosque.ciclo3.Login.Login;
import co.edu.unbosque.ciclo3.Usuario.Usuario;

public class LoginJSON {
	
	public static String TOKEN_USER = "";

	private static URL url;
	private static String sitio = "http://localhost:5000/";

	public static int postJSON(Login login) throws IOException, ParseException {
		url = new URL(sitio + "login");
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();
		try {
			http.setRequestMethod("POST");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		String data = "{" + "\"usuario\":\"" + login.getUsuario() + "\",\"password\": \"" + login.getPassword() + "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		InputStream token = http.getInputStream();
		byte[] inp = token.readAllBytes();
		String json = "";
		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}

		TOKEN_USER = json;
		
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
}
