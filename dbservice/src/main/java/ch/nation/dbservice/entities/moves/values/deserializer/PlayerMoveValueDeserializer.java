package ch.nation.dbservice.entities.moves.values.deserializer;

import ch.nation.dbservice.entities.moves.values.AbstractBasePlayerMoveValue;
import ch.nation.dbservice.entities.moves.values.MoveSkillPlayerMoveValue;
import ch.nation.dbservice.entities.moves.values.StatPlayerMoveValue;
import ch.nation.dbservice.entities.units.EmeddableVector3;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jackson.JsonComponent;


import java.io.IOException;
@JsonComponent
public class PlayerMoveValueDeserializer extends JsonDeserializer<AbstractBasePlayerMoveValue> {
    private final Logger LOGGER =LoggerFactory.getLogger(this.getClass());

    private final String TYPE_FIELD="type";
    private final String MOVE_SKILL_PLAYER_MOVE_VALUE_TYPE="MoveSkillPlayerMoveValue";
    private final String STAT_SKILL_PLAYER_MOVE_VALUE_TYPE="StatPlayerMoveValue";


    @Override
    public AbstractBasePlayerMoveValue deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        LOGGER.info("Start deserialize with Converter"+this.getClass().getName());
        JsonNode node =p.getCodec().readTree(p);
        String type = node.get(TYPE_FIELD).asText();
        ObjectMapper mapper = (ObjectMapper) p.getCodec();

        String json  = mapper.writeValueAsString(node);

        switch (type){
            case MOVE_SKILL_PLAYER_MOVE_VALUE_TYPE:
                MoveSkillPlayerMoveValue value = new MoveSkillPlayerMoveValue();
                EmeddableVector3 sourcePosition = new EmeddableVector3();



                JsonNode source = node.get("source");
                float sourceX = source.get("x").floatValue();
                float sourceY = source.get("y").floatValue();
                float sourceZ = source.get("z").floatValue();
                sourcePosition.setX(sourceX);
                sourcePosition.setY(sourceY);
                sourcePosition.setZ(sourceZ);
                value.setSourcePosition(sourcePosition);

                EmeddableVector3 targetPosition = new EmeddableVector3();

                JsonNode target = node.get("target");
                float targetX = target.get("x").floatValue();
                float targetY = target.get("y").floatValue();
                float targetZ = target.get("z").floatValue();
                targetPosition.setX(targetX);
                targetPosition.setY(targetY);
                targetPosition.setZ(targetZ);
                value.setTargetPosition(targetPosition);


                return value;

            case STAT_SKILL_PLAYER_MOVE_VALUE_TYPE:

                        StatPlayerMoveValue value2 = new StatPlayerMoveValue();

                        float valueNode = node.get("value").floatValue();
                value2.setValue(valueNode);

            return value2;

                default:
                    LOGGER.info("Could not find correct type on given type parameter");

                    break;
        }


        return null;
    }
}
