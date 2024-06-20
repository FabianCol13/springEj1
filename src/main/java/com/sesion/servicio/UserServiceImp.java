package com.sesion.servicio;
 // @author FabianCol

import com.sesion.dao.IUserDAO;
import com.sesion.dominio.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements ServiceUser{

    @Autowired
    private IUserDAO userDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarUsers() {
         return (List<Usuario>) userDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Usuario usuario) {
         userDao.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Usuario usuario) {
         userDao.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario encontrarUser(Usuario usuario) {
          return userDao.findById(usuario.getIdUser()).orElse(null);
    }

}
