import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class push here.
 * 
 * @daarii 
 * @30 May'20
 */
public class Push extends Shooter
{
    public GreenfootImage image1 = new GreenfootImage("push_00.png");
    private GreenfootImage image2 = new GreenfootImage("push_1.png");
    public Boolean state;
    private Yadro y1 ;
    public Push() {
        this.state=Boolean.FALSE;
        this.getIMG();
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            if(state==Boolean.FALSE){
                y1 = ((MyWorld)getWorld()).yadro;
                
                y1.setAngle((((MyWorld)getWorld()).angleSlider.getValue()));
                y1.setSpeed(((MyWorld)getWorld()).speedSlider.getValue());
                y1.setMass(((MyWorld)getWorld()).massSlider.getValue());
                getWorld().addObject( y1, 219,325);
                this.state = Boolean.TRUE;
                getIMG();
            }
            else{
                this.state=Boolean.FALSE;
                y1.remove();
                getIMG();
            }
            
        }
        //if(
        // Add your action code here.
    }    
     
    public void getIMG(){
        if(this.state) this.setImage(image2);
        else  this.setImage(image1);
        
    }
}
