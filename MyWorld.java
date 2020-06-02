import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @daarii 
 * @30 May'20
 */
public class MyWorld extends World
{
    public Pynguin pynguin = new Pynguin();
    public Push push = new Push();
    public Yadro yadro= new Yadro();
    public Slider speedSlider;
    public Slider angleSlider;
    public Slider massSlider;
    public Label label = new Label(0,70);
    
    public MyWorld()
    {    
        super(1000, 500, 1); 
        //addObject (new GAme(),0, 0);
        addObject (new Grass(), 500, 450);
        addObject (label, 500, 450);
        createControls();
        CreateObjects();
    }
    
    public void createControls() 
    {
        
        speedSlider = new Slider ("Speed", 1, 100);
        addObject (speedSlider, 260, 65);
        
        angleSlider = new Slider ("Angle", 0, 90);
        addObject (angleSlider, 470, 65);
        
        massSlider = new Slider ("Mass", 1, 10);
        addObject (massSlider, 680, 65);
    }
    
    private void CreateObjects()
    {
        addObject (pynguin, 950, 370);
        //push.turn(-angleSlider.getValue());
        addObject (push, 150, 330);
        //push.state=Boolean.TRUE;
    }
}
