package ch.nation.core.model.interf;



public interface RestCRUDDao<TResult,TResultMultiple,TInput> {



    TResultMultiple getAll();
    TResult findById(String uuid);
    TResult create(TInput object);
    TResult delete(String uuid,TInput payload);
    TResult update(String uuid,TInput payload);

}
