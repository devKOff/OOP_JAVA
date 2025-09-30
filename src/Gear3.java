class Gen3<G extends Number> {
    G x;
    G y;
    Gen3(G x,G y) {
        this.x = x;
        this.y = y;
    }

    public double Add() {

        return this.x.doubleValue() + this.y.doubleValue();
    }

    public static void main(String[] args) throws Exception {
        Gen3<Integer> g = new Gen3<>(29.3,13.2);
        System.out.println(g.Add());
    }
}