package ch.nation.dbservice.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="Nation")
public class Nation extends NationEntityBase implements Serializable {

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    public Nation(UUID id, String name, String description, User user) {
        super(id, name, description);
        this.user = user;
    }

    public Nation(User user) {
        this.user = user;

    }


    public Nation(String name){
        super(name);
    }


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

    @Override
    public String toString() {
        return "Nation{" +
                "user=" + user +
                "} " + super.toString();
    }
}
