package br.com.fabricadeprogramador.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagemUtil {

	public static void mensagemSalvoSucesso() {
		//Obejto de mensagem
		FacesMessage mensagemInfo = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!",null);
		
		//Acessando o contexto do JSF
		FacesContext contextJSF = FacesContext.getCurrentInstance();
		//Adicionando mensagem no contexto do JSF
		contextJSF.addMessage(null, mensagemInfo);
	}

	public static void mensagemErro(String message) {
		//Obejto de mensagem
		FacesMessage mensagemInfo = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possivel!",message);
		
		//Acessando o contexto do JSF
		FacesContext contextJSF = FacesContext.getCurrentInstance();
		//Adicionando mensagem no contexto do JSF
		contextJSF.addMessage(null, mensagemInfo);
		
	}

}
