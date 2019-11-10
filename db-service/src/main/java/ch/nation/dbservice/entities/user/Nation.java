package ch.nation.dbservice.entities.user;


import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.dbservice.entities.characteristics.BaseCharacteristic;
import ch.nation.dbservice.entities.prejudices.BasePrejudice;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity(name="NATION")
@Table(name="NATION")
@AttributeOverride(name = "name", column = @Column(name = "name",unique = false,nullable = false))
public class Nation extends NamedEntityBase implements Serializable {

    @OneToOne(mappedBy = "nation")
    @RestResource(path = "user", rel="user",exported = false)
    @JsonBackReference
    private User user;


    @ManyToMany
    @RestResource(path = "characteristics",rel = "characteristics",exported = false)
    @JsonProperty("characteristics")
    private List<BaseCharacteristic> characteristics;


    @ManyToMany
    @RestResource(path = "prejudices",rel = "prejudices",exported = false)
    @JsonProperty("prejudices")
    private List<BasePrejudice> prejudices;


    public Nation(){
        super();
    }

    public User getUser() {



        return user;
    }




    public List<BasePrejudice> getPrejudices() {
        return prejudices;
    }

    public void setPrejudices(List<BasePrejudice> prejudices) {
        this.prejudices = prejudices;
    }
    public List<BaseCharacteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<BaseCharacteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nation)) return false;
        if (!super.equals(o)) return false;
        Nation nation = (Nation) o;
        return Objects.equals(user, nation.user) &&
                Objects.equals(characteristics, nation.characteristics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), user, characteristics);
    }

    @Override
    public String toString() {
        return "Nation{" +
                "user=" + user +
                ", characteristics=" + characteristics +
                '}';
    }



}
