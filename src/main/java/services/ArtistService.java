package services;


import entities.ArtistEntity;
import entities.CdEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArtistService {


    EntityManager em = null;
    EntityTransaction tx = null;



    public ArtistService(EntityManager em) {
        this.em = em;
        this.tx = em.getTransaction();
    }

    public ArtistService() {

        this.em = em;
        this.tx = em.getTransaction();


    }




    public ArtistEntity createArtist(String firstName, String lastName, String instrument) {

        ArtistEntity artist = new ArtistEntity();




        tx.begin();
        em.persist(artist);
        tx.commit();

        return artist;
    }


    public ArtistEntity createArtist(ArtistEntity artist) {
        tx.begin();
        em.persist(artist);
        tx.commit();
        return artist;
    }


    public ArtistEntity findArtist(long id) {

       // System.out.println("Found CD : " +  em.find(CdEntity.class, id).toString());
        return em.find(ArtistEntity.class, id);


    }







    public List<ArtistEntity> findAllArtists() {
            List<ArtistEntity> query = em.createQuery("SELECT e FROM ArtistEntity e").getResultList();

            if (query == null) {
                System.out.println("No persons found . ");
            } else {
                for (ArtistEntity artist : query) {
                    for (long i = 1; i < query.size(); i++) {

                        findArtist(i);


                    }
                }
            }

            return query;
        }




    public void removeArtist(ArtistEntity artist){
        ArtistEntity artsitToBeDeleted = em.merge(artist);
        tx.begin();
        em.remove(artsitToBeDeleted);
        tx.commit();

    }


    public void removeArtistbyId(Long id){
        ArtistEntity artist = em.find(ArtistEntity.class, id);
        if(artist != null){
            tx.begin();
            em.remove(artist);
            tx.commit();
        }
    }



}




