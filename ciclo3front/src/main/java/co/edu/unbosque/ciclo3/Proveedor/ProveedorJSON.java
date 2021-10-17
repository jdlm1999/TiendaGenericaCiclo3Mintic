package co.edu.unbosque.ciclo3.Proveedor;

import java.net.URL;
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

import co.edu.unbosque.ciclo3.Login.LoginJSON;
import co.edu.unbosque.ciclo3.Usuario.Usuario;

public class ProveedorJSON {
	private static URL url;
	private static String sitio = "http://localhost:5000/";

	public static int postJSON(Proveedor proveedor) throws IOException {
		url = new URL(sitio + "proveedores/crear");
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
		String data = "{" + "\"nit_proveedor\":\"" + proveedor.getNit_proveedor() + "\",\"ciudad_proveedor\": \""
				+ proveedor.getCiudad_proveedor() + "\",\"direccion_proveedor\": \""
				+ proveedor.getDireccion_proveedor() + "\",\"nombre_proveedor\":\"" + proveedor.getNombre_proveedor()
				+ "\",\"telefono_proveedor\":\"" + proveedor.getTelefono_proveedor() + "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	public static JSONObject getOneJSON(Long id) throws IOException, ParseException {
		url = new URL(sitio + "proveedores/obtener/" + id);
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
			JSONObject proveedorJson = (JSONObject) jsonParser.parse(json);
			http.disconnect();
			return proveedorJson;
		} catch (Exception e) {
			System.out.println("Aqui " + e.getMessage());
			return null;
		}
	}

	public static ArrayList<Proveedor> getJSON() throws IOException, ParseException {
		url = new URL(sitio + "proveedores/listar");
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", LoginJSON.TOKEN_USER);
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		lista = parsingProveedores(json);
		http.disconnect();
		return lista;
	}

	public static int deleteJSON(Long proveedorNIT) throws IOException {
		url = new URL(sitio + "proveedores/eliminar/" + proveedorNIT);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		http.setRequestMethod("DELETE");
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", LoginJSON.TOKEN_USER);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static int putJSON(Proveedor proveedor) throws IOException {
		url = new URL(sitio + "proveedores/actualizar");
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();
		try {
			http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		http.setRequestProperty("Authorization", LoginJSON.TOKEN_USER);
		String data = "{" + "\"nit_proveedor\":\"" + proveedor.getNit_proveedor() + "\",\"ciudad_proveedor\": \""
				+ proveedor.getCiudad_proveedor() + "\",\"direccion_proveedor\": \""
				+ proveedor.getDireccion_proveedor() + "\",\"nombre_proveedor\":\"" + proveedor.getNombre_proveedor()
				+ "\",\"telefono_proveedor\":\"" + proveedor.getTelefono_proveedor() + "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	public static ArrayList<Proveedor> parsingProveedores(String json) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		JSONArray proveedores = (JSONArray) jsonParser.parse(json);
		Iterator i = proveedores.iterator();
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Proveedor proveedor = new Proveedor();
			proveedor.setNit_proveedor(Long.parseLong(innerObj.get("nit_proveedor").toString()));
			proveedor.setCiudad_proveedor(innerObj.get("ciudad_proveedor").toString());
			proveedor.setDireccion_proveedor(innerObj.get("direccion_proveedor").toString());
			proveedor.setNombre_proveedor(innerObj.get("nombre_proveedor").toString());
			proveedor.setTelefono_proveedor(innerObj.get("telefono_proveedor").toString());
			lista.add(proveedor);
		}
		return lista;
	}

}
