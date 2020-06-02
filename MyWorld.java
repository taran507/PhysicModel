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
    public Label label = new Label(0,70);
    
    public MyWorld()
    {    
        super(1000, 500, 1); 
        addObject (new Bg(),500, 250);
        addObject (new Grass(), 500, 450);
        addObject (label, 500, 450);
        createControls();
        CreateObjects();
    }
    
    public void createControls() 
    {
        speedSlider = new Slider ("Speed", 1, 100);
        addObject (speedSlider, 100, 55);
        
        angleSlider = new Slider ("Angle", 0, 90);
        addObject (angleSlider, 250, 55);
    }
    
    private void CreateObjects()
    {
        addObject (pynguin, 950, 370);
        addObject (push, 150, 330);
        
        //push.state=Boolean.TRUE;
    }
}
