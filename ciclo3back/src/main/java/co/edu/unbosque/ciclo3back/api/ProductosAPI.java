package co.edu.unbosque.ciclo3back.api;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import co.edu.unbosque.ciclo3back.Controller.UsuarioController;
import co.edu.unbosque.ciclo3back.model.Usuario;
import co.edu.unbosque.ciclo3back.utils.JWTUtil;

@RestController
@RequestMapping("productos")
public class ProductosAPI {

	@PostMapping("/crear")
	public void guardar(@RequestBody MultipartFile file) {
		System.out.println("ENTRO API PRODUCTOS!!");
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("Prueba.csv")));
				stream.write(bytes);
				stream.close();
				System.out.println("You successfully uploaded!");
				cargarLibros();
			} catch (Exception e) {
				System.err.println("You failed to upload => " + e.getMessage());
			}
		} else {
			System.err.println("You failed to upload because the file was empty.");
		}
	}
	
	
	public static void cargarLibros() {
		try {
//			BufferedReader csvReader = new BufferedReader(new FileReader(
//					"D:\\Mintic\\Ciclo 3\\Grupal\\ciclo3front\\src\\main\\webapp\\Documentos\\productos.csv"));
			BufferedReader csvReader = new BufferedReader(new FileReader("Prueba.csv"));

			String row;
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(";");
				System.out.println(data[0]);
				System.out.println(data[1]);
				System.out.println(data[2]);
				System.out.println(data[3]);
				System.out.println(data[4]);
				System.out.println(data[5]);
				System.out.println("----------------------------");
			}
			csvReader.close();
			System.out.println("Continue and i think that its not a problem");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Error al cargar el archivo");
		}
	}
}
