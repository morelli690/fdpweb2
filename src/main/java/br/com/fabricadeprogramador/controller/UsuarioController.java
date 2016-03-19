package br.com.fabricadeprogramador.controller;


import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.service.UsuarioService;

@ManagedBean(name="usuarioController")
@Controller
public class UsuarioController {
	// Objeto ser� vinculado com a tela
	private Usuario usuario =new Usuario();
//autowired diz que o spring contola isso ou seja toda a parte de Entity manager
	@Autowired
	private UsuarioService usuarioService;
	// M�todo ser� chamado por um bot�o
	public void salvar() {
		// Dados impressos pelo toString
		System.out.println(usuario.getNome() +"Salvo com Sucesso!!!");
	}
	// Getters and Setters

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
