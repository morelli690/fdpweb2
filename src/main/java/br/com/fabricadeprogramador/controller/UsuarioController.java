package br.com.fabricadeprogramador.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fabricadeprogramador.dao.DAOException;
import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.service.ServiceException;
import br.com.fabricadeprogramador.service.UsuarioService;

@ManagedBean(name="usuarioController")
@Controller(value="usuarioController")

public class UsuarioController {
	
	private List<Usuario> usuarios ;
	
	private Usuario usuario= new Usuario();
	@Autowired
	private UsuarioService usuarioService;

	@PostConstruct
	public void init() {
		usuarios = usuarioService.buscarTodos();
	}
	
	public void salvar(){
		//
		try {
			
			usuario = usuarioService.salvar(usuario);
			if(usuario.getId()==null){
			usuarios.add(usuario);
			}
			usuario=new Usuario();
			
			//a parte do jsf faz o erro aparecer na tela(navegador e nao IDE).
			//System.out.println("Salvando usuario:" + usuario.getNome() +" "+ usuario.getLogin() + " "+ usuario.getSenha() );
			
			//Acessando o contexto JSF
			MensagemUtil.mensagemSalvoSucesso();			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			MensagemUtil.mensagemErro(e.getMessage());
			//e.printStackTrace();
		}
	}
	public void excluir(Usuario usuario) throws DAOException{
		//
		try {
			
			usuario = usuarioService.excluir(usuario);
			usuarios.remove(usuario);
			
			//a parte do jsf faz o erro aparecer na tela(navegador e nao IDE).
			//System.out.println("Salvando usuario:" + usuario.getNome() +" "+ usuario.getLogin() + " "+ usuario.getSenha() );
			
			//Acessando o contexto JSF
			MensagemUtil.mensagemExcluidoSucesso();			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			MensagemUtil.mensagemErro(e.getMessage());
			//e.printStackTrace();
		}
	}
	public void editar(Usuario usuario){
		this.usuario=usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}
