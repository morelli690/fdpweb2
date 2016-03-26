package br.com.fabricadeprogramador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.dao.DAO;
import br.com.fabricadeprogramador.dao.DAOException;
import br.com.fabricadeprogramador.entidade.Usuario;

@Service
public class UsuarioService {

	@Autowired
	@Qualifier("usuarioDAO")
	private DAO<Usuario> usuarioDAO;
	
	public Usuario salvar(Usuario usuario) throws ServiceException{
		
		if (usuario.getSenha()=="111111"){
			
			throw new ServiceException("Senha com numero repetido!");
		}
		
		try {
			usuarioDAO.salvar(usuario);
		} catch (DAOException e) {
			
			throw new ServiceException(e);
		}catch(Exception e){
			throw new ServiceException(e);
		}
		return usuario;
		
	}



	public List<Usuario> buscarTodos() {
		return usuarioDAO.buscarTodos();
		
	}


	public Usuario excluir(Usuario usuario) throws ServiceException, DAOException {
	
		try {
			usuarioDAO.excluir(usuario);
		} catch(Exception e){
			
		}
		return usuario;
		
	}
	
}

