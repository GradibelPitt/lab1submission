/**
 * A class that represents a rational number in normal form where the numerator
 * and the denominator share no common factors and only the numerator
 * can be negative.
 * 
 * @author Charles Hoot 
 * @version 4.0
 */
public class Rational
{
    // Step 2: Create the private data fields that will hold the state of a Rational object
    private int numerator;   // Numerator of the rational number
    private int denominator; // Denominator of the rational number

    /**
     * The default constructor for objects of class Rational.  Creates the rational number 1.
     */
    public Rational()
    {       
        this.numerator = 1;
        this.denominator = 1;
    }

    /**
     * The alternate constructor for objects of class Rational. Creates a rational number equivalent to n/d.
     * @param n The numerator of the rational number.
     * @param d The denominator of the rational number.
     */    
    public Rational(int n, int d) throws ZeroDenominatorException
    {
        if (d == 0) {
            throw new ZeroDenominatorException("Denominator cannot be zero.");
        }
        this.numerator = n;
        this.denominator = d;
        normalize();
    }
    
    /**
     * Get the value of the Numerator
     *
     * @return     the value of the numerator
     */
    public int getNumerator()
    {
        return numerator;
    }
    
    /**
     * Get the value of the Denominator
     *
     * @return     the value of the denominator
     */
    public int getDenominator()
    {
        return denominator;
    }

    /**
     * Negate a rational number
     * 
     * @return a new rational number that is negation of this number -r
     */    
    public Rational negate()
    {               
        return new Rational(-this.numerator, this.denominator);
    }

    /**
     * Invert a rational number 
     * 
     * @return a new rational number that is 1/r.
     */    
    public Rational invert() throws ZeroDenominatorException
    {               
        if (this.numerator == 0) {
            throw new ZeroDenominatorException("Cannot take reciprocal of a rational number with numerator 0.");
        }
        return new Rational(this.denominator, this.numerator);
    }

    /**
     * Add two rational numbers
     *
     * @param other the second argument of the add
     * @return a new rational number that is the sum of this and the other rational
     */    
    public Rational add(Rational other)
    {       
        int newNumerator = this.numerator * other.getDenominator() + other.getNumerator() * this.denominator;
        int newDenominator = this.denominator * other.getDenominator();
        return new Rational(newNumerator, newDenominator);
    }
    
     /**
     * Subtract a rational number from this one
     *
     * @param other the second argument of subtract
     * @return a new rational number that is r-t
     */    
    public Rational subtract(Rational other)
    {               
        int newNumerator = this.numerator * other.getDenominator() - other.getNumerator() * this.denominator;
        int newDenominator = this.denominator * other.getDenominator();
        return new Rational(newNumerator, newDenominator);
    }

    /**
     * Multiply two rational numbers
     *
     * @param other the second argument of multiply
     * @return a new rational number that is the product of this object and the other rational.
     */    
    public Rational multiply(Rational other)
    {       
        int newNumerator = this.numerator * other.getNumerator();
        int newDenominator = this.denominator * other.getDenominator();
        return new Rational(newNumerator, newDenominator);
    }
        
 
     /**
     * Divide this rational number by another one
     *
     * @param other the second argument of divide
     * @return a new rational number that is r/t
     */    
    public Rational divide(Rational other) throws ZeroDenominatorException
    {               
        if (other.getNumerator() == 0) {
            throw new ZeroDenominatorException("Cannot divide by a rational number with numerator 0.");
        }
        int newNumerator = this.numerator * other.getDenominator();
        int newDenominator = this.denominator * other.getNumerator();
        return new Rational(newNumerator, newDenominator);
    }
     
 /**
     * Put the rational number in normal form where the numerator
     * and the denominator share no common factors. Guarantee that only the numerator
     * can be negative.
     */
    private void normalize()
    {
        if (denominator < 0) { 
            numerator = -numerator;
            denominator = -denominator;
        }
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator)); 
        numerator /= gcd;
        denominator /= gcd;
    }
    
    /**
     * Recursively compute the greatest common divisor of two non-negative integers
     *
     * @param a the first argument of gcd
     * @param b the second argument of gcd
     * @return the gcd of the two arguments
     */
    private int gcd(int a, int b)
    {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
