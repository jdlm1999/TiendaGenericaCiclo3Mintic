package co.edu.unbosque.ciclo3back.Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

import co.edu.unbosque.ciclo3back.dao.ProductoDAO;
import co.edu.unbosque.ciclo3back.model.Producto;
import co.edu.unbosque.ciclo3back.utils.JWTUtil;
import io.jsonwebtoken.SignatureException;

@Controller
public class ProductoController implements ControllerInterface<Producto> {

	@Autowired
	private ProductoDAO productoDao;
	
	@Autowired
	private JWTUtil jwtUtil;

	public boolean guardarProducto(Producto guardar) {
		try {
			productoDao.save(guardar);
			return true;
		} catch (Exception e) {
			System.err.println("Error: Al agregar al Producto.");
			System.err.println(e.getMessage());
		}
		return false;
	}

	@Override
	public Producto obtenerById(Long id, String token) {
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			return productoDao.findById(id).get();
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Producto> obtenerTodos(String token) {
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			return productoDao.findAll();
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public String actualizar(Producto actualizar, String token) {
		if (!validarToken(token))
			throw new SignatureException("El token no es valido");
		try {
			if (!productoDao.existsById(actualizar.getCodigo_producto()))
				return "No existe el Producto";
			if (actualizar.getNit_proveedor() > 0) {
				productoDao.save(actualizar);
				return "Producto Actualizado";
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
			if (!productoDao.existsById(id))
				return "No existe el producto";
			productoDao.deleteById(id);
			return "Producto Eliminado";
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "Exception";
		}
	}

	public String cargarLibros(String token) {
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("Prueba.csv"));

			String row;
			Producto agregar = new Producto();
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(";");
				Long codigo_producto = Long.parseLong(data[0]);
				String nombre_producto = data[1];
				Long nit_proveedor = Long.parseLong(data[2]);
				double precio_compra = Double.parseDouble(data[3]);
				double iva_compra = Double.parseDouble(data[4]);
				double precio_venta = Double.parseDouble(data[5]);

				agregar.setCodigo_producto(codigo_producto);
				agregar.setIva_compra(iva_compra);
				agregar.setNit_proveedor(nit_proveedor);
				agregar.setNombre_producto(nombre_producto);
				agregar.setPrecio_compra(precio_compra);
				agregar.setPrecio_venta(precio_venta);

				if (!guardarProducto(agregar)) {
					System.err.println("Error al agregar al producto con el codigo " + agregar.getCodigo_producto());
				}
			}
			csvReader.close();
			return "Termino de guardar todos los productos!!!";
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "Error al cargar el archivo";
		}
	}
	
	public boolean validarToken(String token) {
		String usuarioId = jwtUtil.getKey(token);
		return usuarioId != null;
	}

	@Override
	public String guardar(Producto agregar, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar(Producto agregar) {
		// TODO Auto-generated method stub
		return null;
	}
}
