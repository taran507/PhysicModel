import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Pynguin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pynguin extends Actor
{
    /**
     * Act - do whatever the Pynguin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Random rand=new Random();
    private SimpleTimer timer = new SimpleTimer();
    private GreenfootImage pynguin = new GreenfootImage("tux.png");
    private GreenfootImage img = new GreenfootImage("explosion.png");
    private Boolean state=Boolean.TRUE;
    public void act() 
    {
        
    }  
    
    public void explosion()
    {
        setImage(img);
    }
    
    public void create()
    {
        Greenfoot.delay(20);
        setImage(pynguin);
        setLocation(540+rand.nextInt(400),455);
    }
}
