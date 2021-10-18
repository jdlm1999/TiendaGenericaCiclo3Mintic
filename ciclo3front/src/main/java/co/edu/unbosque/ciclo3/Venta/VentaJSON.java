package co.edu.unbosque.ciclo3.Venta;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import co.edu.unbosque.ciclo3.Login.LoginJSON;

public class VentaJSON {

	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static int postJSON(Venta venta) throws IOException {
		url = new URL(sitio + "ventas/crear");
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
		http.setRequestProperty("Authorization", LoginJSON.TOKEN_USER);
		String data = "{" + "\"cedula_cliente\":\"" + venta.getCedula_cliente() + "\",\"iva_venta\": \""
				+ venta.getIva_venta() + "\",\"total_venta\": \"" + venta.getTotal_venta()
				+ "\",\"valor_venta\":\"" + venta.getValor_venta() + "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		System.out.println(respuesta);
		http.disconnect();
		return respuesta;
	}
	
	public static JSONArray getJSON() throws IOException, ParseException {
		url = new URL(sitio + "ventas/listar/");
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		try {
			http.setRequestMethod("GET");
			http.setDoOutput(true);
			http.setRequestProperty("Accept", "application/json");
			http.setRequestProperty("Content-Type", "application/json");
			http.setRequestProperty("Authorization", LoginJSON.TOKEN_USER);
			InputStream respuesta = http.getInputStream();
			byte[] inp = respuesta.readAllBytes();
			String json = "";
			for (int i = 0; i < inp.length; i++) {
				json += (char) inp[i];
			}
			JSONParser jsonParser = new JSONParser();
			JSONArray ventaJson = (JSONArray) jsonParser.parse(json);
			http.disconnect();
			System.out.println(ventaJson);
			return ventaJson;
		} catch (Exception e) {
			System.out.println("Aqui " + e.getMessage());
			return null;
		}
	}
}
