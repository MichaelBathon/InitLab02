package bathon.michael.initlab2;

import java.util.Arrays;

/**
 * Created by michaelbathon on 1/28/16.
 */
public class InitializationLab2 {

    public static void main(String[] args) {
        ThingContainer container1 = new ThingContainer(3);//(int)(Math.random()*4) + 3);
        ThingContainer container2 = new ThingContainer(4);//(int)(Math.random()*5) + 4);
        ThingContainer container3 = new ThingContainer(5);//(int)(Math.random()*6) + 5);
        ThingContainer container4 = new ThingContainer(3);

        ColorfulThing[] hue = new ColorfulThing[4];
        ThingContainer container5 = new ThingContainer(hue);


        container1.add(new ColorfulThing(ColorEnum.BLUE));
        container1.add(new ColorfulThing(ColorEnum.RED));
        container1.add(new ColorfulThing(ColorEnum.GREEN));
        container1.add(new ColorfulThing(ColorEnum.BLUE));

        container2.add(new ColorfulThing(ColorEnum.GREEN));
        container2.add(new ColorfulThing(ColorEnum.RED));

        ColorfulThing color1 = new ColorfulThing(ColorEnum.RED);
        ColorfulThing color2 = new ColorfulThing(ColorEnum.GREEN);
        ColorfulThing color3 = new ColorfulThing(ColorEnum.BLUE);

        ThingContainer container6 = new ThingContainer(container2.colorArray);


        container4.add(color1);
        container4.add(color2);
        container4.add(color3);

        container1.printThings();
        container2.printThings();
        container3.printThings();

        //System.out.println(container1.pop().getColor());
        //System.out.println(container2.pop().getColor());
        //System.out.println(container4.pop().getColor());
        //System.out.println(container4.pop().getColor());

        container1.remove(ColorEnum.RED);
        System.out.println(container4.remove(color2).getColor());
        System.out.println(Arrays.toString(container4.colorArray));
        System.out.println(container4.colorArray[1].getColor());
        System.out.println(container5.pigmentArray.length);
        System.out.println(container6.pigmentArray[1].getColor());



    }

}

enum ColorEnum {RED, BLUE, GREEN, ORANGE}

class ColorfulThing {

    private ColorEnum colorEnum;

    ColorfulThing(ColorEnum colorEnum){
        this.colorEnum = colorEnum;
    }


    public ColorEnum getColor(){
        return this.colorEnum;
    }
}

class ThingContainer {
    ColorfulThing[] colorArray;
    int ctCount = 0;
    ColorfulThing[] pigmentArray;



    public ThingContainer(int arraySize) {
        colorArray = new ColorfulThing[arraySize];
    }

    public ThingContainer(ColorfulThing[] x){
        pigmentArray = x;
    }

    public int getArray() {
        return colorArray.length;
    }

    public void add(ColorfulThing colorObj) {
        if (ctCount >= colorArray.length) {
            System.out.println("ThingContainer is full");
            return;}
        colorArray[ctCount] = colorObj;
        ctCount++;
    }

    public void printThings(){
        for(int x = 0; x < colorArray.length; x++){
            if(colorArray[x] == null){
                return;
            }else
                System.out.println(colorArray[x].getColor());
        }
    }

    public ColorfulThing pop(){
        if(colorArray[0] == null){
            return null;
        }
        ColorfulThing poppedObj = colorArray[ctCount -1];
        colorArray[ctCount -1] = null;
        ctCount--;
        return poppedObj;
    }

    public ColorfulThing remove(ColorEnum colorEnum ){
        int z;
        ColorfulThing enumSearchVal = null;

        for(z = 0; z < ctCount; z++){
            if (colorEnum == colorArray[z].getColor()){
                System.out.println("Found the color.");
                enumSearchVal = colorArray[z];
                colorArray[z] = null;
                break;
            }
        }
        while(z < ctCount-1){
            colorArray[z] = colorArray[z+1];
            z++;
        }
        colorArray[ctCount -1] = null;
        ctCount--;
        return enumSearchVal;
    }

    public ColorfulThing remove(ColorfulThing obj){
        int b;
        ColorfulThing removedColorObj = null;

        for(b = 0; b < ctCount; b++) {
            if (obj.getColor() == colorArray[b].getColor()) {
                removedColorObj = colorArray[b];
                colorArray[b] = null;
                break;
            }
        }
        while(b < ctCount-1){
            colorArray[b] = colorArray[b+1];
            b++;
        }
        colorArray[ctCount -1] = null;
        ctCount--;
    return removedColorObj;
    }


}
