package ch.nation.dbservice.entities.Characteristics;

import ch.nation.dbservice.entities.NationEntityBase;

import javax.persistence.*;

@Entity(name="CHARACTERISTICS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="CHARACTERISTICS_TYPE")
public class Characteristics extends NationEntityBase {
}
