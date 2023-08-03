package com.examencl2.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examencl2.entity.Usuario;
import com.examencl2.repository.UsuarioRepository;


@Service
public class UsuarioService implements UserDetailsService {
	
	   @Autowired
	    private UsuarioRepository repository;

	    @Override
	    @Transactional(readOnly = true)
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    	UserDetails us= null;
	        Usuario usuario = repository.findByUsername(username);

	        if (usuario == null) {
	            throw new UsernameNotFoundException(username);
	        }
           
	        var roles = new ArrayList<GrantedAuthority>();
	        roles.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));

	        System.out.println(usuario.toString());
	        us = new User(usuario.getUsername(), usuario.getPassword(),roles);
	        return us;
	    }
	    
	  public Usuario findBynombreusuario(String username) {
		  
		  return repository.findByUsername(username);
	  }


}
