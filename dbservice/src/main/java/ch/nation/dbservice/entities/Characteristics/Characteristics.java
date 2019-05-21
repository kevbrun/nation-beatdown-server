package ch.nation.dbservice.entities.Characteristics;

import ch.nation.dbservice.entities.NationEntityBase;

import javax.persistence.*;
import java.util.UUID;

@Entity(name="CHARACTERISTICS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="CHARACTERISTICS_TYPE",discriminatorType = DiscriminatorType.STRING)
public class Characteristics extends NationEntityBase {


    public Characteristics() {
        super();
    }

    public Characteristics(String name) {
        super(name);
    }


}
