package ch.nation.dbservice.repositories.core;

import ch.nation.dbservice.entities.AbstractNationEntityBase;
import ch.nation.dbservice.repositories.IPageableDao;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RepositoryRestController
@RequestMapping
public abstract class AbstractMassRestResource<T extends AbstractNationEntityBase> {

    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final IPageableDao repo;


    @Autowired
    public AbstractMassRestResource(IPageableDao repo) {
        this.repo = repo;

    }


    @RequestMapping(method = POST, value = "/update-batch", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> batchUpdate(@RequestBody Collection<T> objectToSave) throws NoSuchMethodException {

        LOGGER.info("START | Executing save All | Controller :" + this.getClass().getName());
        LOGGER.debug(String.format("Try to save collection | Size %s", objectToSave));

        if (objectToSave.size() > 0) {


            Iterable<T> savedObects = repo.saveAll(objectToSave);

            Resources<T> resources = new Resources<T>(savedObects);

            //   resources.add(linkTo(this.getClass(),)).withSelfRel());
            LOGGER.info("Saved objects count: " + resources.getContent().size());

            return ResponseEntity.ok(resources);


        } else {
            LOGGER.info("Nothing to do");
        }

        LOGGER.info("FINISH | Executing save All | Controller :" + this.getClass().getName());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


    @RequestMapping(method = DELETE, value = "/delete-batch", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> batchDelete(@RequestBody Collection<T> objectToDelete) throws NoSuchMethodException {


        LOGGER.info("START | Deleting batch | Controller :" + this.getClass().getName());
        LOGGER.debug(String.format("Try to save collection | Size %s", objectToDelete));

        if (objectToDelete.size() > 0) {
            repo.deleteAll(objectToDelete);


            return ResponseEntity.ok(new Resource(Boolean.TRUE));


        } else {
            LOGGER.info("Nothing to do");
        }

        LOGGER.info("START | Deleting batch | Controller :" + this.getClass().getName());

        return ResponseEntity.ok(new Resource(Boolean.TRUE));


    }


}
