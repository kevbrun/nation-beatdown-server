package ch.nation.core.clients.db.factory;


import ch.nation.core.clients.db.DBRestServiceBaseInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DBRestClientFactory {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private List<DBRestServiceBaseInterface> services;


    private static final Map<String, DBRestServiceBaseInterface> myServiceCache = new HashMap<>();

    @PostConstruct
    public void initMyServiceCache() {
        LOGGER.info("Load DB Service Cache");
        for (DBRestServiceBaseInterface service : services) {
            myServiceCache.put(service.getType(), service);
            LOGGER.debug("Load Service: " + service.getType());
        }
    }

    public static DBRestServiceBaseInterface getService(String type) {
        DBRestServiceBaseInterface service = myServiceCache.get(type);
        if (service == null) throw new RuntimeException("Unknown service type: " + type);
        return service;
    }

}
