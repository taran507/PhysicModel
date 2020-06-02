import greenfoot.*;  
/**
 * 
 * @daarii 
 * @30 May'20
 */
public class Slider extends Actor
{
    private static final int MIN_X = -57;
    private static final int MAX_X = 57;
    private static final double RANGE_X = MAX_X - MIN_X;
    
    private SliderHand hand;
    private Text value;
    private Text label;
    
    private int val;
    private int min;
    private int max;
    private int range;
    
    public Slider() {
        this(" ", 0, 100);
    }
    
    public Slider(String labelText, int min, int max)
    {
        this.min = min;
        this.max = max;
        range = max - min;
        
        label = new Text(labelText);
    }
    
    public void addedToWorld(World world) {
        hand = new SliderHand(this);
        getWorld().addObject (hand, getX(), getY()-4);

        value = new Text(" ");
        getWorld().addObject (value, getX(), getY()-23);

        getWorld().addObject (label, getX(), getY()+20);

        setValueFromX(hand.getX());
    }
    
    public void act() 
    {
        // Add your action code here.
    }   
    
    public int getValue()
    {
        return val;
    }
    
    public void setValue(int val)
    {
        if (val < min || val > max) {
            System.err.println("Value for slider out of range (" + val + ") - ignored");
            return;
        }
        
        int x = MIN_X + (int) ( (val - min) * (RANGE_X / range) );
        hand.setLocation (getX() + x, hand.getY());

        this.val = val;
        value.setText (""+val);
    }
    
    public void setEnabled(boolean enable) 
    {
        hand.setEnabled(enable);
    }
    

    public boolean isEnabled() 
    {
        return hand.isEnabled();
    }
    
    public void setValueFromX(int x) 
    {
        x -= getX();   // convert from absolute to relative offset
        
        val = min + (int) ( (x - MIN_X) * ( range / RANGE_X) );
        value.setText (""+val);
    }
    
    public int getMinX()
    {
        return getX() + MIN_X;
    }
    
    public int getMaxX()
    {
        return getX() + MAX_X;
    }
    
    public void setLocation(int x, int y)
    {
        super.setLocation(x, y);
        if(hand != null) {
            hand.setLocation(x, y-4);
            value.setLocation(x, y-30);
            label.setLocation(x, y+30);
        }
    }
}
