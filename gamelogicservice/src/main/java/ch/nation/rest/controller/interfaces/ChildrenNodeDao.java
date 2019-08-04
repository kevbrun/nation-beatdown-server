package ch.nation.rest.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface ChildrenNodeDao {


    ResponseEntity getChildrenNodesByResourceCollection(String uuid,String resourceCollection);


}
