package br.com.fabricadeprogramador.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.dao.UsuarioDAO;
import br.com.fabricadeprogramador.entidade.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	public void salvar(Usuario usuario) throws ServiceException{
		if(usuario.getSenha()=="11111"){
		throw new ServiceException("Senha fraca!");
		}
		try{
			usuarioDAO.salvar(usuario);
		}catch(Throwable e){
			
			throw new ServiceException(e);
		}
	}



}
