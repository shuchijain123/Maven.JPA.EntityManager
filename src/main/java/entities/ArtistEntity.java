package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artist", schema = "entitylab")
public class ArtistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

  @Basic
  @Column(name=  "first_name")
  private String first_name;
  @Basic
  @Column(name=  "last_name")
  private String last_name;

    @Basic
    @Column(name=  "instrument")
    private String instrument;


    public ArtistEntity() {


    }




    public void setCds(Set<CdEntity> cds) {


        this.cds = cds;
    }
    public Set<CdEntity> getCds()

    {
        return cds;
    }






    @ManyToMany(mappedBy = "artists", cascade = CascadeType.ALL)
    public Set<CdEntity> cds= new HashSet<CdEntity>();



    public ArtistEntity(String first_name, String last_name, String instrument, Set<CdEntity> cds) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.instrument = instrument;
        this.cds = cds;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }


    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistEntity that = (ArtistEntity) o;

        if (id != that.id) return false;
        if (first_name != null ? !first_name.equals(that.first_name) : that.first_name != null) return false;
        if (last_name != null ? !last_name.equals(that.last_name) : that.last_name != null) return false;
        if (instrument != null ? !instrument.equals(that.instrument) : that.instrument != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        result = 31 * result + (instrument != null ? instrument.hashCode() : 0);
        return result;
    }
}


