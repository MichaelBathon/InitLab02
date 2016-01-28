package bathon.michael.initlab2;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by michaelbathon on 1/28/16.
 */
public class SpecInitializationLab2 {

    ThingContainer container;


    @Before
    public void setUp(){

        container = new ThingContainer(5);

        container.add(new ColorfulThing(ColorEnum.BLUE));
        container.add(new ColorfulThing(ColorEnum.RED));
        container.add(new ColorfulThing(ColorEnum.GREEN));
        container.add(new ColorfulThing(ColorEnum.RED));
        container.add(new ColorfulThing(ColorEnum.GREEN));



    }

    @Test
    public void testContainerArraySizeConstructor(){
       int x = 5;

        assertEquals("checking the array is constructed and of the same size", container.getArray(), x );
    }


   @Test
    public void testArrayAddMethod(){

        assertNotNull(container.colorArray[3]);

    }

    @Test
    public void testPrinter(){
        container.printThings();
    }

}
