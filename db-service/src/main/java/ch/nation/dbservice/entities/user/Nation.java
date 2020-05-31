package ch.nation.dbservice.entities.user;


import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.dbservice.entities.characteristics.BaseCharacteristic;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "NATION")
@Table(name = "NATION")
@AttributeOverride(name = "name", column = @Column(name = "name", unique = false, nullable = false))
//@AttributeOverride(name = "id", column = @Column(name = "nations_id"))
public class Nation extends NamedEntityBase implements Serializable {

    @OneToOne(mappedBy = "nation")
    @RestResource(path = "user", rel = "user", exported = false)
    @JsonBackReference
    private User user;


    //TODO Check comment below
    @ManyToMany
    @RestResource(path = "characteristics", rel = "characteristics", exported = false)
    @JoinTable(name = "NATIONS_CHARACTERISTICS",
            joinColumns = @JoinColumn(name = "NATIONS_id"),
            inverseJoinColumns = @JoinColumn(name = "CHARACTERISTICS_ID"))
    @JsonProperty("characteristics")
    // @JoinColumn(name = "nations_id") //TODO CHECK IF THIS IS THE PROBLEM
    private List<BaseCharacteristic> characteristics;


    /**
     * // @ManyToMany
     * //@RestResource(path = "prejudices", rel = "prejudices", exported = false)
     * //@JoinTable(name="NATIONS_PREJUDICES",
     * joinColumns = @JoinColumn(name = "NATIONS_ID"),
     * inverseJoinColumns = @JoinColumn(name = "PREJUDICES_ID"))
     * // @JsonProperty("prejudices")
     * private List<BasePrejudice> prejudices;
     **/


    public Nation() {
        super();
        //  prejudices = new ArrayList<>();
        characteristics = new ArrayList<>();
    }

    public User getUser() {


        return user;
    }


    /**
     * public List<BasePrejudice> getPrejudices() {
     * <p>
     * if(prejudices==null) prejudices = new ArrayList<>();
     * return prejudices;
     * }
     * <p>
     * public void setPrejudices(List<BasePrejudice> prejudices) {
     * this.prejudices = prejudices;
     * }
     **/

    public List<BaseCharacteristic> getCharacteristics() {

        if (characteristics == null) characteristics = new ArrayList<>();
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
