package ch.nation.core.model;

import java.io.Serializable;

public class NationModel  extends AbstractNationModelBase implements Serializable {

    private UserModel user;


    public NationModel(UserModel user) {
        this.user = user;
    }

    public NationModel(){
        super();
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "NationModel{" +
                "user=" + user +
                "} " + super.toString();
    }
}

