package co.edu.unbosque.ciclo3back.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.edu.unbosque.ciclo3back.dao.ProductoDAO;

@Controller
public class ProductoController {

	@Autowired
	private ProductoDAO productoDao;
}
