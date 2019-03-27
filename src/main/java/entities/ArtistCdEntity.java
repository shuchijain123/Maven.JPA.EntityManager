package entities;

import javax.persistence.*;

@Entity
@Table(name = "artist_cd", schema = "entitylab", catalog = "")
public class ArtistCdEntity {
    private int cdId;
    private Integer artistId;

    @Id
    @Column(name = "cd_id", nullable = false)
    public int getCdId() {
        return cdId;
    }

    public void setCdId(int cdId) {
        this.cdId = cdId;
    }

    @Basic
    @Column(name = "artist_id", nullable = true)
    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistCdEntity that = (ArtistCdEntity) o;

        if (cdId != that.cdId) return false;
        if (artistId != null ? !artistId.equals(that.artistId) : that.artistId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cdId;
        result = 31 * result + (artistId != null ? artistId.hashCode() : 0);
        return result;
    }
}
