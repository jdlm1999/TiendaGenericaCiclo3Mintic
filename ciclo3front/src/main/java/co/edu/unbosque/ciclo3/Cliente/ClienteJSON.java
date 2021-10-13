package co.edu.unbosque.ciclo3.Cliente;

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

import co.edu.unbosque.ciclo3.Cliente.Cliente;
import co.edu.unbosque.ciclo3.Login.LoginJSON;

public class ClienteJSON {

	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static int postJSON(Cliente cliente) throws IOException {
		url = new URL(sitio + "clientes/crear");
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
		String data = "{" + "\"cedula_cliente\":\"" + cliente.getCedula_cliente() + "\",\"nombre_cliente\": \""
				+ cliente.getNombre_cliente() + "\",\"email_cliente\": \"" + cliente.getEmail_cliente()
				+ "\",\"telefono_cliente\":\"" + cliente.getTelefono_cliente() + "\",\"direccion_cliente\":\"" + cliente.getDireccion_cliente() + "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	public static ArrayList<Cliente> getJSON() throws IOException, ParseException {
		url = new URL(sitio + "clientes/listar");
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
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		lista = parsingClientes(json);
		http.disconnect();
		return lista;
	}
	
	public static int deleteJSON(Long clienteId) throws IOException {
		url = new URL(sitio + "clientes/eliminar/"+clienteId);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		http.setRequestMethod("DELETE");
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", LoginJSON.TOKEN_USER);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	public static int putJSON(Cliente cliente) throws IOException {
		url = new URL(sitio + "usuarios/actualizar");
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
		String data = "{" + "\"cedula_cliente\":\"" + cliente.getCedula_cliente() + "\",\"nombre_cliente\": \""
				+ cliente.getNombre_cliente() + "\",\"email_cliente\": \"" + cliente.getEmail_cliente()
				+ "\",\"telefono_cliente\":\"" + cliente.getTelefono_cliente() + "\",\"direccion_cliente\":\"" + cliente.getDireccion_cliente() + "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	public static ArrayList<Cliente> parsingClientes(String json) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		JSONArray usuarios = (JSONArray) jsonParser.parse(json);
		Iterator i = usuarios.iterator();
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Cliente cliente = new Cliente();
			cliente.setCedula_cliente(Long.parseLong(innerObj.get("cedula_cliente").toString()));
			cliente.setNombre_cliente(innerObj.get("nombre_cliente").toString());
			cliente.setEmail_cliente(innerObj.get("email_cliente").toString());
			cliente.setTelefono_cliente(innerObj.get("telefono_cliente").toString());
			cliente.setDireccion_cliente(innerObj.get("direccion_cliente").toString());
			lista.add(cliente);
		}
		return lista;
	}
}
