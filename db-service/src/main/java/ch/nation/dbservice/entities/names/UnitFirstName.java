package ch.nation.dbservice.entities.names;

import ch.nation.core.model.Enums.Sex;
import ch.nation.dbservice.entities.SimpleIdEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class UnitFirstName {

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "first_name", unique = true, nullable = false)
    @JsonProperty("first_name")
    private String firstName;


    @Column(name = "sex")
    @JsonProperty("sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;


    public UnitFirstName() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}
