package ch.nation.rest.logic.controller;

import ch.nation.core.model.dto.move.AbstractPlayerMoveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity addUnitMove(@PathVariable("gameUuid") String gameUuid, @PathVariable("playerUuid") String playerUuid, @RequestBody  AbstractPlayerMoveDto move) throws Exception {
        if(gameUuid==null ||gameUuid.isEmpty())throw new IllegalArgumentException("GameUuid is null or empty!");
        if(playerUuid==null ||playerUuid.isEmpty())throw new IllegalArgumentException("GameUuid is null or empty!");
        if(move==null) throw new IllegalArgumentException("Move is null!");
        return gameLogicService.addMove(gameUuid,playerUuid,move);
    }






}
