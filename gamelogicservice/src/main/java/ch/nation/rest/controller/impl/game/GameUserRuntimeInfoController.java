package ch.nation.rest.controller.impl.game;

import ch.nation.core.model.dto.game.GameDto;
import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;
import ch.nation.rest.controller.impl.AbstractNamedResourceGameLogicController;
import ch.nation.rest.controller.impl.AbstractResourceGameLogicController;
import ch.nation.rest.services.impl.AbstractNamedEntityService;
import ch.nation.rest.services.impl.games.GameUserRuntimeInfoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user-runtimes")
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
    public ResponseEntity update(@RequestBody GameUserRuntimeInfoDto payload) {
        return super.update(payload);
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
    @RequestMapping(method = RequestMethod.GET,path="/{uuid}/{resourceCollection}")
    public ResponseEntity getChildrenNodesByResourceCollection(@PathVariable("uuid") String uuid, @PathVariable("resourceCollection") String resourceCollection) {
        return super.getChildrenNodesByResourceCollection(uuid, resourceCollection);
    }



}
