package co.edu.unbosque.ciclo3back.Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

import co.edu.unbosque.ciclo3back.dao.ProductoDAO;
import co.edu.unbosque.ciclo3back.model.Producto;

@Controller
public class ProductoController implements ControllerInterface<Producto> {

	@Autowired
	private ProductoDAO productoDao;

	@Override
	public String guardar(Producto guardar) {
		try {
			productoDao.save(guardar);
			return "";
		} catch (Exception e) {
			System.err.println("Error: Al agregar al Producto.");
			System.err.println(e.getMessage());
		}
		return "";
	}

	@Override
	public Producto obtenerById(Long id, String token) {
		try {
			return productoDao.findById(id).get();
		} catch (Exception e) {
			System.err.println("Error: Al obtener al Producto.");
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "You don't have Authorization");
		}
	}

	@Override
	public List<Producto> obtenerTodos(String token) {
		try {
			return productoDao.findAll();
		} catch (Exception e) {
			System.err.println("Error: Al obtener los usuarios.");
			return null;
		}
	}

	@Override
	public String actualizar(Producto actualizar, String token) {
		try {
			productoDao.save(actualizar);
			return "";
		} catch (Exception e) {
			System.err.println("Error: Al actualizar al usuario.");
			return "";
		}
	}

	@Override
	public String eliminar(Long id, String token) {
		try {
			productoDao.deleteById(id);
			return "";
		} catch (Exception e) {
			System.err.println("Error: Al eliminar al usuario.");
			return "";
		}
	}

	public void cargarLibros() {
		try {
//			BufferedReader csvReader = new BufferedReader(new FileReader(
//					"D:\\Mintic\\Ciclo 3\\Grupal\\ciclo3front\\src\\main\\webapp\\Documentos\\productos.csv"));
			BufferedReader csvReader = new BufferedReader(new FileReader("Prueba.csv"));

			String row;
			Producto agregar = new Producto();
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(";");
				Long codigo_producto = Long.parseLong(data[0]);
				double iva_compra = Double.parseDouble(data[1]);
				Long nit_proveedor = Long.parseLong(data[2]);
				String nombre_producto = data[3];
				double precio_compra = Double.parseDouble(data[4]);
				double precio_venta = Double.parseDouble(data[5]);

				agregar.setCodigo_producto(codigo_producto);
				agregar.setIva_compra(iva_compra);
				agregar.setNit_proveedor(nit_proveedor);
				agregar.setNombre_producto(nombre_producto);
				agregar.setPrecio_compra(precio_compra);
				agregar.setPrecio_venta(precio_venta);

				if (guardar(agregar).equals("")) {
					System.err.println("Error al agregar al producto con el codigo " + agregar.getCodigo_producto());
				}
			}
			csvReader.close();
			System.out.println("Termino de guardar todos los productos!!!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error al cargar el archivo");
		}
	}
}
