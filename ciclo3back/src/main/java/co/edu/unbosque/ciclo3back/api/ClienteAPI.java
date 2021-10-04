package co.edu.unbosque.ciclo3back.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.ciclo3back.Controller.ClienteController;
import co.edu.unbosque.ciclo3back.model.Cliente;

@RestController
@RequestMapping("clientes")
public class ClienteAPI {

	@Autowired
	private ClienteController clienteController;
	
	@PostMapping("/crear")
	public boolean guardar(@RequestBody Cliente clientes) {
		return clienteController.guardarCliente(clientes);
	}
	
	@GetMapping("/obtener/{id}")
	public Cliente obtener(@PathVariable("id") Long id) {
		return clienteController.obtenerByCedula(id);
	}

	@GetMapping("/listar")
	public List<Cliente> listar() {
		return clienteController.obtenerTodos();
	}

	@PutMapping("/actualizar")
	public boolean actualizar(@RequestBody Cliente cliente) {
		return clienteController.actualizarCliente(cliente);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public boolean eliminar(@PathVariable("id") Long id) {
		return clienteController.eleminarCliente(id);
	}
}