package ch.nation.dbservice.serialization;

import ch.nation.core.model.position.Vector3;
import ch.nation.core.model.position.Vector3Float;
import ch.nation.core.model.position.Vector3Int;
import ch.nation.core.model.position.Vector3Number;
import ch.nation.dbservice.converter.VectorStringConverter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;


public class VectorConverterTest {


    public VectorStringConverter converter;

    @Before
    public void SetUp(){
        converter = new VectorStringConverter();
    }


    @Test
    public void serializeIntegerVector(){

        Vector3Number vector3Int = new Vector3Number(4,5,5);


       String result= converter.convertToDatabaseColumn(vector3Int);


        Assert.assertEquals("4|5|5",result);

    }

    @Test
    public void deserializeIntegerVector(){

        String vectorAsString = "4|5|5";


        Vector3Number result= converter.convertToEntityAttribute(vectorAsString);


        Assert.assertTrue(new Vector3Number(4,5,5).equals(result));

    }

    @Test
    public void deserializeReplaceNullWithZero(){
        String vectorAsString = "4||5";


        Vector3Number result= converter.convertToEntityAttribute(vectorAsString);


        Assert.assertTrue(new Vector3Number(4,0,5).equals(result));
    }

    @Test
    public void serializeReplaceEmptyValueWithZero(){
        Vector3Number v3 = new Vector3Number(4,null,5);

        String v3AsString = converter.convertToDatabaseColumn(v3);


        Assert.assertTrue(new Vector3Number(4,0,5).equals(v3));

    }




    @Test
    public void deserializeFloatVector(){

        String vectorAsString = "4.85245|54.85245|54.85245";


        Vector3 result= converter.convertToEntityAttribute(vectorAsString);


        Assert.assertTrue(new Vector3Number(4.85245f,54.85245f,54.85245f).equals(result));

    }
    @Test
    public void serializeFloatVector(){

        Vector3Number vector3 = new Vector3Number(4.2f,5.2f,5.3f);


        String result= converter.convertToDatabaseColumn(vector3);


        Assert.assertEquals("4.2|5.2|5.3",result);

    }

}
