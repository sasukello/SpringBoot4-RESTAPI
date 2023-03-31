package com.anderson.example.API.controllers;

import com.anderson.example.API.models.UsuarioModel;
import com.anderson.example.API.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuario")
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuario();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario (@RequestBody UsuarioModel usuario ){
        return  this.usuarioService.guardarUsuario(usuario);
    }


    @GetMapping( "/")
    public String Home(){
        return "HOME de la API";
    }
    
    @GetMapping("/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
    	return this.usuarioService.obtenerPorId(id);
    }
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
    	return this.usuarioService.obtenerPorPrioridad(prioridad);
    }
    @DeleteMapping(path = "/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id) {
    	boolean ok = this.usuarioService.eliminarUsuario(id);
    	if(ok) {
    		return "Usuario Elminado "+id;
    	}else {
    		return "Error al Eliminar Usuario "+id;
    	}
    }

}
