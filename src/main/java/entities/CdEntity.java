package entities;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "CD", schema = "entitylab", catalog = "")
public class CdEntity {

    private long id;
    private String description;
    private String price;
    private String title;
    private Integer year;



    //@OneToMany()
    @OneToMany(cascade = ALL, fetch = FetchType.EAGER) // {PERSIST, REMOVE, MERGE, ALL}, EAGER || LAZY
    @JoinColumn(name = "cd_id")
    private CdEntity cdEntity;
    private Set<ArtistEntity> artists = new HashSet<ArtistEntity>();

    public CdEntity( String title,String description,  Integer year, String artist,String price,Set<ArtistEntity> artists) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.title = title;
        this.year = year;
        this.artist = artist;
    }

    public CdEntity() {
    }







    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    private String artist;


    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 3000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price", nullable = true, length = 3000)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "year", nullable = true)
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Set<ArtistEntity> getArtists() {
        return artists;
    }

    public void setArtists(Set<ArtistEntity> artists) {
        this.artists = artists;
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
