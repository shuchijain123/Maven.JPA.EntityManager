package entities;

import javax.persistence.*;

@Entity
@Table(name = "artist", schema = "entitylab", catalog = "")
public class ArtistEntity {
    private Integer id;

    public ArtistEntity(int id, String firstName, String lastName, String instrument) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.instrument = instrument;
    }

    private String firstName;
    private String lastName;
    private String instrument;

    public ArtistEntity() {
    }
   // @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "id", referencedColumnName = "id")

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 10)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 20)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "instrument", nullable = true, length = 10)
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
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (instrument != null ? !instrument.equals(that.instrument) : that.instrument != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (instrument != null ? instrument.hashCode() : 0);
        return result;
    }
}
