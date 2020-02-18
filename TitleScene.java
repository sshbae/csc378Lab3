import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScene here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScene extends CutScene
{
    public int timer = 0;
    public int text_bubble_num = 0;
    public String[] myStrings = new String[] {"Howdy! My name is Schitt.","I've been separated from my wife!", "I need your help getting back to her.","Guide me through obstacles using the arrow keys.","Press space to shoot approaching enemies.","Let's get to it!"};
    public String[] imageNames = new String[] {"00", "13", "04", "00", "00", "23"};
    public Poop poop = new Poop();
    
    /**
     * Constructor for objects of class TitleScene.
     * 
     */
    public TitleScene()
    {
        prepare();
    }

    public void act()
    {
        showText(myStrings[text_bubble_num], 300, 300);
        showText("(press space to advance)", 300, 360);
        
        GreenfootImage tile = new GreenfootImage("tile0" + imageNames[text_bubble_num] + ".png");
        poop.setImage(tile);

        if (timer == 120 || (Greenfoot.isKeyDown("space") && timer > 10))
        {
            timer = 0;
            text_bubble_num += 1;
        }
        else {
            timer++;
        }

        if (text_bubble_num == myStrings.length) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
    
    public void prepare()
    {
        addObject(poop, getWidth()/2,getHeight()/2);
    }
}
