package com.aula.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aula.config.MyUserDetails;
import com.aula.domain.Usuario;
import com.aula.repositories.UsuarioRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usu = repo.findByEmail(email);
		
		if(usu == null) {
			throw new UsernameNotFoundException(email);
		}
		return new MyUserDetails(usu.getId(), usu.getEmail(), usu.getSenha(), usu.getPerfis());
	}

}
