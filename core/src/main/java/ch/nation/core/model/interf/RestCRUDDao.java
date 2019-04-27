package ch.nation.core.model.interf;



public interface RestCRUDDao<TResult,TResultMultiple,TInput> {



    TResultMultiple getAll();
    TResult findById(String uuid);
    TResult create(TInput object) throws Exception;
    TResult delete(String uuid) throws Exception;
    TResult update(TInput payload);

}
