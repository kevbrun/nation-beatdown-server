package ch.nation.rest.logic.controller;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;
import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;
import ch.nation.core.model.dto.move.BasePlayerMoveDto;
import ch.nation.core.model.position.Vector3Int;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/logic")
public class GameLogicController {

    private final GameLogicService gameLogicService;


    @Autowired
    public GameLogicController(final GameLogicService gameLogicService) {
        this.gameLogicService = gameLogicService;
    }

    @RequestMapping(method = RequestMethod.POST,consumes ="application/json", path = "/{gameUuid}/{playerUuid}")
    public ResponseEntity addUnitMove(@PathVariable("gameUuid") String gameUuid, @PathVariable("playerUuid") String playerUuid, @RequestBody BasePlayerMoveDto move) throws Exception {
        if(gameUuid==null ||gameUuid.isEmpty())throw new IllegalArgumentException("GameUuid is null or empty!");
        if(playerUuid==null ||playerUuid.isEmpty())throw new IllegalArgumentException("GameUuid is null or empty!");
        if(move==null) throw new IllegalArgumentException("Move is null!");
        return gameLogicService.addMove(gameUuid,playerUuid,move);
    }

    @RequestMapping(method = RequestMethod.PUT,consumes ="application/json", path = "/{gameUuid}/{playerUuid}")
    public ResponseEntity updateFogOfWar(@PathVariable("gameUuid") String gameUuid, @PathVariable("playerUuid") String playerUuid, @RequestBody List<Vector3Int> uncoveredFogOfWar) throws Exception {
        if(gameUuid==null ||gameUuid.isEmpty())throw new IllegalArgumentException("GameUuid is null or empty!");
        if(playerUuid==null ||playerUuid.isEmpty())throw new IllegalArgumentException("GameUuid is null or empty!");
        return gameLogicService.updateFogOfWarByPlayerAndGame(gameUuid,playerUuid,uncoveredFogOfWar);
    }

   /** @RequestMapping(method = RequestMethod.GET, path = "/{gameUuid}/{playerUuid}/{casterUuid}")
    public ResponseEntity<List<AbstractPlayerMoveDto>> getMovesOfUnitByGameUuidAndPlayerUuidAndRound(@PathVariable("gameUuid") String gameUuid, @PathVariable("playerUuid") String playerUuid, @PathVariable("casterUuid") String casterUuid,@RequestParam("round") int round, @RequestParam(value = "projection",required = false) QueryProjection projection) throws Exception {

        return gameLogicService.getMovesOfUnitByGameUuidAndPlayerUuidAndRound(gameUuid,playerUuid,casterUuid,round,projection);

    }**/




    @RequestMapping(method = RequestMethod.PUT,path="/{gameUuid}")
    public ResponseEntity<?> endTurn(@PathVariable("gameUuid") String gameUuid, @RequestBody GameUserRuntimeInfoDto currentPlayerRuntimeInfo) throws Exception {
        return gameLogicService.endTurn(gameUuid,currentPlayerRuntimeInfo);
    }




}
