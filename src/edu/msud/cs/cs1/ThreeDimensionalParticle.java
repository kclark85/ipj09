package edu.msud.cs.cs1;

public class ThreeDimensionalParticle {
    Vector position;
    Vector velocity;
    double mass;

    public ThreeDimensionalParticle (double[] position, double[] velocity, double mass)
    {
        this.position = new Vector(position);
        this.velocity = new Vector(velocity);
        this.mass = mass;
    }

    //calculates kinetic energy of a Vector's velocity
    double kEnergy ()
    {
        Vector v = this.velocity;
        double vectorSum = 0;
        for(int i = 0; i < 3; i++){
            vectorSum += Math.pow((v.cartesian(i)), 2);
        }
        double k = (this.mass/2)*(vectorSum);
        return k;
    }

    public static void main (String [] args){
        double[] arr1 = {1.0,2.0,3.0};
        double[] arr2 = {1.0,2.0,3.0};

        ThreeDimensionalParticle particle = new ThreeDimensionalParticle (arr1, arr2, 20);
        System.out.println(particle.kEnergy());
    }
}
