package ch.nation.dbservice.converter;

import ch.nation.core.model.position.Vector3;
import ch.nation.core.model.position.Vector3Number;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.persistence.AttributeConverter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VectorStringConverter implements AttributeConverter<Vector3Number, String> {

    private final  Logger LOGGER =LoggerFactory.getLogger(this.getClass());

    private static final String SEPERATOR="|";

    @Override
    public String convertToDatabaseColumn(Vector3Number attribute) {
        StringBuilder builder = new StringBuilder();

        Number x = attribute.getX()!=null ? attribute.getX() : 0;
        Number y = attribute.getY()!=null ? attribute.getY() : 0;
        Number z = attribute.getZ()!=null ? attribute.getZ() : 0;


        builder.append(x).append(SEPERATOR)
                .append(y).append(SEPERATOR)
                .append(z);

        LOGGER.debug("Converted Vector into "+builder.toString());
        return builder.toString();
    }



    @Override
    public Vector3Number convertToEntityAttribute(String dbData) {
        String[] vectorAsString = dbData.split(SEPERATOR);

        List<String> vWithoutSeperator = Arrays.stream(vectorAsString).filter(item -> !item.equals(SEPERATOR)).collect(Collectors.toList());

        if(vWithoutSeperator.size()==0) return new Vector3Number();


            Number x = extractValueFromDB(vWithoutSeperator.get(0));
            Number y = extractValueFromDB(vWithoutSeperator.get(1));
            Number z = extractValueFromDB(vWithoutSeperator.get(2));


        Vector3Number newVec =  new Vector3Number(x,y,z);
        LOGGER.debug("Converted Vector from db into "+newVec.toString());
        return newVec;
    }


    private Number extractValueFromDB(String value){

        Number res;


        try {
            res=NumberFormat.getInstance().parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage(),e);
            res = 0;
        }

        return res;

    }
}
