package com.mycompany.retoprimefaces;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "InicioMB")
@ManagedBean
@ViewScoped
public class InicioMB implements Serializable{

    
    private String usuario;
    
    
    public InicioMB() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init() {
        usuario = "";
    }

    public void AgregarMensaje(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
        
        try {
            boolean guardado = interfacelocal.guardarUsuario(detail);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }

    public void MostrarMensajeInfo() {
        AgregarMensaje(FacesMessage.SEVERITY_INFO, "Información", usuario);
        AgregarMensaje(FacesMessage.SEVERITY_WARN, "Advertencia", usuario);
        AgregarMensaje(FacesMessage.SEVERITY_ERROR, "Error", usuario);
    }
    
    @Inject
    InterfacePF interfacelocal;


    
}
