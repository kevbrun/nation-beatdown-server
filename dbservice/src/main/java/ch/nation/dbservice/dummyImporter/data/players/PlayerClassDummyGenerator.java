package ch.nation.dbservice.dummyImporter.data.players;

import ch.nation.dbservice.dummyImporter.data.AbstractDummyGenerator;
import ch.nation.dbservice.entities.units.Unit;
import ch.nation.dbservice.entities.user.Nation;
import ch.nation.dbservice.entities.user.User;
import ch.nation.dbservice.repositories.units.UnitRepository;
import ch.nation.dbservice.repositories.user.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class PlayerClassDummyGenerator extends AbstractDummyGenerator<User> {

    private final UserRepository userRepository;
    private final UnitRepository unitRepository;

    public PlayerClassDummyGenerator(UserRepository repository, UnitRepository unitRepository) throws Exception {
        this.userRepository = repository;
        this.unitRepository = unitRepository;
        handleCration();
    }

    @Override
    protected void handleCration() throws Exception {
        craeateDummyPlayer();
    }

    private void craeateDummyPlayer(){
        User user = new User();
        user.setName("DummyPlayer");
        user.setPassword("123");
        Nation nation = new Nation();
        nation.setName("Dummy Nation");
        user.setNation(nation);


        userRepository.save(user);

        Iterable<Unit> units= unitRepository.findAll();

        List<Unit> unitList = new ArrayList<>();
        units.forEach((item)-> user.addUnit(item));
       // user.setUnits(unitList);

        userRepository.save(user);

    }
}
