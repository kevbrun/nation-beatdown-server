package ch.nation.core.model;

import java.io.Serializable;

public class NationModel  extends AbstractNationModelBase implements Serializable {

    private UserModel user;

    public NationModel(String uuid, UserModel user) {
        super(uuid);
        this.user = user;
    }

    public NationModel(UserModel user) {
        this.user = user;
    }

    public NationModel(String uuid, String description, UserModel user) {
        super(uuid, description);
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



}

