package ch.nation.dbservice.entities.Prejudices;

import ch.nation.dbservice.entities.NationEntityBase;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "prejudice")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class Prejudice extends NationEntityBase {
}
