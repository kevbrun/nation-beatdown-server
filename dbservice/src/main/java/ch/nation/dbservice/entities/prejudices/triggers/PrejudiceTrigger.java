package ch.nation.dbservice.entities.prejudices.triggers;


import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.dbservice.entities.prejudices.Prejudice;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public PrejudiceTrigger(List<Prejudice> prejudices) {
        this.prejudices = prejudices;
    }

    public List<Prejudice> getPrejudices() {

if(prejudices==null)        prejudices = new ArrayList<>();

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
        if(!getPrejudices().contains(prejudice)){
            getPrejudices().add(prejudice);
            prejudice.addTrigger(this);
        }
    }

    public void removeTrigger(Prejudice prejudice){
        if(getPrejudices().contains(prejudice)){
            getPrejudices().remove(prejudice);
            prejudice.removeTrigger(this);
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof PrejudiceTrigger)) return false;
        if (!super.equals(o)) return false;
        PrejudiceTrigger that = (PrejudiceTrigger) o;
        return Objects.equals(prejudices, that.prejudices);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), prejudices);
    }
}
