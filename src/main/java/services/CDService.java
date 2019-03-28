package services;


import entities.CdEntity;


import javax.persistence.*;
import java.util.*;

public class CDService {


    EntityManager em = null;
    EntityTransaction tx = null;

    public CDService(EntityManager em) {
        this.em = em;
        this.tx = em.getTransaction();
    }

    public CDService() {

        this.em = em;
        this.tx = em.getTransaction();


    }


    public CdEntity createCD(String title, String description, int year, String artist, String price) {

        CdEntity cd = new CdEntity();
        cd.setTitle(title);
        cd.setDescription(description);
        cd.setYear(year);
        cd.setPrice(price);
        cd.setArtist(artist);


        tx.begin();
        em.persist(cd);
        tx.commit();

        return cd;
    }








    public CdEntity createCD(CdEntity cd) {
        tx.begin();
        em.persist(cd);
        tx.commit();
        return cd;
    }


    public CdEntity findCD(long id) {

       // System.out.println("Found CD : " +  em.find(CdEntity.class, id).toString());
        return em.find(CdEntity.class, id);


    }




        public List<CdEntity> findAllCds() {
            List<CdEntity> query = em.createQuery("SELECT e FROM CdEntity e").getResultList();

            if (query == null) {
                System.out.println("No persons found . ");
            } else {
                for (CdEntity cd : query) {
                    for (long i = 1; i < query.size(); i++) {

                        findCD(i);


                    }
                }
            }

            return query;
        }




    public void removeCD(CdEntity cd){
        CdEntity cdToBeDeleted = em.merge(cd);
        tx.begin();
        em.remove(cdToBeDeleted);
        tx.commit();

    }


    public void removeCDbyId(Long id){
        CdEntity cd = em.find(CdEntity.class, id);
        if(cd != null){
            tx.begin();
            em.remove(cd);
            tx.commit();
        }
    }



}




