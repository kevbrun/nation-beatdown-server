package ch.nation.user.service;


import ch.nation.core.clients.db.factory.DBMassRestClientFactory;
import ch.nation.core.clients.db.factory.DBRestClientFactory;
import ch.nation.core.clients.services.games.GameServiceClient;
import ch.nation.core.clients.services.users.runtime.UserGameRuntimeServiceClient;
import ch.nation.core.model.Enums.QueryProjection;
import ch.nation.core.model.dto.game.GameUserRuntimeInfoDto;
import ch.nation.core.model.dto.user.UserDto;
import ch.nation.core.model.dto.user.UserStatisticsDto;
import ch.nation.core.services.AbstractMassNamedEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserResourceServiceImpl extends AbstractMassNamedEntityService<UserDto, UserDto> implements UserResourceService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final BCryptPasswordEncoder encoder;
    private final UserGameRuntimeServiceClient gameServiceClient;



    @Autowired
    public UserResourceServiceImpl(DBRestClientFactory factory, DBMassRestClientFactory massRestClientFactory, BCryptPasswordEncoder encoder, UserGameRuntimeServiceClient gameServiceClient) {
        super(UserDto.class, factory, massRestClientFactory);
        this.encoder = encoder;
        this.gameServiceClient = gameServiceClient;    }



    public ResponseEntity<UserStatisticsDto> getUserStatistics(final String playerUuid){

        LOGGER.info("START | Get user statistics");
        final UserStatisticsDto dto = new UserStatisticsDto();



       Resource<UserDto> response =  getDefaultClient().findById(playerUuid, QueryProjection.min);


      ResponseEntity<Long> runningGamesCounter =  gameServiceClient.getCountOfRunningGamesByPlayerUuid(playerUuid);


       if(response.getContent()!=null && runningGamesCounter.getStatusCode() == HttpStatus.OK){

           UserDto user = response.getContent();
           dto.setCountOfLostGames(user.getCountOfLostGames());
           dto.setCountOfWonGames(user.getCountOfWonGames());
           dto.setCountOfRunningGames(runningGamesCounter.getBody());

       }else{
          LOGGER.error(String.format("Player with uuid % does not exist",playerUuid));

       }


        LOGGER.debug(String.format("Got informtion %s",dto));
        LOGGER.info("STOP | Get user statistics");


        return ResponseEntity.ok(dto);
    }
}
