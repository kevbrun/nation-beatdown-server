package ch.nation.dbservice.entities.prejudices;


import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.NamedEntityBase;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;

@Table(name="PREJUDICE_TRIGGERS")
@Entity(name="PREJUDICE_TRIGGERS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TRIGGER_TYPE",discriminatorType = DiscriminatorType.STRING)

public class PrejudiceTrigger extends AbstractNationEntityBase {

    @ManyToMany(mappedBy = "prejudiceTriggers")
    @RestResource(path = "prejudices", rel="prejudices")
    private List<Prejudice> prejudices;


    public PrejudiceTrigger() {
    }

    public List<Prejudice> getPrejudices() {
        return prejudices;
    }

    public void setPrejudices(List<Prejudice> prejudices) {
        this.prejudices = prejudices;
    }

    @Override
    public String toString() {
        return "PrejudiceTrigger{" +
                "prejudices=" + prejudices +
                "} " + super.toString();
    }


    //Manual association func

    public void addPrejudice(Prejudice prejudice){
        if(!prejudices.contains(prejudice)){
            prejudices.add(prejudice);
            prejudice.addTrigger(this);
        }
    }

    public void removeTrigger(Prejudice prejudice){
        if(prejudices.contains(prejudice)){
            prejudices.remove(prejudice);
            prejudice.removeTrigger(this);
        }
    }
}
