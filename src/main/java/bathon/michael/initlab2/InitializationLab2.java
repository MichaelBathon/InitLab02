package bathon.michael.initlab2;

/**
 * Created by michaelbathon on 1/28/16.
 */
public class InitializationLab2 {

    public static void main(String[] args) {
        ThingContainer container1 = new ThingContainer(3);//(int)(Math.random()*4) + 3);
        ThingContainer container2 = new ThingContainer(4);//(int)(Math.random()*5) + 4);
        ThingContainer container3 = new ThingContainer(5);//(int)(Math.random()*6) + 5);
        ThingContainer container4 = new ThingContainer(4);

        container1.add(new ColorfulThing(ColorEnum.BLUE));
        container1.add(new ColorfulThing(ColorEnum.RED));
        container1.add(new ColorfulThing(ColorEnum.GREEN));
        container1.add(new ColorfulThing(ColorEnum.BLUE));

        container2.add(new ColorfulThing(ColorEnum.GREEN));
        container2.add(new ColorfulThing(ColorEnum.RED));


        container4.add(new ColorfulThing(ColorEnum.BLUE));
        container4.add(new ColorfulThing(ColorEnum.RED));
        container4.add(new ColorfulThing(ColorEnum.GREEN));

        container1.printThings();
        container2.printThings();
        container3.printThings();


    }

}

enum ColorEnum {RED, BLUE, GREEN}

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
    int i = 0;

    public ThingContainer(int arraySize) {
        colorArray = new ColorfulThing[arraySize];
    }

    public int getArray() {
        return colorArray.length;
    }

    public void add(ColorfulThing colorObj) {
        if (i >= colorArray.length) {
            System.out.println("ThingContainer is full");
            return;}
        colorArray[i] = colorObj;
        i++;
    }

    public void printThings(){
        for(int x = 0; x < colorArray.length; x++){
            if(colorArray[x] == null){
                return;
            }else
                System.out.println(colorArray[x].getColor());
        }
    }

}
