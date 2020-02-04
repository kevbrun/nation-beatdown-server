package ch.nation.rest.logic.controller;

import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;
import ch.nation.core.model.dto.move.BasePlayerMoveDto;
import ch.nation.core.model.position.Vector3Int;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class GameLogicController {

    private final GameLogicService gameLogicService;



    private final HttpServletRequest request;

    @Autowired
    public GameLogicController(final GameLogicService gameLogicService, HttpServletRequest request) {
        this.gameLogicService = gameLogicService;

        this.request = request;
    }

    @RequestMapping(method = RequestMethod.POST,consumes ="application/json", path = "/{gameUuid}/{playerUuid}")
    public ResponseEntity addUnitMove(@PathVariable("gameUuid") String gameUuid, @PathVariable("playerUuid") String playerUuid, @RequestBody BasePlayerMoveDto move) throws Exception {
        if(gameUuid==null ||gameUuid.isEmpty())throw new IllegalArgumentException("GameUuid is null or empty!");
        if(playerUuid==null ||playerUuid.isEmpty())throw new IllegalArgumentException("GameUuid is null or empty!");
        if(move==null) throw new IllegalArgumentException("Move is null!");
        return gameLogicService.addMove(request.getHeader("Authorization"),gameUuid,playerUuid,move);
    }

    @RequestMapping(method = RequestMethod.PUT,consumes ="application/json", path = "/{gameUuid}/{playerUuid}")
    public ResponseEntity updateFogOfWar(@PathVariable("gameUuid") String gameUuid, @PathVariable("playerUuid") String playerUuid, @RequestBody List<Vector3Int> uncoveredFogOfWar) throws Exception {
        if(gameUuid==null ||gameUuid.isEmpty())throw new IllegalArgumentException("GameUuid is null or empty!");
        if(playerUuid==null ||playerUuid.isEmpty())throw new IllegalArgumentException("GameUuid is null or empty!");
        return gameLogicService.updateFogOfWarByPlayerAndGame(request.getHeader("Authorization"),gameUuid,playerUuid,uncoveredFogOfWar);
    }

   /** @RequestMapping(method = RequestMethod.GET, path = "/{gameUuid}/{playerUuid}/{casterUuid}")
    public ResponseEntity<List<AbstractPlayerMoveDto>> getMovesOfUnitByGameUuidAndPlayerUuidAndRound(@PathVariable("gameUuid") String gameUuid, @PathVariable("playerUuid") String playerUuid, @PathVariable("casterUuid") String casterUuid,@RequestParam("round") int round, @RequestParam(value = "projection",required = false) QueryProjection projection) throws Exception {

        return gameLogicService.getMovesOfUnitByGameUuidAndPlayerUuidAndRound(gameUuid,playerUuid,casterUuid,round,projection);

    }**/

   @RequestMapping(method = RequestMethod.POST,path = {"/{playerUuid}/{playerTwoUuid}","/{playerUuid}"})
   public ResponseEntity createGame(@PathVariable("playerUuid") String playerUuid, @PathVariable(value = "playerTwoUuid") String playerTwoUuid, @RequestParam(value = "projection", required = false) QueryProjection projection) throws Exception {
       if(playerUuid==null ||playerUuid.isBlank()) throw new IllegalArgumentException("Player One UUID must not be null or empty!");
       if(playerTwoUuid==null ||playerTwoUuid.isBlank()) throw new IllegalArgumentException("Player Two UUID must not be null or empty!");
       return gameLogicService.createNewGame(request.getHeader("Authorization"),playerUuid,playerTwoUuid,projection);
   }


       @RequestMapping(method = RequestMethod.PUT, path = "/{gameUuid}/{playerUuid}/end-game")
   public ResponseEntity<Boolean> endGame(@PathVariable("gameUuid") String gameUuid, @PathVariable("playerUuid") String playerUuid) throws Exception {
       if(gameUuid==null ||gameUuid.isEmpty())throw new IllegalArgumentException("GameUuid is null or empty!");
       if(playerUuid==null ||playerUuid.isEmpty())throw new IllegalArgumentException("playerUuid is null or empty!");
       return gameLogicService.endGame(request.getHeader("Authorization"),gameUuid,playerUuid);
   }

        @RequestMapping(method = RequestMethod.GET, path = "/{gameUuid}/{playerUuid}/is-current-player")
    public ResponseEntity<Boolean> isPlayerCurrentPlayer(@PathVariable("gameUuid")String gameUuid, @PathVariable("playerUuid") String playerUuid){
        if(gameUuid==null ||gameUuid.isEmpty())throw new IllegalArgumentException("GameUuid is null or empty!");
        if(playerUuid==null ||playerUuid.isEmpty())throw new IllegalArgumentException("playerUuid is null or empty!");
        return gameLogicService.isUserCurrentUserInGame(request.getHeader("Authorization"),gameUuid,playerUuid);
   }


    @RequestMapping(method = RequestMethod.PUT,path="/{gameUuid}")
    public ResponseEntity<?> endTurn(@PathVariable("gameUuid") String gameUuid, @RequestBody GameUserRuntimeInfoDto currentPlayerRuntimeInfo) throws Exception {
        return gameLogicService.endTurn(request.getHeader("Authorization"),gameUuid,currentPlayerRuntimeInfo);
    }




}
