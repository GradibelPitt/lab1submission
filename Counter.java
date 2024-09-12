
/**
 * A counter that will roll over to the min
 * value when attempting to increase it beyond the maximum value and to the max 
 * value when attempting to decrease it below the min value
 * 
 * @author Charles Hoot 
 * @version 4.0
 */
public class Counter
{
    // PUT PRIVATE DATA FIELDS HERE
    private int min;
    private int max;
    private int value;
    private boolean rolledOver;	

    /**
     * The default constructor for objects of class Counter.  Minimum is 0 and the maximum
     * is the largest possible integer.
     */
    public Counter()
    {
	// ADD CODE FOR THE CONSTRUCTOR
      	min = 0;
	max = Integer.MAX_VALUE;
	value = 0;
	rolledOver = false;	  
    }
    
    
    /**
     * The alternate constructor for objects of class Counter.  The minimum and maximum values are given as parameters.
     * The counter starts at the minimum value.
     * @param min The minimum value that the counter can have
     * @param max The maximum value that the counter can have
     * */
    public Counter(int min, int max) throws CounterInitializationException {
        // ADD CODE FOR THE ALTERNATE CONSTRUCTOR
	if (min >= max) {
		throw new CounterInitializationException("Minimum value cannot be greater than or equal to maximum value.");
	}
	this.min = min;
        this.max = max;
        this.value = min;
	this.rolledOver = false;
    }
    
    /**
     * Determine if two counters are in the same state
     *
     * @param  otherObject   the object to test against for equality
     * @return     true if the objects are in the same state
     */
    @Override
    public boolean equals(Object otherObject){
        boolean result = false;
        if (otherObject instanceof Counter)
        {
            // YOUR CODE GOES HERE
	    Counter otherCounter = (Counter) otherObject;
	    result =  (this.min == otherCounter.min) &&
		      (this.max == otherCounter.max) &&
		      (this.value == otherCounter.value) &&
		      (this.rolledOver == otherCounter.rolledOver);
            
        }
        return false;
    }
    
    

    /**
     * Increases the counter by one
     */
    public void increase()
    {
	// ADD CODE TO INCREASE THE VALUE OF THE COUNTER AND HANDLE ROLLOVER
        if (value < max) {
        	value++; 
		rolledOver = false;
    	} else{
        	value = min; 
		rolledOver = true;
       }
    }
 
 
     /**
     * Decreases the counter by one
     */
    public void decrease()
    {
        // ADD CODE TO DECREASE THE VALUE OF THE COUNTER AND HANDLE ROLLOVER
	if (value > min) {
        value--; 
	rolledOver = false;
    	} 
        else {
        value = max;
	rolledOver = true;  
        }
    }
    
    /**
     * Get the value of the counter
     *
     * @return     the current value of the counter
     */
    public int value()
    {
        // CHANGE THE RETURN TO GIVE THE CURRENT VALUE OF THE COUNTER
        return value;
		
    }
    
    
    /**
     * Accessor that allows the client to determine if the counter
     *             rolled over on the last count
     *
     * @return     true if the counter rolled over
     */
    public boolean rolledOver() {
        // CHANGE THE RETURN TO THE ROLLOVER STATUS OF THE COUNTER
        return rolledOver;
    }
    
    /**
     * Override the toString method to provide a more informative
     * description of the counter
     *
     * @return     a descriptive string about the object
     */
    public String toString()
    {
        // CHANGE THE RETURN TO A DESCRIPTION OF THE COUNTER
        // MUST FOLLOW THE FOLLOWING FORMAT:
        //Counter: value=1 min=1 max=9 rolled over=false

        return "Counter: value=" + value + " min=" + min + " max=" + max + " rolled over=" + rolledOver;		
    }
 
}
