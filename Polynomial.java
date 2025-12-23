public class Polynomial {
    // The polynomial's coefficients. Has a non-zero leading term.
    private double[] coefficients;

    /**
     * Default constructor, creates the 0 polynomial.
     */
    public Polynomial() {
        this.coefficients = new double[1];
        this.coefficients[0] = 0;
    }

    /**
     * A standard constructor. Ensures that the highest term of the polynomial is non-zero.
     * @param coefficients- a list of the polynomial's coefficients
     * @throws RuntimeException in the case no coefficients are entered.
     */
    public Polynomial(double[] coefficients) {
        if (coefficients == null || coefficients.length == 0) {
            throw new RuntimeException("not a valid polynomial");
        }
        int leading = coefficients.length - 1;
        while (leading >= 0 && coefficients[leading] == 0) {
            leading--;  // removing leading zeros
        }
        if (leading < 0) {
            this.coefficients = new double[1];
            this.coefficients[0] = 0;
        } else {
            this.coefficients = new double[leading + 1];
            for (int i = 0; i < leading + 1; i++) {
                this.coefficients[i] = coefficients[i];
            }
        }
    }

    /**
    * a copy constructor. Deep copies the other polynomial's coefficients.
    * @param other - the polynomial to be copied
    */
   public Polynomial(Polynomial original) {
       this.coefficients = new double[original.degree() + 1];
       for (int i = 0; i < this.coefficients.length; i++) {
           this.coefficients[i] = original.getCoefficients()[i];
       }
   }

   /**
    * Returns a copy of the polynomial's coefficients.
    * @return a copy of the polynomial's coefficients.
    */
   public double[] getCoefficients() {
       double[] ans = new double[this.coefficients.length];
       for (int i = 0; i < ans.length; i++) {
           ans[i] = this.coefficients[i];
       }
       return ans;
   }


     /**
     * Returns the degree of the polynomial. The 0 polynomial is considered to have degree 0.
     * @return the degree of the polynomial.
     */
    public int degree() {
        return this.coefficients.length - 1;
    }

    /**
     * evaluates the polynomial at a given point.
     * @param x - the point to be evaluated.
     * @return this evaluated at x.
     */
    public double evaluate(double x) {
        double ans = 0;
        for (int i = 0; i <= this.degree(); i = i + 1) { 
            // sum all parts of the polynomial according to the variable's value
            ans = ans + (this.coefficients[i] * (Math.pow(x, i)));
        }
        return ans;
    }
    
         /**
     * Adds two polynomials.
     * @param other - the polynomial to be added to this
     * @return the addition of this polynomial and the other polynomial.
     */
    public Polynomial addition(Polynomial other) {
        double[] sums = new double[Math.max(this.degree() + 1, other.degree() + 1)];
        for (int i = 0; i <= this.degree(); i++) {
            sums[i] += this.coefficients[i];
        }
        for (int i = 0; i <= other.degree(); i++) {
            sums[i] += other.getCoefficients()[i];
        }
        return new Polynomial(sums);
    }
         /**
     * multiplies two polynomials.
     * @param other - the polynomial to be multiplied with this
     * @return the product of this polynomial and the other polynomial.
     */
    public Polynomial multiplication(Polynomial other) {
        double[] products = new double[this.degree() + other.degree() + 1];
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j <= this.degree() && (i - j) <= other.degree()) {
                    products[i] += this.coefficients[j] * other.getCoefficients()[i - j];
                }
            }
        }
        return new Polynomial(products);
    }

     
     /**
     * Subtracts two polynomials.
     * @param other - the polynomial to be subtracted from this
     * @return the subtraction of the other polynomial from this polynomial.
     */
    public Polynomial subtraction(Polynomial other) {
        double[] d = { -1 };
        Polynomial temp = new Polynomial(d);
        return this.addition(other.multiplication(temp));
    }

    /**
     * Derives a polynomial
     * @return the derivative of this polynomial.
     */
    public Polynomial derivative() {
        if (this.degree() == 0) {
            return new Polynomial();
        }
        double[] diff = new double[this.degree()];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = this.coefficients[i + 1] * (i + 1);
        }
        return new Polynomial(diff);
    }   
    /**
     * Compares two polynomial.
     * @param other
     * @return true if and only if other is a polynomial whose coefficients are equal to this polynomial's.
     */
    public boolean equals(Polynomial other) {
        if (this.degree() != other.degree()) {
            return false;
        }
        for (int i = 0; i <= this.degree(); i++) {
            if (this.coefficients[i] != other.getCoefficients()[i]) {
                return false;
            }
        }
        return true;
    }
/**
     * Returns the string representation of this polynomial
     * @return string representation of this polynomial.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = this.coefficients.length - 1; i >= 0; i--) {
            s.append(this.coefficients[i] + "*x^" + i);
            if (i > 0) {
                s.append(" + ");
            }
        }
        return s.toString();
    }

    
    public static Polynomial polynomialMax(Polynomial[] arr){
        int maxIndex = -1;
        int maxdeg = -1;
        for (int j = 0; j < arr.length; j++){
             if (arr[j].degree()> maxdeg){
                maxdeg = arr[j].degree();
                maxIndex = j;
            }
        }
        return arr[maxIndex];
    }
    
    public static void main(String[] args) {
        double[] d = { 1, 1, 1 };
        Polynomial p = new Polynomial(d);
        Polynomial q = new Polynomial(p);
        System.out.println(p.equals(q)); // true
        System.out.println(p == q); // false
        System.out.println(p.evaluate((1))); // 3.0
    }






}
