package com.usuarioscrud.springboot.web.app.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuarioscrud.springboot.web.app.model.User;
import com.usuarioscrud.springboot.web.app.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repositorio;
	
	//Listar usuarios
	public List<User> list() {
		return repositorio.findAll();
	}
	
	//Guardar usuario
	public void guardarUsuario(User usuario) {
		repositorio.save(usuario); 
	}
	
	//Actualizar usuario
	public User obtenerUsuarioPorId(Long id ) {
		return repositorio.findById(id).get();
	}
	
	//Eliminar usuario
	public void eliminarUsuario (Long id) {
		repositorio.deleteById(id);
	}

}