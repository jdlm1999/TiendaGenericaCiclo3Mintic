package co.edu.unbosque.ciclo3back.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.edu.unbosque.ciclo3back.dao.ProveedorDAO;
import co.edu.unbosque.ciclo3back.model.Proveedor;
import co.edu.unbosque.ciclo3back.utils.JWTUtil;
import io.jsonwebtoken.SignatureException;

@Controller
public class ProveedorController implements ControllerInterface<Proveedor>{

	@Autowired
	private ProveedorDAO proveedorDao;
	
	@Autowired
	private JWTUtil jwtUtil;

	@Override
	public String guardar(Proveedor agregar, String token) {
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			if (proveedorDao.existsById(agregar.getNit_proveedor()))
				return "Ya existe un proveedor con el NIT";
			if (!agregar.getNombre_proveedor().equals("") && !agregar.getCiudad_proveedor().equals("")) {
				proveedorDao.save(agregar);
				return "Proveedor Agregado";
			} else
				return "Credenciales Vacias";
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "Credenciales invalidas";
		}
	}

	@Override
	public Proveedor obtenerById(Long id, String token) {
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			return proveedorDao.findById(id).get();
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Proveedor> obtenerTodos(String token) {
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			return proveedorDao.findAll();
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public String actualizar(Proveedor actualizar, String token) {
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			if (!proveedorDao.existsById(actualizar.getNit_proveedor()))
				return "No existe el Proveedor";
			if (!actualizar.getNombre_proveedor().equals("") && !actualizar.getCiudad_proveedor().equals("")) {
				proveedorDao.save(actualizar);
				return "Proveedor Actualizado";
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
			if (!proveedorDao.existsById(id))
				return "No existe el proveedor";
			proveedorDao.deleteById(id);
			return "Proveedor Eliminado";
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
	public String guardar(Proveedor agregar) {
		// TODO Auto-generated method stub
		return null;
	}
}
