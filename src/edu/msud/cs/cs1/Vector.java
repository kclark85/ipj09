package edu.msud.cs.cs1;

public class Vector {
    private final double[] coords;

    public Vector(double[] a) {  // Make a defensive copy to ensure immutability.
        coords = new double[a.length];
        for (int i = 0; i < a.length; i++)
            coords[i] = a[i];
    }

    public Vector plus(Vector that) {  // Sum of this vector and that.
        double[] result = new double[coords.length];
        for (int i = 0; i < coords.length; i++)
            result[i] = this.coords[i] + that.coords[i];
        return new Vector(result);
    }

    public Vector scale(double alpha) {  // Scale this vector by alpha.
        double[] result = new double[coords.length];
        for (int i = 0; i < coords.length; i++)
            result[i] = alpha * coords[i];
        return new Vector(result);
    }

    public double dot(Vector that) {  // Dot product of this vector and that.
        double sum = 0.0;
        for (int i = 0; i < coords.length; i++)
            sum += this.coords[i] * that.coords[i];
        return sum;
    }

    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    public Vector direction() {
        return this.scale(1 / this.magnitude());
    }

    public double cartesian(int i) {
        return coords[i];
    }

    //performs subtraction using previously constructed methods (a brand new minus method would be been more efficient)
    public Vector minus(Vector that) {
        return this.plus(that.scale(-1.0));
    }

    //overrides default .equals() method for Objects
    public boolean equals(Vector that) {
        boolean equal = false;
        int trueCounter = 0;
        if (this.coords.length != that.coords.length) {
            return equal;
        } else {
            for (int i = 0; i < this.coords.length; i++) {
                if (this.coords[i] == that.coords[i]) {
                    trueCounter++;
                }
                    if(trueCounter == this.coords.length){
                        equal = true;
                    }

                else {equal = false;}
            }
        }
        return equal;
    }

    //overrides default .hashCode() method for objects
    public int hashCode(Vector that){
        int thisHC = 0;
        if(this.equals(that)) thisHC = Math.abs(this.hashCode() + that.hashCode());
        return thisHC;
    }

    public String toString()
    {
        String v ="" + this.coords[0];
        for(int i = 1; i < this.coords.length; i++)
        {
            v += "," + this.coords[i];
        }
        return "(" + v + ")";
    }

    public static void main (String[] args)
    {
        double[] arr1 = {1.0,2.0,3.0};
        double[] arr2 = {1.0,2.0,3.0};
        double[] arr3 = {2.0,2.0,2.0};
        double[] arr4 = {1.0,2.0};

        Vector alpha = new Vector(arr1);
        Vector bravo = new Vector(arr2);
        Vector charlie = new Vector(arr3);
        Vector delta = new Vector(arr4);

        //tests methods of Vector
        System.out.println(alpha.equals(bravo));
        System.out.println(bravo.equals(charlie));
        System.out.println();
        System.out.println(charlie.equals(delta));
        System.out.println();
        System.out.println(bravo.hashCode(alpha));
        System.out.println(alpha.hashCode(bravo));
        System.out.println();
        System.out.println(alpha.toString());
        System.out.println(alpha.minus(charlie));
        System.out.println(alpha.plus(bravo));
        System.out.println();
        System.out.println(delta.scale(6.1));
        System.out.println(alpha.direction());
        System.out.println(alpha.cartesian(2));
        System.out.println(alpha.magnitude());
    }
}

