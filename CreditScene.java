import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CreditScene here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreditScene extends CutScene
{
    private int timer = 0;
    
    /**
     * Constructor for objects of class CreditScene.
     * 
     */
    public CreditScene()
    {
        Poop p1 = new Poop();
        Poop p2 = new Poop();
        p1.setImage("tile003.png");
        p2.setImage("tile011.png");   
        addObject(p1, 250, 200);
        addObject(p2, 350, 196);

        addObject(new Text("Thank you for reuniting us!"), 300, 400);
        addObject(new Text("Game created by Sarah Bae and Ryan Powell"), 300, 450);
        addObject(new Text("Fart noises created by Sarah Bae"), 300, 500);
    }
    
    public void act()
    {
        timer++;
        
        if (timer > 300) {
            showText("(press space to restart)", getWidth()/2, getHeight()/2);
            if (Greenfoot.isKeyDown("space")) {
                Greenfoot.setWorld(new TitleScene());
            }
        }
    }
}
