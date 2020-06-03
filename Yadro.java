import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)import 
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Yadro extends Actor
{
    private final double G = 9.8;
    private final Random rand = new Random();
    private Coordin pos = new Coordin();
    private SimpleTimer timer = new SimpleTimer();
    private int angle=0;
    private int value=0;
    private int mass=0;
    private int speed;
    private Label l1;
    private Push push;
    private Pynguin pynguin;
    public void startTimer()
    {
        timer.mark();
    }
    
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
        int time = this.timer.millisElapsed()/100;
        pos.x = -(this.speed * Math.cos(-Math.toRadians(angle))*time);
        pos.y = -(this.speed * Math.sin(-Math.toRadians(angle))*time - (G*Math.pow(time,2))/2);
        //l1.setValue(time);
        return pos;
    }
    
    public void remove()
    {
        getWorld().removeObject(this);
        pynguin.setLocation(540+rand.nextInt(400),455);
        push.state=Boolean.FALSE;
        push.getIMG();
        angle=0;
        //time=0;
    }
}
