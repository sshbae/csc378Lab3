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
private int lives = 5;
private static GreenfootSound backgroundMusic = new GreenfootSound("music.mp3");
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
        if (!backgroundMusic.isPlaying())
            backgroundMusic.playLoop();
    }
    
    public void act()
    {
        showText("Lives: " + ((Integer)lives).toString(), 100, 10);
        if (lives < 1)
            Greenfoot.setWorld(new BadEndScene());
        
        //showText("Score: " + ((Integer)(-1*getTotalXMovement())).toString(), 100, 10);
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
        
        addObject(new Wife(), 3000, 200);

        for (int x = getWidth() * -15 + getWidth(); x < getWidth() * 15; x += getWidth()) {
            addObject(new TP(), x+600+((int)(Math.random() * 10)), 280);
            addObject(new Fly(), x+625+((int)(Math.random() * 10)), 280);
        }
    }
    
    public void upLevel()
    {
        level++;
    }
    public void downLife()
    {
        lives--;
    }
    public static void stopMusic()
    {
        backgroundMusic.stop();
    }
    public int getLevel()
    {
        return level;
    }
}
