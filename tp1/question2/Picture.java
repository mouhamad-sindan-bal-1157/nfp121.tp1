package question2;

import question1.Circle;
import question1.Square;
import question1.Triangle;

/**
 * This class represents a simple picture. You can draw the picture using the
 * draw method. But wait, there's more: being an electronic picture, it can be
 * changed. You can set it to black-and-white display and back to colors (only
 * after it's been drawn, of course).
 * 
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 1.1 (24 May 2001)
 */
public class Picture {
    private Square wall;
    private Square window;
    private Triangle roof;
    private Circle sun;
    private Circle sun2;
    /**
     * Constructor for objects of class Picture
     */
    public Picture() {
        // nothing to do... instance variables are automatically set to null
    }

    /**
     * Draw this picture.
     */
    public void draw() {
        wall = new Square();
        wall.moveVertical(80);
        wall.changeSize(100);
        wall.makeVisible();

        window = new Square();
        window.changeColor("black");
        window.moveHorizontal(20);
        window.moveVertical(100);
        window.makeVisible();

        roof = new Triangle();
        roof.changeSize(50, 140);
        roof.moveHorizontal(60);
        roof.moveVertical(70);
        roof.makeVisible();
        
               sun = new Circle();
        sun.changeColor("blue");
        sun.moveHorizontal(180);
        sun.moveVertical(-5);
        sun.changeSize(60);
        sun.makeVisible();
        sun.slowMoveVertical(200);
        
        sun2 = new Circle();
        sun2.changeColor("yellow");
        sun2.moveHorizontal(200);
        sun2.moveVertical(5);
        sun2.changeSize(60);
        sun2.makeVisible();
        
        //tester la methode
        //faireCoucherSoleil(sun2);
    }
    /*   
     * Question 2.3 une methode qui permet au soleil en parametre de se coucher
     */
    public void faireCoucherSoleil(Circle c)
    {
        //le faire coucher de facon vertical directe
        c.slowMoveVertical(500); //cette methode ne fonctionne pas
        
        //PS: on pourrai le faire coiucher 
        //    de facon horizontal en utulisant les methode demander
    }

    public void setBlackAndWhite() {
        if (wall != null) // only if it's painted already...
        {
            wall.changeColor("black");
            window.changeColor("white");
            roof.changeColor("black");
            sun.changeColor("black");
        }
    }

    /**
     * Change this picture to use color display
     */
    public void setColor() {
        if (wall != null) // only if it's painted already...
        {
            wall.changeColor("red");
            window.changeColor("black");
            roof.changeColor("green");
            sun.changeColor("yellow");
        }
    }
    

}
