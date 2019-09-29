package ch.nation.dbservice.entities.user;

import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.entities.NamedEntityBase;
import ch.nation.dbservice.entities.game.Game;
import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.entities.units.Unit;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;

@Entity(name="USER")
@Table(name="USER")
public class User extends NamedEntityBase implements Serializable {




    @Column(name="password",nullable = false)
    @JsonProperty("password")
    private String password;
    @Column(name="admin")
    @JsonProperty("admin")
    private boolean isAdmin;
    @OneToOne(cascade = ALL,fetch = FetchType.EAGER)
    @JsonManagedReference
    @RestResource(path="nation",rel = "nation",exported = false)
    private Nation nation;

    @ManyToMany(mappedBy = "users",fetch = FetchType.LAZY)
    @RestResource(path = "games", rel="games")
    private List<Game> games;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @RestResource(path = "units", rel="units")
    private List<Unit> units = new ArrayList<>();

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @RestResource(path = "moves", rel="moves")
    private List<BasePlayerMove> playerMoves = new ArrayList<>();

    public User() {


        super();
        games = new ArrayList<>();
        units = new ArrayList<>();

    }

    public User(String name, String description, String password, boolean isAdmin, Nation nation, List<Game> games) {
        super(name, description);
        this.password = password;
        this.isAdmin = isAdmin;
        this.nation = nation;
        this.games = games;
    }

    public List<BasePlayerMove> getPlayerMoves() {
        return playerMoves;
    }

    public void setPlayerMoves(List<BasePlayerMove> playerMoves) {
        if (this.playerMoves == null) {
            this.playerMoves = playerMoves;
        } else if(this.playerMoves != playerMoves) { // not the same instance, in other case we can get ConcurrentModificationException from hibernate AbstractPersistentCollection
            this.playerMoves.clear();
            if(playerMoves != null){
                this.playerMoves.addAll(playerMoves);
            }
        }





    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        if (this.games == null) {
            this.games = games;
        } else if(this.games != games) { // not the same instance, in other case we can get ConcurrentModificationException from hibernate AbstractPersistentCollection
            this.games.clear();
            if(games != null){
                this.games.addAll(games);
            }
        }



        //this.games = games;
    }

    public List<Unit> getUnits() {


        return units;
    }

    public void setUnits(List<Unit> units) {
      if (this.units == null) {
            this.units = units;
        } else if(this.units != units) { // not the same instance, in other case we can get ConcurrentModificationException from hibernate AbstractPersistentCollection
            this.units.clear();
            if(units != null){
                this.units.addAll(units);
            }
        }



   // this.units = units;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return isAdmin == user.isAdmin &&

                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), password, isAdmin);
    }


    //Manual functions

    public void addUnit(Unit unit) {
        units.add(unit);
        unit.setUser(this);
    }

    public void removeUnit(Unit comment) {
        units.remove(comment);
        comment.setUser(null);
    }

    public void addGame(Game game){
        if(!this.games.contains(game)){
            this.games.add(game);
            game.addUser(this);
        }
    }


    public void removeGame(Game game){
        if(this.games.contains(game)){
            this.games.remove(game);
            game.removeUser(this);
        }
    }

    public void removePlayerMove(BasePlayerMove move){
        if(getPlayerMoves().contains(move)){
            getPlayerMoves().remove(move);
            move.removeUser();
        }
    }

    @PrePersist
    @PreUpdate
    public void updateAddressAssociation(){
        for(Unit unit : this.units){
            unit.setUser(this);
        }

        for(Game game: this.games){
            game.addUser(this);
        }
    }

}