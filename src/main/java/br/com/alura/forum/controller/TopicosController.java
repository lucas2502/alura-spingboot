package br.com.alura.forum.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.*;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
//Map de URL a ser chamada no navegador para class TopicosController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	// Método LISTAR 
	@GetMapping//Chamada GET
	public List<TopicoDto> lista(String nomeCurso) { //DTO dados que saem api e vão para o client
		if(nomeCurso == null ) {
			//Listando todos os topicos do banco de dados
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);
		} else {
			//Listando topicos do banco de dados por nomeCurso
			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDto.converter(topicos);
		}
	}
	//Método inserir
	@PostMapping//Chamada POST
	public void cadastrar(TopicoForm topico) {//Form dados que chegam do client e vão para api
		
	}
	
}
