package ch.nation.core.controller.interfaces;

import org.springframework.http.ResponseEntity;

public interface ChildrenNodeDao {


    ResponseEntity getChildrenNodesByResourceCollection(String uuid, String resourceCollection);


}
