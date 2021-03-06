package co.edu.unbosque.ciclo3.Usuario;

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

public class UsuarioJSON {

	private static URL url;
	private static String sitio = "http://localhost:5000/";

	public static int postJSON(Usuario usuario) throws IOException {
		url = new URL(sitio + "usuarios/crear");
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
		http.setRequestProperty("Authorization", null);
		String data = "{" + "\"cedula_usuario\":\"" + usuario.getCedula_usuario() + "\",\"email_usuario\": \""
				+ usuario.getEmail_usuario() + "\",\"nombre_usuario\": \"" + usuario.getNombre_usuario()
				+ "\",\"password\":\"" + usuario.getPassword() + "\",\"usuario\":\"" + usuario.getUsuario() + "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		System.out.println(respuesta);
		http.disconnect();
		return respuesta;
	}

	public static JSONObject getOneJSON(Long id) throws IOException, ParseException {
		url = new URL(sitio + "usuarios/obtener/" + id);
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
			JSONObject usuarioJson = (JSONObject) jsonParser.parse(json);
			http.disconnect();
			return usuarioJson;
		} catch (Exception e) {
			System.out.println("Aqui " + e.getMessage());
			return null;
		}
	}

	public static ArrayList<Usuario> getJSON() throws IOException, ParseException {
		url = new URL(sitio + "usuarios/listar");
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
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		lista = parsingUsuarios(json);
		int code = http.getResponseCode();
		System.err.println(code);
		http.disconnect();
		return lista;
	}

	public static int deleteJSON(Long usuarioId) throws IOException {
		url = new URL(sitio + "usuarios/eliminar/" + usuarioId);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		http.setRequestMethod("DELETE");
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", LoginJSON.TOKEN_USER);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static int putJSON(Usuario usuario) throws IOException {
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
		String data = "{" + "\"cedula_usuario\":\"" + usuario.getCedula_usuario() + "\",\"email_usuario\": \""
				+ usuario.getEmail_usuario() + "\",\"nombre_usuario\": \"" + usuario.getNombre_usuario()
				+ "\",\"password\":\"" + usuario.getPassword() + "\",\"usuario\":\"" + usuario.getUsuario() + "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

	public static ArrayList<Usuario> parsingUsuarios(String json) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		JSONArray usuarios = (JSONArray) jsonParser.parse(json);
		System.err.println(usuarios);
		Iterator i = usuarios.iterator();
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Usuario usuario = new Usuario();
			usuario.setCedula_usuario(Long.parseLong(innerObj.get("cedula_usuario").toString()));
			usuario.setEmail_usuario(innerObj.get("email_usuario").toString());
			usuario.setNombre_usuario(innerObj.get("nombre_usuario").toString());
			usuario.setPassword(innerObj.get("password").toString());
			usuario.setUsuario(innerObj.get("usuario").toString());
			lista.add(usuario);
		}
		return lista;
	}
}
