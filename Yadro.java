import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)import 
import java.util.Random;

public class Yadro extends Actor
{
    private final double G = 9.8;
    private final Random rand = new Random();
    private int speed;
    private int time;
    private int angle=0;
    private int value=0;
    private int mass=0;
    private Label l1;
    private Push push;
    private Pynguin pynguin;
    private Coordin pos = new Coordin();
    
    public void setSpeed(int speed)
    {
        this.speed=-speed;
    }
    
    public void setAngle(int angle)
    {
        this.angle=angle;
        //this.turn(this.angle);
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
        fly();
        time++;
    }
    
    public void fly(){
        if(!this.isTouching(Pynguin.class)&&this.getX()<990){
            this.setLocation((int)passing().x+219, (int)passing().y+325);
            if(this.isTouching(Grass.class)){
                this.remove();
            }
        }
        else if(this.isTouching(Pynguin.class)){
            value++;
            l1.setValue(value);
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
        pos.x = -(this.speed * Math.cos(-Math.toRadians(angle))*this.time);
        pos.y = -(this.speed * Math.sin(-Math.toRadians(angle))*this.time  - (G*Math.pow(this.time,2))/2);
        return pos;
    }
    
    public void remove()
    {
        getWorld().removeObject(this);
        pynguin.setLocation(600+rand.nextInt(400),455);
        push.state=Boolean.FALSE;
        push.getIMG();
        angle=0;
        time=0;
    }
}
