package ch.nation.dbservice.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="Nation")
public class Nation extends NationEntityBase implements Serializable {


    @Column(unique = true)
    private String nationName;


    public Nation(long id, String uuid, String nationName) {
        super(id, uuid);
        this.nationName = nationName;
    }

    public Nation(String nationName) {
        this.nationName = nationName;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nation)) return false;
        if (!super.equals(o)) return false;
        Nation nation = (Nation) o;
        return Objects.equals(nationName, nation.nationName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), nationName);
    }
}
