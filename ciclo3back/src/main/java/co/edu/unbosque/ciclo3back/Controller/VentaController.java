package co.edu.unbosque.ciclo3back.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.edu.unbosque.ciclo3back.dao.VentaDAO;
import co.edu.unbosque.ciclo3back.model.Venta;
import co.edu.unbosque.ciclo3back.utils.JWTUtil;
import io.jsonwebtoken.SignatureException;

@Controller
public class VentaController implements ControllerInterface<Venta>{

	@Autowired
	private VentaDAO ventaDao;
	
	@Autowired
	private JWTUtil jwtUtil;

	@Override
	public String guardar(Venta agregar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar(Venta agregar, String token) {
		System.out.println("Entra agregar Venta");
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			if (ventaDao.existsById(agregar.getCedula_cliente()))
				return "Ya existe una venta con el id";
			System.out.println("Intenta Agregar");
			if (agregar.getTotal_venta() > 0) {
				ventaDao.save(agregar);
				System.out.println("agrego");
				return "Venta Agregado";
			} else
				return "Credenciales Vacias";
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "Credenciales invalidas";
		}
	}

	@Override
	public Venta obtenerById(Long id, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> obtenerTodos(String token) {
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			return ventaDao.findAll();
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public String actualizar(Venta actualizar, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar(Long id, String token) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean validarToken(String token) {
		String usuarioId = jwtUtil.getKey(token);
		return usuarioId != null;
	}
}
