package br.com.fabricadeprogramador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fabricadeprogramador.entidade.Usuario;

@Repository(value="usuarioDAO")
public class UsuarioDAO implements DAO<Usuario> {
	
	@PersistenceContext
	private EntityManager em;
	
	public UsuarioDAO() {
		System.out.println("Instanciando...");
	}
	
	@Transactional
	public Usuario salvar(Usuario usuario) throws DAOException{
		try{
			em.merge(usuario);
		}catch (Exception e ){
			//Lancando exception encapsulando a causa
			throw new DAOException(e);
		}
		return usuario;
	}
	
	@Transactional
	public void excluir (Usuario usuario){
		//Tronando Managed
		usuario= em.find(Usuario.class, usuario.getId());
		em.remove(usuario);
	}
	
	public Usuario buscarPorId(int id){
		return em.find(Usuario.class,id);// Select * from usuario where id=?
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos (){
		//JPQL
		Query query = em.createQuery("select u from Usuario u");
		return query.getResultList();
	}
	
	public List<Object[]> buscarTodos2 (){
		//JPQL
		Query query = em.createQuery("select u.id, u.nome from Usuario u");
		return query.getResultList();
	}
	
	
}
