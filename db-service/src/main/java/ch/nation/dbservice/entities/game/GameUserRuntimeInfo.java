package ch.nation.dbservice.entities.game;

import ch.nation.core.model.position.IVector3;
import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.interfaces.IDiscrimantorValue;
import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.entities.moves.SkillPlayerMove;
import ch.nation.dbservice.entities.vectors.EmbeddableVector3Int;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fog_id")
    @Column(name="fow")
    @RestResource(path="fow",rel="fow",exported = false)
    private Set<FogOfWar> uncoveredFogOfWar;

    public GameUserRuntimeInfo() {
        uncoveredFogOfWar = new HashSet<>();
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

    public Set<FogOfWar> getUncoveredFogOfWar() {
        return uncoveredFogOfWar;
    }

    public void setUncoveredFogOfWar(Set<FogOfWar> uncoveredFogOfWar) {
        LOGGER.debug("Execute custom setter");


        if (this.uncoveredFogOfWar == null) {
            this.uncoveredFogOfWar = uncoveredFogOfWar;
        } else {
            this.uncoveredFogOfWar.retainAll(uncoveredFogOfWar);
            this.uncoveredFogOfWar.addAll(uncoveredFogOfWar);
        }
    }

    public List<BasePlayerMove> getMoves(){
        LOGGER.debug("Execute custom getter");

        if(moves==null)moves = new ArrayList<>();
        return moves;
    }

    public void setMoves(List<BasePlayerMove> moves) {
        LOGGER.debug("Execute custom setter: setMoves");
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
            uncoveredFogOfWar.add((FogOfWar) vector);
        }
    }

    public void removeMove(BasePlayerMove move){
        if(getMoves().contains(move)){
            getMoves().remove(move);
            move.setGameInfo(null);
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
