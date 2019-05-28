package ch.nation.dbservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Type;
import java.util.Iterator;

@Configuration
public class SpringDataConfig implements RepositoryRestConfigurer {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(
                entityManager.getMetamodel().getEntities().stream()
                        .map(Type::getJavaType)
                        .toArray(Class[]::new));


     Iterator<EntityType<?>> d = entityManager.getMetamodel().getEntities().iterator();

     while(d.hasNext()){
         EntityType<?> entry = d.next();

         LOGGER.info(entry.getName());
     }


    }
}
