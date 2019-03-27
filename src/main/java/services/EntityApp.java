package services;

//import entities.Musician;


import entities.ArtistEntity;
import entities.CdEntity;

        import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;


public class EntityApp {

    public static void main(String[] arg) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entitylab");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        CDService service = new CDService(em);

        Set<ArtistEntity> tcq = new HashSet<ArtistEntity>();
        tcq.add(new ArtistEntity(1, "Tip","Top","Flute"));
        tcq.add(new ArtistEntity(2,"Phife", "Dawg","Chelo"));
        tcq.add(new ArtistEntity(3,"Shaheed", "Muhammad","Guitar"));
        tcq.add(new ArtistEntity(4,"Jarobi", "White","violin"));


        CdEntity cd1 = service.createCD(new CdEntity("The Low End Theory", "Released: September 24, 1991",2001 ,"Hip Hop","200",tcq));

       // CdEntity cd2 = service.createCD(new CdEntity("The High End Theory", "Released: October 12, 2001",1999 ,"Country","100"));

       // CdEntity cd = new CdEntity();


      //  cd.setId(1);
//
      // cd  = service.findCD(cd.getId());

      // System.out.println("Found CD : " + cd.toString());

       // service.findAllCds();



       // service.removeCDbyId(1L);




       // CdEntity myCd = new CdEntity("The Low End Theory", "Released: September 24, 1991",
              //  2001 ,"Hip Hop","200");
        //service.removeCD(myCd);

    }



}