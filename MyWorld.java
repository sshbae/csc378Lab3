import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class MyWorld extends ScrollingWorld
{
private int level = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setScrollingBackground(new GreenfootImage("background.jpg"));
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        FartRay fartRay = new FartRay();
        addObject(player,getWidth()/2,300);
        addObject(fartRay,player.getX()+150, 200);
        for (int x = getWidth() * -5 + getWidth(); x < getWidth() * 5; x += getWidth()) {
                addObject(new TP(), x+600,310);
        }
    }
        public void upLevel()
    {
        level++;
    }
    
    public int getLevel()
    {
        return level;
    }
}
