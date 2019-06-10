package ch.nation.dbservice.entities.user;


import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.NamedEntityBase;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name="NATION")
@Table(name="NATION")
public class Nation extends NamedEntityBase implements Serializable {

    @OneToOne(mappedBy = "nation")
    @RestResource(path = "user", rel="user",exported = false)
    @JsonBackReference
    private User user;

    public Nation(){
        super();
    }

    public User getUser() {



        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Nation{" +
                "user=" + user +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nation)) return false;
        if (!super.equals(o)) return false;
        Nation nation = (Nation) o;
        return Objects.equals(user, nation.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), user);
    }
}
