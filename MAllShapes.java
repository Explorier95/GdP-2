package model;

/**
 * a fabric for Shape-Objects.
 * @author Agathe Merceron, updated Fabian Tappendorf
 */

import java.util.Arrays;

public class MAllShapes {
    
    /**
     * construct a number of Rectangle and Circle objects, 
     * stores them in an array and returns it
     * @return an array filled with Rectangle or Circle objects
     */
    
    public static MShape[] getDefaultShapes(){
        MShape[] allshapes= new MShape[7];
        allshapes[0] = new MRectangle( 125,250, 30, 25);
        allshapes[1] = new MRectangle( 155, 200, 10, 40);
        allshapes[2] = new MCircle( 100, 10, 20);
        allshapes[3] = new MRectangle( 75, 105, 80, 40);
        allshapes[4] = new MCircle( 200, 20, 50);
        allshapes[5] = new MSquare( 2, 150, 50);
        allshapes[6] = new MEllipse( 60, 80, 50,60,60,80);
        return allshapes;
    }
    
    public static void main(String[] args) {
        MShape[] mix =  MAllShapes.getDefaultShapes();
        System.out.println(Arrays.deepToString(mix));
    }

}