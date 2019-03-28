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
        ArtistService service2 = new ArtistService(em);

        Set<ArtistEntity> tcq = new HashSet<ArtistEntity>();
        ArtistEntity  artist1 = new ArtistEntity( "Tip","Top","Flute",null);
        ArtistEntity  artist2 =new ArtistEntity("Phife", "Dawg","Chelo",null);
        ArtistEntity  artist3=new ArtistEntity("Shaheed", "Muhammad","Guitar",null);
        ArtistEntity  artist4=new ArtistEntity("Jarobi", "White","violin",null);

        tcq.add(artist1);
        tcq.add(artist2);



        Set<CdEntity> mycds = new HashSet<CdEntity>();


        CdEntity cd1 = new CdEntity("The Low End Theory", "Released: September 24, 1991",2001 ,"Hip Hop","200",null);
        CdEntity cd2 = new CdEntity("The High End Theory", "Released: September 24, 1991",2003 ,"Hip Hop","200",null);
        CdEntity cd3 = new CdEntity("The Urs End Theory", "Released: September 24, 1991",2004 ,"Hip Hop","200",null);

   mycds.add(cd1);
   mycds.add(cd2);
   mycds.add(cd3);



        //cd1.addartist(artist1);
        //cd1.addartist(artist2);
        //cd1.addartist(artist3);
        //cd1.addartist(artist4);

        cd1.setArtists(tcq);



      //  em.persist(cd1);




        service.createCD(cd1);






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