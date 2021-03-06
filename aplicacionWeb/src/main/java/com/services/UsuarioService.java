package com.services;

import com.dao.DaoGrupo;
import com.dao.DaoUsuario;
import com.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacobo on 30/10/14.
 */
public class UsuarioService {

    DaoUsuario daoUsuario;

    public boolean verificarUsername(String username){
        daoUsuario= new DaoUsuario();
        List<Usuario> listaUsuarios = daoUsuario.obtener();
        for(Usuario user : listaUsuarios){
            if(username.equals(user.getIdUsuario()))
                //Falso cuando existe uno que tiene ese nombre
                return false;
        }

        //Verdadero cuando no existe el usuario con ese nombre
        return true;
    }

    public  boolean verificarEmail(String email){
        daoUsuario= new DaoUsuario();
        List<Usuario> listaUsuarios = daoUsuario.obtener();
        for(Usuario user : listaUsuarios){
            if(email.equals(user.getEmailUsuario()))
                //Falso cuando existe uno que tiene ese email
                return false;
        }

        //Verdadero cuando no existe un usuario con ese email
        return true;
    }

    public List<Usuario> obtenerUsuarios() {
        daoUsuario = new DaoUsuario();
        List<Usuario> listaUsuarios = daoUsuario.obtener();
        return listaUsuarios;
    }

    public Usuario obtenerUsuario(String username){
        daoUsuario = new DaoUsuario();
        for(Usuario user : daoUsuario.obtener())
            if(user.getIdUsuario().equals(username))
                return user;

        return null;
    }

    public boolean verificarPassword(Usuario user){
        daoUsuario = new DaoUsuario();

        if(obtenerUsuario(user.getIdUsuario()).getClaveUsuario().equals(user.getClaveUsuario()))
            return true;
        else
            return false;
    }

    public boolean agregarUsuario(Usuario usuario) throws Exception {
        daoUsuario= new DaoUsuario();
        try{
            if(this.verificarUsername(usuario.getIdUsuario())&&this.verificarEmail(usuario.getEmailUsuario())){
                daoUsuario.agregar(usuario);
                return  true;
            }
        }catch(Exception ex){
            throw new Exception("Error!",ex);
        }

        return false;
    }

    public boolean eliminarUsuario(Usuario usuario) throws Exception {
        daoUsuario= new DaoUsuario();
        try{
            if(daoUsuario.eliminar(usuario)){
                return true;
            }
        }catch(Exception ex){
            throw new Exception("Error!",ex);
        }

        return false;
    }

    public boolean modificarUsuario(Usuario usuario) throws Exception {
        daoUsuario= new DaoUsuario();
        try{
                daoUsuario.modificar(usuario);
                return  true;
        }catch(Exception ex){
            throw new Exception("Error!",ex);
        }
    }

    public List<Grupo> obtenerGruposUsuario(Usuario usuario){
        daoUsuario = new DaoUsuario();
        return daoUsuario.obtenerGruposUsuario(usuario);
    }

    public List<Perfil> obtenerPerfilesUsuario(Usuario usuario){
        daoUsuario = new DaoUsuario();
        DaoGrupo daoGrupo = new DaoGrupo();

        List<Grupo> listaGrupos = daoUsuario.obtenerGruposUsuario(usuario);
        List<Perfil> listaPerfiles = new ArrayList<Perfil>();

        for(Grupo grupo : listaGrupos){
                for(Perfil perfil : daoGrupo.obtenerPerfilesGrupo(grupo)){
                    listaPerfiles.add(perfil);
                }
        }

        return listaPerfiles;
    }

    public List<Modulo> obtenerModulosUsuario(Usuario usuario) {
        daoUsuario = new DaoUsuario();
        ModuloService moduloService = new ModuloService();

        List<Modulo> listaModulos = new ArrayList<Modulo>();

        for(Modulo modulo : moduloService.obtenerModulos()){
            for(Formulario formulario : modulo.getFormularios()){
                for(Perfil perfil : obtenerPerfilesUsuario(usuario)){
                    if(perfil.getFormulario().getIdFormulario().equals(formulario.getIdFormulario())&&!listaModulos.contains(modulo)){
                        listaModulos.add(modulo);
                    }
                }
            }
        }

        return listaModulos;
    }

    public List<Usuario> obtenerUsuariosPorPagina(int pagina, int maximosResultados){
        daoUsuario = new DaoUsuario();
        int primerResultado = pagina * maximosResultados - maximosResultados;
        return daoUsuario.obtenerPorPagina(primerResultado,maximosResultados);
    }
}
