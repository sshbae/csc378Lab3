import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Fly  extends AnimatedActor
{
    private int angleFlyDuration=0;
    private static int ANGLE_FLY_MAX=50;
    public boolean dead = false;
    public boolean died = false;
    
    
    public Fly()
    {
        super("fly",".png",9);
    }
    /**
     * Act - do whatever the Fly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x,y;
        if (dead){
        }
        else if (died){
            getImage().mirrorVertically();
            getImage().setTransparency(100);
            dead = true;
        }
        else{
        super.act();
        
        List players = getNeighbours(20+((MyWorld) getWorld()).getLevel()*10, false, Player.class);
        
        if (players.isEmpty()) //normal movement
        {
            if (super.directionL)
                move(-1.0);
            else
                move(1.0);
         }
         else
         {
             Player player = (Player) players.get(0);
             if (player.getX() < getX())
             {
                 if (!super.directionL)
                    {
                        turn();
                    }
                    
                 move(-1.0);
             }
             else
             {
                 if(super.directionL)
                    {
                        turn();
                    }
                    
                 move(1.0);
              }
              
              if(player.getY() > getY())
                setLocation(getX(),getY()+2);
              else
                setLocation(getX(),getY()-2);
         }
         
        
         //actual player collision  
         Player s = (Player) getOneIntersectingObject(Player.class);
         if (s != null)
         {
            setRotation(15);
            angleFlyDuration = 5;
        }
        
        //edge detection
        if (atWorldEdge()) {
           turn(); move();
           if (getY() < 2)
                setLocation(getX(),5);
           if (getY() > getWorld().getHeight()-2)
                setLocation(getX(),getWorld().getHeight()-5);
        }
        
        //angle fly code
        if (getRotation() != 0)
        {
            angleFlyDuration--;
            if(angleFlyDuration <= 0)
                setRotation(0);
        }
        else
            if (Greenfoot.getRandomNumber(1000) > 996)
                {
                    angleFlyDuration=ANGLE_FLY_MAX;
                    if(Greenfoot.getRandomNumber(2) == 0)
                        turn(30+Greenfoot.getRandomNumber(30));
                    else
                        turn(-30-Greenfoot.getRandomNumber(30));
                }
    }  }  
}

