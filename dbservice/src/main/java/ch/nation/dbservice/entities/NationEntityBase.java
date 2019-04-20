package ch.nation.dbservice.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class NationEntityBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="uuid",unique = true,nullable = false)
    private String uuid;

    @Column(name = "name",unique = true,nullable = false)
    private String name;
    @Column(name="description")
    private String description;

    @PrePersist
    void preInsert() {
        if (this.uuid == null)   this.uuid = UUID.randomUUID().toString();
    }


    public NationEntityBase(long id, String uuid) {
        this.id = id;
        this.uuid = uuid;
    }

    public NationEntityBase(long id, String uuid, String description) {
        this.id = id;
        this.uuid = uuid;
        this.description = description;
    }

    public NationEntityBase(long id, String uuid, String name, String description) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.description = description;
    }

    public NationEntityBase() {
        this.uuid = UUID.randomUUID().toString();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NationEntityBase)) return false;
        NationEntityBase that = (NationEntityBase) o;
        return id == that.id &&
                Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, uuid);
    }

    @Override
    public String toString() {
        return "NationEntityBase{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
