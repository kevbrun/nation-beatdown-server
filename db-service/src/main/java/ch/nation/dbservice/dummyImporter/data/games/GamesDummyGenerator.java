package ch.nation.dbservice.dummyImporter.data.games;

import ch.nation.core.model.Enums.GameStatus;
import ch.nation.dbservice.dummyImporter.data.AbstractDummyGenerator;
import ch.nation.dbservice.entities.game.Game;
import ch.nation.dbservice.entities.game.GameUserRuntimeInfo;
import ch.nation.dbservice.entities.user.User;
import ch.nation.dbservice.repositories.game.GameRepository;
import ch.nation.dbservice.repositories.game.GameUserRuntimeRepository;
import ch.nation.dbservice.repositories.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GamesDummyGenerator extends AbstractDummyGenerator {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final GameUserRuntimeRepository gameUserRuntimeRepository;


    public GamesDummyGenerator(GameRepository gameRepository, UserRepository userRepository, GameUserRuntimeRepository gameUserRuntimeRepository) throws Exception {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.gameUserRuntimeRepository = gameUserRuntimeRepository;

        handleCration();
    }

    @Override
    protected void handleCration() throws Exception {

        User user = userRepository.findByName("DummyPlayer");

        GameUserRuntimeInfo info = new GameUserRuntimeInfo();
        info.setConsiderationTime(30000);
        info.setPlayerUuid(user.getId().toString());

        info = gameUserRuntimeRepository.save(info);


        Game game = new Game();

        game.setFirstPlayerUuid(user.getId().toString());
        game.setNextPlayerUuid(user.getId().toString());
        game.setCurrentPlayerUuid(user.getId().toString());
        game.setGameStatus(GameStatus.Finished);
        game.setUsers(new ArrayList<>());
        game.setUserRuntimeInfos(new ArrayList<>());
        game = gameRepository.save(game);


        //  List<GameUserRuntimeInfo> infos = new ArrayList<>(1);
        //   infos.add(info);


        game.addUserRuntimeInfos(info);
        //   game.setUserRuntimeInfos(infos);

        game = gameRepository.save(game);

    }
}
