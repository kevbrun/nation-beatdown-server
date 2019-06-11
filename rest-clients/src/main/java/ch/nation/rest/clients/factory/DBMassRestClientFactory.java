package ch.nation.rest.clients.factory;

import ch.nation.rest.clients.DBRestMassServiceBaseInterface;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.users.DBMassUserRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DBMassRestClientFactory {

    @Autowired
    private List<DBRestMassServiceBaseInterface> services;


    private static final Map<String, DBRestMassServiceBaseInterface> myServiceCache = new HashMap<>();

    @PostConstruct
    public void initMyServiceCache() {
        for(DBRestMassServiceBaseInterface service : services) {
            myServiceCache.put(service.getType(), service);
        }
    }

    public static DBRestMassServiceBaseInterface getService(String type) {
        DBRestMassServiceBaseInterface service = myServiceCache.get(type);
        if(service == null) throw new RuntimeException("Unknown service type: " + type);
        return service;
    }

}
