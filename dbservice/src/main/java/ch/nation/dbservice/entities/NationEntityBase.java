package ch.nation.dbservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class NationEntityBase implements Serializable {


    @JsonIgnore
    @Transient
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @JsonProperty("uuid")
    @Column(name="id")
    private UUID id;
    @Column(name = "name",unique = true,nullable = false)
    @JsonProperty("name")
    private String name;
    @Column(name="desc")
    @JsonProperty("desc")
    private String description;

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

    public NationEntityBase(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public NationEntityBase() {
    }

    public NationEntityBase(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NationEntityBase)) return false;
        NationEntityBase that = (NationEntityBase) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return "NationEntityBase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


    //JPA Annoations


    @PrePersist
    protected void onCreate() {
        LOGGER.debug(String.format("Execute onCreate()"));
        creationTimestamp = Calendar.getInstance();
        updateTimemstamp = Calendar.getInstance();

    }

    @PreUpdate
    protected void onUpdate() {
        LOGGER.debug(String.format("Execute onUpdate() | Entity id=%s,name=%s",this.getId().toString(),this.getName()));
        updateTimemstamp = Calendar.getInstance();

    }
}
