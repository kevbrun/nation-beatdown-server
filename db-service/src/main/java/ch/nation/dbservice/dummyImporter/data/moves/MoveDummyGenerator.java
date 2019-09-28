package ch.nation.dbservice.dummyImporter.data.moves;

import ch.nation.dbservice.dummyImporter.data.AbstractDummyGenerator;
import ch.nation.dbservice.entities.game.Game;
import ch.nation.dbservice.entities.game.GameUserRuntimeInfo;
import ch.nation.dbservice.entities.moves.BasePlayerMove;
import ch.nation.dbservice.entities.moves.SkillPlayerMove;
import ch.nation.dbservice.entities.moves.values.BasePlayerMoveValue;
import ch.nation.dbservice.entities.moves.values.MoveSkillPlayerMoveValue;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.units.EmeddableVector3;
import ch.nation.dbservice.entities.user.User;
import ch.nation.dbservice.repositories.game.GameRepository;
import ch.nation.dbservice.repositories.game.GameUserRuntimeRepository;
import ch.nation.dbservice.repositories.moves.PlayerMoveRepository;
import ch.nation.dbservice.repositories.skills.SkillRepository;
import ch.nation.dbservice.repositories.user.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class MoveDummyGenerator extends AbstractDummyGenerator<BasePlayerMove> {

    private final UserRepository userRepository;
    private final PlayerMoveRepository playerMoveRepository;
    private final GameRepository gameRepository;
    private final SkillRepository skillRepository;
    private final GameUserRuntimeRepository gameUserRuntimeRepository;

    public MoveDummyGenerator(final UserRepository userRepository, final PlayerMoveRepository playerMoveRepository, GameRepository gameRepository, SkillRepository skillRepository, GameUserRuntimeRepository gameUserRuntimeRepository) throws Exception {
        super();
        this.userRepository = userRepository;
        this.playerMoveRepository = playerMoveRepository;
        this.gameRepository = gameRepository;
        this.skillRepository = skillRepository;
        this.gameUserRuntimeRepository = gameUserRuntimeRepository;
        handleCration();
    }


    private void createMove(){


       User player= userRepository.findByName("DummyPlayer");


        Game game = new Game();
        game.setCurrentPlayerUuid(player.getId().toString());
        game.setNextPlayerUuid(player.getId().toString());
        game.setFirstPlayerUuid(player.getId().toString());
        game.setUserRuntimeInfos(new ArrayList<>());
        game.setUsers(new ArrayList<>());

        List<GameUserRuntimeInfo> infos =new ArrayList<>();
        GameUserRuntimeInfo info = new GameUserRuntimeInfo();

        info.setPlayerUuid(player.getId().toString());
        info.setConsiderationTime(6000);
                infos.add(info);
        game.setUserRuntimeInfos(infos);

       game = gameRepository.save(game);



       SkillPlayerMove move = new SkillPlayerMove();
        MoveSkillPlayerMoveValue value = new MoveSkillPlayerMoveValue();

        value.setTargetPosition(new EmeddableVector3(0.4f,0.0f,-100f));
        value.setSourcePosition(new EmeddableVector3(0.4f,0.0f,-160f));
        move.setSkillCost(2323);
        move.setRound(5);
        ArrayList<BasePlayerMoveValue> values =new ArrayList<>();

        values.add(value);
        move.setAppliedEffects(values);

         move= playerMoveRepository.save(move);

        // move.setGame(game);
        move.setUser(player);
        move.setCaster(player.getUnits().get(0));
        move.setCaster(player.getUnits().get(0));

        Skill skill = skillRepository.findByName("Bewegung Schweinebacke!");

        move.setSkill(skill);

        move = playerMoveRepository.save(move);

    }




    @Override
    public List<BasePlayerMove> createdEntities() {
        return null;
    }

    @Override
    protected void handleCration() throws Exception {
        createMove();
    }

    @Override
    public void persistData() {

    }
}
