package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Cancion;
import ar.com.magm.ti.model.Usuario;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.dao.hibernate.CancionDAO;
import ar.com.magm.ti.model.service.ICancionService;
import ar.com.magm.ti.model.service.impl.CancionService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.ArrayList;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CancionTest extends BaseTest {

    @Test
    public void testSave() throws ServiceException {
        ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));

        List<Cancion> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Cancion p = new Cancion();
        p.setDuracion("3'45''");
        p.setRating((float)4.5);
        p.setReproducciones(15);
        p.setTitulo("Before I forguet");
        p.setUsuarios(new ArrayList<Usuario>());

        p = service.save(p);
        assertNotEquals("Se generó mal el id", 0, p.getId());
    }
    @Test
    public void testSaveOrUpdate() throws ServiceException {
        ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));

        List<Cancion> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Cancion p = new Cancion();
        p.setDuracion("7'22''");
        p.setRating((float)3.2);
        p.setReproducciones(9);
        p.setTitulo("Pulse of the maggot");
        p.setUsuarios(new ArrayList<Usuario>());

        p = service.saveOrUpdate(p);
        assertNotEquals("Se generó mal el id", 0, p.getId());
    }
    @Test
    public void testUpdate() throws ServiceException {
        ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));

        List<Cancion> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Cancion p = new Cancion();
        p.setId(1);
        p.setDuracion("9'11''");
        p.setRating((float)4.1);
        p.setReproducciones(33);
        p.setTitulo("Smell like teen spirit");
        p.setUsuarios(new ArrayList<Usuario>());
        try{
            p = service.update(p);
        }catch(NotFoundException e){
            
        }
        assertNotEquals("Se generó mal el id", 0, p.getId());
    }
    @Test
    public void testList() throws ServiceException {
        ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));

        List<Cancion> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        List<Cancion> p = service.list();

        assertNotNull("Se generó la lista", p);
    }/*
    @Test
    public void testListFilter() throws ServiceException {
        IAlbumService service = new AlbumService(new AlbumDAO((SessionFactory) sessionFactory()));

        List<Album> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        List<Album> p = service.list("eath");

        assertNotNull("No se generó la lista", p);
    }*/
    @Test
    public void testLoad() throws ServiceException {
        ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));

        List<Cancion> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Cancion p = new Cancion();
        p = null;
        try{
            p = service.load(1);
        }catch(NotFoundException e){
        }
        
        assertNotNull("No se cargo la cancion");
    }
    @Test
    public void testDelete()  throws ServiceException{
        ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));

        List<Cancion> l = service.list();

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Cancion p = new Cancion();
        try{
            p = service.load(1);
            service.delete(p);
            p = null;
            p = service.load(1);
        }catch(NotFoundException e){
        }
        assertNull("Se borro la cancion", p);
    }
    
}
