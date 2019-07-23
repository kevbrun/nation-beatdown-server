package ch.nation.dbservice.entities.game;

import ch.nation.core.model.position.IVector3;
import ch.nation.core.model.position.Vector3;
import ch.nation.core.model.position.Vector3Int;
import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.entities.vectors.EmbeddableVector3Int;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name="USER_RUNTIME_INFO")
@Table(name="USER_RUNTIME_INFO")
public class GameUserRuntimeInfo extends AbstractNationEntityBase implements IDiscrimantorValue {


    @JsonProperty("consideration_time")
    private long considerationTime;
    @OneToMany(
            mappedBy = "gameInfo",
            orphanRemoval = false,
            fetch = FetchType.LAZY
    )
    @RestResource(path = "moves", rel="moves",exported = true)
    @JsonProperty("moves")
   // @OrderBy("creationTimestamp")
    //   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<BasePlayerMove> moves;

    @JsonProperty("player_uuid")
    private String playerUuid;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="game_id")
    @RestResource(path = "games",rel = "games",exported = false)
    @JsonIgnore
    private Game game;


    @JsonProperty("fow")
    @ElementCollection(targetClass = EmbeddableVector3Int.class)
    @Column(name="fow")
    private List<EmbeddableVector3Int> uncoveredFogOfWar;

    public GameUserRuntimeInfo() {
        uncoveredFogOfWar = new ArrayList<>();
        moves = new ArrayList<>();
    }


    public String getPlayerUuid() {
        return playerUuid;
    }

    public void setPlayerUuid(String playerUuid) {
        this.playerUuid = playerUuid;
    }


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public long getConsiderationTime() {
        return considerationTime;
    }

    public void setConsiderationTime(long considerationTime) {
        this.considerationTime = considerationTime;
    }

    public List<EmbeddableVector3Int> getUncoveredFogOfWar() {
        return uncoveredFogOfWar;
    }

    public void setUncoveredFogOfWar(List<EmbeddableVector3Int> uncoveredFogOfWar) {
        this.uncoveredFogOfWar = uncoveredFogOfWar;
    }

    public List<BasePlayerMove> getMoves(){
        LOGGER.info("Execute custom getter");

        if(moves==null)moves = new ArrayList<>();
        return moves;
    }

    public void setMoves(List<BasePlayerMove> moves) {
        LOGGER.info("Execute custom setter: setMoves");
        if (this.moves == null) {
            this.moves = moves;
        } else if(this.moves != moves) { // not the same instance, in other case we can get ConcurrentModificationException from hibernate AbstractPersistentCollection
            this.moves.clear();
            if(moves != null){
                this.moves.addAll(moves);
            }
        }


        //   this.moves = moves;
    }


    public void AddFogOfWarTilePositions(IVector3 vector){
        if(!uncoveredFogOfWar.contains(vector)){
            uncoveredFogOfWar.add((EmbeddableVector3Int) vector);
        }
    }

    @PrePersist
    @PreUpdate
    public void PreUpdate(){

        for(BasePlayerMove move : moves){
            move.setGameInfo(this);
        }
    }

}
