package ch.nation.core.model.interf;

import java.util.List;


public interface GenericCRUDDao<TResultSingle,TResultMultiple,TInput> {

    TResultMultiple getAll();
    TResultSingle findById(String uuid);
    TResultSingle create(TInput object);
    TResultSingle delete(TInput object);
    TResultSingle update(TInput object);




}
