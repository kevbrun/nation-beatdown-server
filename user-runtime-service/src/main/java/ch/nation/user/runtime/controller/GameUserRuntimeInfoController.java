package ch.nation.user.runtime.controller;

import ch.nation.core.controller.AbstractResourceGameLogicController;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.AbstractDto;
import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;

import ch.nation.user.runtime.service.GameUserRuntimeInfoService;
import ch.nation.user.runtime.service.GameUserRuntimeInfoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GameUserRuntimeInfoController extends AbstractResourceGameLogicController<GameUserRuntimeInfoDto,GameUserRuntimeInfoDto> {


    public GameUserRuntimeInfoController(GameUserRuntimeInfoServiceImpl service) {
        super(service);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.PATCH,consumes ="application/json")
    public ResponseEntity updatePatch(@RequestBody GameUserRuntimeInfoDto payload, QueryProjection projection) {
        return super.updatePatch(payload,projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity create(@RequestBody GameUserRuntimeInfoDto object) throws Exception {
        return super.create(object);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE,path = "/{uuid}")
    public ResponseEntity delete( @PathVariable("uuid") String uuid) throws Exception {
        return super.delete(uuid);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/{uuid}")
    public ResponseEntity findById(@PathVariable("uuid")String uuid) {
        return super.findById(uuid);
    }


    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/{uuid}/batch")
    public ResponseEntity createAssociation(@PathVariable("uuid")String uuid, @RequestBody List<AbstractDto> children,@RequestParam(value = "projection") QueryProjection projection  ) throws Exception {
        return super.createAssociation(uuid, children, projection);
    }


    @Override
    @RequestMapping(method = RequestMethod.POST,path="/{uuid}/{resourceCollection}")
    public ResponseEntity createAssociation(@PathVariable("uuid")String uuid, @PathVariable("resourceCollection")String resourceCollection, @RequestBody AbstractDto child,@RequestParam(value = "projection") QueryProjection projection ) throws Exception {
        return super.createAssociation(uuid, resourceCollection, child, projection);
    }


    @Override
    @RequestMapping(method = RequestMethod.POST,consumes = "application/json",path = "/{uuid}/{resourceCollection}/batch")
    public ResponseEntity createAssociation(@PathVariable("uuid")String uuid, @PathVariable("resourceCollection")String resourceCollection, @RequestBody List<AbstractDto> children, @RequestParam(value = "projection") QueryProjection projection ) {
        return super.createAssociation(uuid, resourceCollection, children, projection);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/{uuid}/{resourceCollection}")
    public ResponseEntity getChildrenNodesByResourceCollection(@PathVariable("uuid") String uuid, @PathVariable("resourceCollection") String resourceCollection) {
        return super.getChildrenNodesByResourceCollection(uuid, resourceCollection);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST,path="/children")
    public ResponseEntity createChildren(@RequestBody List<AbstractDto> children,@RequestParam(value = "projection") QueryProjection projection) throws Exception {
        return super.createChildren(children, projection);
    }

    @RequestMapping(method = RequestMethod.GET,path="/search/findByGame_IdAndPlayerUuid")
    public ResponseEntity<GameUserRuntimeInfoDto> getUserRuntimeInfoByGameUuidAndByPlayerUuid(@RequestParam(value = "game_uuid")String gameUUid, @RequestParam(value = "player_uuid")String playerUUid, @RequestParam(value = "projection",required = false) QueryProjection projection){

        GameUserRuntimeInfoDto dto = ((GameUserRuntimeInfoServiceImpl)service).getUserRuntimeInfoByGameUuidAndByPlayerUuid(gameUUid,playerUUid,projection).get();
        return new ResponseEntity<>(dto,HttpStatus.OK);

    }

    @Override
    @RequestMapping(method = RequestMethod.GET,path="/search/exists")
    public ResponseEntity<Boolean> entityExists(@RequestParam("uuid") String uuid) {
        return super.entityExists(uuid);
    }
}
