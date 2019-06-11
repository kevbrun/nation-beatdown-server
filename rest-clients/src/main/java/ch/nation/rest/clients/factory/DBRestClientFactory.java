package ch.nation.rest.clients.factory;

import ch.nation.rest.clients.DBRestMassServiceBaseInterface;
import ch.nation.rest.clients.DBRestServiceBaseInterface;
import ch.nation.rest.clients.units.DBRestUnitRestClient;
import ch.nation.rest.clients.users.DBMassUserRestClient;
import ch.nation.rest.clients.users.DBUserRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DBRestClientFactory {


    @Autowired
    private List<DBRestServiceBaseInterface> services;


    private static final Map<String, DBRestServiceBaseInterface> myServiceCache = new HashMap<>();

    @PostConstruct
    public void initMyServiceCache() {
        for(DBRestServiceBaseInterface service : services) {
            myServiceCache.put(service.getType(), service);
        }
    }

    public static DBRestServiceBaseInterface getService(String type) {
        DBRestServiceBaseInterface service = myServiceCache.get(type);
        if(service == null) throw new RuntimeException("Unknown service type: " + type);
        return service;
    }

}
