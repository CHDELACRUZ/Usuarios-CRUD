package com.usuarioscrud.springboot.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuarioscrud.springboot.web.app.model.User;
import com.usuarioscrud.springboot.web.app.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService servicio;

	@GetMapping("/usuarios")
	public List<User> list() {
		return servicio.list();
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<User> obtenerUsuario(@PathVariable Long id) {
		try {
			User usuario = servicio.obtenerUsuarioPorId(id);
			return new ResponseEntity<User>(usuario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/usuarios")
	public void guardarUsuario(@RequestBody User usuario) {
		servicio.guardarUsuario(usuario);
	}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<?> actualizarUsuario(@RequestBody User usuario, @PathVariable Long id) {
		try {
			User usuarioExistente = servicio.obtenerUsuarioPorId(id);
			
			usuarioExistente.setNombre(usuario.getNombre());
			usuarioExistente.setApellidos(usuario.getApellidos());
			usuarioExistente.setEmail(usuario.getEmail());
			usuarioExistente.setTelefono(usuario.getTelefono());
			usuarioExistente.setPassword(usuario.getPassword());
			
			servicio.guardarUsuario(usuarioExistente);
			return new ResponseEntity<User>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/usuarios/{id}")
	public void eliminarUsuario(@PathVariable Long id) {
		servicio.eliminarUsuario(id);
	}
}
