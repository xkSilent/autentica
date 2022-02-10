package com.aula.domain.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aula.domain.Usuario;
import com.aula.repositories.UsuarioRepository;

@Service
public class DBService {
	@Autowired
	UsuarioRepository usuRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public void instantiateTestDataBase() throws ParseException{
		
		Usuario user1 = new Usuario();
		user1.setNome("Felipe");
		user1.setEmail("felipe@hotmail.com");
		user1.setSenha(pe.encode("12345"));
		
		usuRepository.saveAll(Arrays.asList(user1));
	}

}
