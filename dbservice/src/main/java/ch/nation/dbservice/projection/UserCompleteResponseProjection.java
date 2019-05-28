package ch.nation.dbservice.projection;

import ch.nation.dbservice.entities.user.Nation;
import ch.nation.dbservice.entities.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

@Projection(name="userCompleteResponse",types = User.class)
public interface UserCompleteResponseProjection {

    @JsonProperty("uuid")
    public UUID getId();

    public String getName();
    public String getDescription();
    public boolean isAdmin();
    public Nation getNation();




}
