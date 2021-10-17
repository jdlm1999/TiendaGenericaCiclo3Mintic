package co.edu.unbosque.ciclo3back.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.edu.unbosque.ciclo3back.dao.ClienteDAO;
import co.edu.unbosque.ciclo3back.model.Cliente;
import co.edu.unbosque.ciclo3back.utils.JWTUtil;
import io.jsonwebtoken.SignatureException;

@Controller
public class ClienteController implements ControllerInterface<Cliente> {

	@Autowired
	private ClienteDAO clienteDao;
	
	@Autowired
	private JWTUtil jwtUtil;

	@Override
	public String guardar(Cliente agregar, String token) {
		System.out.println("Entra agregar Cliente");
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			if (clienteDao.existsById(agregar.getCedula_cliente()))
				return "Ya existe un cliente con el id";
			System.out.println("Intenta Agregar");
			if (!agregar.getEmail_cliente().equals("")) {
				clienteDao.save(agregar);
				System.out.println("agrego");
				return "Cliente Agregado";
			} else
				return "Credenciales Vacias";
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "Credenciales invalidas";
		}
	}
	
	@Override
	public Cliente obtenerById(Long id, String token) {
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			return clienteDao.findById(id).get();
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public List<Cliente> obtenerTodos(String token) {
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			return clienteDao.findAll();
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public String actualizar(Cliente actualizar, String token) {
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			if (!clienteDao.existsById(actualizar.getCedula_cliente()))
				return "No existe el Cliente";
			if (!actualizar.getEmail_cliente().equals("") && !actualizar.getNombre_cliente().equals("")) {
				clienteDao.save(actualizar);
				return "Cliente Actualizado";
			} else
				return "Credenciales Vacias";
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "Credenciales invalidas";
		}
	}
	
	@Override
	public String eliminar(Long id, String token) {
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			if (!clienteDao.existsById(id))
				return "No existe el cliente";
			clienteDao.deleteById(id);
			return "Cliente Eliminado";
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "Exception";
		}
	}
	
	public boolean validarToken(String token) {
		String usuarioId = jwtUtil.getKey(token);
		return usuarioId != null;
	}

	@Override
	public String guardar(Cliente agregar) {
		return null;
	}
}