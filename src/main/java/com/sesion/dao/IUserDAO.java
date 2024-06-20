package com.sesion.dao;

import com.sesion.dominio.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUserDAO extends CrudRepository<Usuario, Long>{
    
}
