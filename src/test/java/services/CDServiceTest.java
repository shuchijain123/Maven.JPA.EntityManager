package services;



import entities.CdEntity;
import org.junit.Assert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.Assert.*;

public class CDServiceTest{

    CdEntity cd = new CdEntity();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("entitylab");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    CDService service = new CDService(em);


    @org.junit.Test



    public void createCD() {
    }

    @org.junit.Test
    public void createCD1() {
    }

    @org.junit.Test
    public void findCD() {


        String actual = "Low End Theory description";

        cd.setId(2);
        cd  = service.findCD(cd.getId());




        Assert.assertTrue(cd.toString().contains(actual));


    }



    @org.junit.Test
    public void findCDAll() {

        List mylist =service.findAllCds();

        int expected = 3;

        int actual = mylist.size();




        Assert.assertEquals(expected,actual);


    }




    @org.junit.Test
    public void removeById() {

       service.removeCDbyId(1L);



        Assert.assertNull(service.findCD(1l));


    }


}
