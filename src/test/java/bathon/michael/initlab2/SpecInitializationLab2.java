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
    ThingContainer container2;


    @Before
    public void setUp(){

        container = new ThingContainer(5);
        container2 = new ThingContainer(6);


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

    @Test
    public void testPop(){
        assertEquals("Fails if it doesn't return a ColorfulThing object removed from the last position in the" +
                " array", container.colorArray[4], container.pop());
    }

    @Test
    public void testEnumRemove(){

     /*   assertEquals("Fails if expected object doesn't have the same value as the removed Enum" +
                " searched ColorfulThing obj", ColorEnum.GREEN, container.remove(ColorEnum.GREEN).getColor()); */

        ColorfulThing removedThing = container.remove(ColorEnum.RED);

        assertNotNull(removedThing);

        ColorEnum result = removedThing.getColor();

        assertEquals("Fails if expected object doesn't have the same value as the removed Enum" +
                " searched ColorfulThing obj", ColorEnum.RED, result);

        System.out.println(result);

        assertNull("Fails if there is an object in the last index of the array", container.colorArray[container.colorArray.length -1]);
    }

    @Test
    public void testNullRemove(){
        assertEquals("Fails if it doesn't get null", null, container.remove(ColorEnum.ORANGE));
    }

    @Test
    public void testColorfulThingObjRemove(){
        ColorfulThing ctRed = new ColorfulThing(ColorEnum.RED);
        ColorfulThing ctBlue = new ColorfulThing(ColorEnum.BLUE);
        ColorfulThing ctGreen = new ColorfulThing(ColorEnum.GREEN);
        ColorfulThing ctRed2 = new ColorfulThing(ColorEnum.RED);

        container2.add(ctRed);
        container2.add(ctBlue);
        container2.add(ctGreen);
        container2.add(ctRed2);

        ColorfulThing removedObjThing = container2.remove(ctGreen);

        assertNotNull(removedObjThing);

        assertEquals("Fails if expected object doesn't have the same value as the removed Enum" +
                " searched ColorfulThing obj", ColorEnum.GREEN, removedObjThing.getColor());

        System.out.println(container2.colorArray[2].getColor());

        assertNull("Fails if there is an object in the last index of the array", container2.colorArray[container2.colorArray.length -1]);

    }

}
