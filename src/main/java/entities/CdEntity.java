package entities;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "CD", schema = "entitylab")
public class CdEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name=  "id")
    private long id;
    @Basic
    @Column(name=  "description")
    private String description;
    @Basic
    @Column(name=  "price")
    private String price;
    @Basic
    @Column(name=  "title")
    private String title;
    @Basic
    @Column(name=  "year")
    private Integer year;




    public CdEntity( String title,String description,  Integer year, String artist,String price,Set<ArtistEntity> artists) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.title = title;
        this.year = year;
        this.artist=artist;
        this.artists = artists;
    }

    public CdEntity() {
    }




    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "artist_cd",
            joinColumns = @JoinColumn(name = "cd_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private Set<ArtistEntity> artists = new HashSet<ArtistEntity>();


    public Set<ArtistEntity> getArtists() {

        return artists;
    }



    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    private String artist;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }



    public void setArtists(Set<ArtistEntity> artists) {
        this.artists = artists;
    }


    public void addartist(ArtistEntity artist) {
        Set<ArtistEntity> artists = new HashSet<ArtistEntity>();


        artists.add(artist);
         artist.getCds().add(this);



    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CdEntity cdEntity = (CdEntity) o;

        if (id != cdEntity.id) return false;
        if (description != null ? !description.equals(cdEntity.description) : cdEntity.description != null)
            return false;
        if (price != null ? !price.equals(cdEntity.price) : cdEntity.price != null) return false;
        if (title != null ? !title.equals(cdEntity.title) : cdEntity.title != null) return false;
        if (year != null ? !year.equals(cdEntity.year) : cdEntity.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }


    @Override


    public String toString(){

        String cdstring = String.format("id   : " + this.id + "title   : "+this.title + " description  :  "
                +this.description +"price :   " +this.price +"year  :   "+this.year+"artist  :   "+this.artist);

        return cdstring;
    }
}
