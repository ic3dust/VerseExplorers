package src.EasterEggs;

//linear congruential generator (LCG)
class Randomnessalg {

    private int a;
    private int c;
    private int m;
    private int seed;

    public Randomnessalg(int a, int c, int m, int seed) {
        this.a = a;
        this.c = c;
        this.m = m;
        this.seed = seed;
    }

    private void generate() {
        int val = 0;
        int rem = 0;
        for (int i = 0; i < m; i++) {
            val = (seed * a + c) / m;
            rem = (seed * a + c) % m;
            seed = rem;
            System.out.print(val);
        }

    }

    public static void main(String[] args) {
        Randomnessalg inst = new Randomnessalg(12, 1222, 42, 2);
        inst.generate();

    }
}
