package ch.nation.dbservice.entities;

import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;


@MappedSuperclass
public abstract class AbstractNationEntityBase implements Serializable, IDiscrimantorValue {
    @JsonIgnore
    @Transient
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @JsonProperty("uuid")
    @Column(name="id")
    private UUID id;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created",updatable = false)
    //@JsonFormat(shape =JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone="UTC" )
    @JsonProperty("created")
    private Calendar creationTimestamp;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated")
    @JsonProperty("updated")
    private Calendar updateTimemstamp;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Calendar getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Calendar creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Calendar getUpdateTimemstamp() {
        return updateTimemstamp;
    }

    public void setUpdateTimemstamp(Calendar updateTimemstamp) {
        this.updateTimemstamp = updateTimemstamp;
    }

    @PrePersist
    protected void onCreate() {
        LOGGER.debug(String.format("Execute onCreate()"));
        creationTimestamp = Calendar.getInstance();
        updateTimemstamp = Calendar.getInstance();

    }

    @PreUpdate
    protected void onUpdate() {
        LOGGER.debug(String.format("Execute onUpdate() | Entity id=%s,uuid=%s",this.getId().toString(),this.getId()));
        updateTimemstamp = Calendar.getInstance();

    }
}
