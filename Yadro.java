import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)import 
import java.util.Random;

public class Yadro extends Actor
{
    private final double G = 9.8;
    private final Random rand = new Random();
    private Coordin pos = new Coordin();
    private GreenfootImage img = new GreenfootImage("explosion1.png");
    private GreenfootImage img1 = new GreenfootImage("yadro_0.png");
    private int angle=0;
    private int value=0;
    private int mass=0;
    private int speed;
    private Label l1;
    private Push push;
    private Pynguin pynguin;
    int time=0;
    public void setSpeed(int speed)
    {
        this.speed=-speed;
    }
    
    public void setAngle(int angle)
    {
        this.angle=angle;
    }
    
    public void setMass(int mass)
    {
        this.mass=mass;
    }
    
    public void act() 
    {
        l1=((MyWorld)getWorld()).label;
        push=((MyWorld)getWorld()).push;
        pynguin = ((MyWorld)getWorld()).pynguin;
        time++;
        fly();
    }
    
    public void fly(){
        this.turn(40);
        if(!this.isTouching(Pynguin.class)&&this.getX()<990){
            this.setLocation((int)passing().x+225, (int)passing().y+423);
            if(this.isTouching(Grass.class)){
                this.remove();
            }
        }
        else if(this.isTouching(Pynguin.class)){
            value++;
            l1.setValue(value);
            //pynguin.explosion();
            this.remove();
        }else
        {
            this.remove();
        }
    }
    
    private Coordin passing()
    {
        Coordin pos;
        pos = new Coordin();
        pos.x = -(this.speed * Math.cos(-Math.toRadians(angle))*time/10.0);
        pos.y = -(this.speed * Math.sin(-Math.toRadians(angle))*time/10.0 - (G*Math.pow(time/10.0,2))/2);
        return pos;
    }
    
    public void remove()
    {
        setImage(img);
        Greenfoot.delay(20);
        setImage(img1);
        getWorld().removeObject(this);
        pynguin.create();
        push.state=Boolean.FALSE;
        push.getIMG();
        angle=0;
        time=0;
    }
}
