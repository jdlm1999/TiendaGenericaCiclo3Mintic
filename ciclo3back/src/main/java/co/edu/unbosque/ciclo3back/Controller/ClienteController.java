package co.edu.unbosque.ciclo3back.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.ciclo3back.dao.ClienteDAO;
import co.edu.unbosque.ciclo3back.model.Cliente;

@Service
public class ClienteController {

	@Autowired
	private ClienteDAO clienteDao;

	public boolean guardarCliente(Cliente cliente) {
		try {
			clienteDao.save(cliente);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Cliente obtenerByCedula(Long id) {
		try {
			return clienteDao.findById(id).get();
		} catch (Exception e) {
			System.err.println("Error: No funciono jeje");
			return null;
		}
	}

	public List<Cliente> obtenerTodos() {
		try {
			return clienteDao.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	public boolean actualizarCliente(Cliente cliente) {
		try {
			clienteDao.save(cliente);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean eleminarCliente(Long id) {
		try {
			clienteDao.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}