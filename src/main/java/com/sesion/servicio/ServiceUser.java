package com.sesion.servicio;

//@author FabianCol

import com.sesion.dominio.Usuario;
import java.util.List;

public interface ServiceUser {

    public List<Usuario> listarUsers();

    public void guardar(Usuario usuario);

    public void eliminar(Usuario usuario);

    public Usuario encontrarUser(Usuario usuario);
}
