import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class TP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TP extends Mover
{
    GreenfootImage leftIm = new GreenfootImage("tpL0.png");
    GreenfootImage rightIm = new GreenfootImage("tpR0.png");
    public void act() 
    {
        super.act(); 
        List players = getNeighbours(100+((MyWorld) getWorld()).getLevel()*10, false, Player.class);
        
        if (players.isEmpty()) //normal movement
        {
            if (super.directionL){
                move(-1.0);
                setImage(leftIm);
            }
            else{
                setImage(rightIm);
                move(1.0);
            }
         }
        else //go toward the Player
        {
             Player player = (Player) players.get(0);
             if (player.getX() < getX())
             {
                 if (!super.directionL){
                     turn();
                     setImage(leftIm);
                 }
                 move(-1.0);
             }
             else
             {
                 if(super.directionL)
                    {
                        turn();
                        setImage(rightIm);
                    }
                 move(1.0);
             }
        }
    }    
}
