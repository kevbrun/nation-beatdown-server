package ch.nation.dbservice.dummyImporter.data.players;

import ch.nation.dbservice.dummyImporter.data.AbstractDummyGenerator;
import ch.nation.dbservice.entities.units.Unit;
import ch.nation.dbservice.entities.user.Nation;
import ch.nation.dbservice.entities.user.User;
import ch.nation.dbservice.repositories.units.UnitRepository;
import ch.nation.dbservice.repositories.user.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PlayerClassDummyGenerator extends AbstractDummyGenerator<User> {

    private final UserRepository userRepository;
    private final UnitRepository unitRepository;
    private final BCryptPasswordEncoder encoder;


    public PlayerClassDummyGenerator(UserRepository repository, UnitRepository unitRepository, BCryptPasswordEncoder encoder) throws Exception {
        this.userRepository = repository;
        this.unitRepository = unitRepository;
        this.encoder = encoder;
        handleCration();
    }

    @Override
    protected void handleCration() throws Exception {
        craeateDummyPlayer();
    }

    private void craeateDummyPlayer() {
        User user = new User();
        user.setName("DummyPlayer");
        user.setPassword(encoder.encode("123"));
        Nation nation = new Nation();
        nation.setName("Dummy Nation");
        user.setNation(nation);


        user = userRepository.save(user);

        Iterable<Unit> units = unitRepository.findAll();


        for (Unit unit :
                units) {

            user.addUnit(unit);
            user = userRepository.save(user);

        }

        userRepository.save(user);

    }


}
