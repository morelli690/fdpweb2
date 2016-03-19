package br.com.fabricadeprogramador.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.service.ServiceException;
import br.com.fabricadeprogramador.service.UsuarioService;

@ManagedBean(name="usuarioController")
@Controller(value="usuarioController")
public class UsuarioController {
	private Usuario usuario= new Usuario();
	@Autowired
	private UsuarioService usuarioService;
	
	
	public void salvar(){
		//
		try {
			usuarioService.salvar(usuario);
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

}
