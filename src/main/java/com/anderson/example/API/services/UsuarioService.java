package com.anderson.example.API.services;

import com.anderson.example.API.models.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.example.API.repositories.UsuarioRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public ArrayList<UsuarioModel> obtenerUsuario() {
		return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
	}

	public UsuarioModel guardarUsuario(UsuarioModel usuario){
		return usuarioRepository.save(usuario);
	}
	
	public Optional<UsuarioModel> obtenerPorId(Long id){
		return usuarioRepository.findById(id);
	}
	
	public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
		return usuarioRepository.findByPrioridad(prioridad);
	}
	public boolean eliminarUsuario(Long id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	

}
