public class PseudoRandom {
    private long seed;

    public PseudoRandom (int seed)
    {
        this.seed = seed*System.currentTimeMillis();
    }

    long randomLong()
    {
        long x = seed;
        long a = (13144739*239);
        long b = (5771299*471);
        long value = a * x + b;
        return value;
    }

    double randomDouble()
    {
        double value = this.randomLong();
        return value;
    }

    int randomInt()
    {
        int value = (int)this.randomLong();
        return value;
    }

    byte randomByte()
    {
        byte value = (byte)this.randomLong();
        return value;
    }

    public static void main(String[] args)
    {
        PseudoRandom rando = new PseudoRandom(30);
        System.out.println(rando.randomLong());
        System.out.println(rando.randomByte());
        System.out.println(rando.randomInt());
        System.out.println(rando.randomDouble());
    }
}
