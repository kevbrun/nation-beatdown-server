package ch.nation.dbservice.dummyImporter.data;

import java.util.List;

public interface IDummyGenerator<T> {

    List<T> createdEntities();

    void persistData();

}
