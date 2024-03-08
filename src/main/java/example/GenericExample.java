package example;

public class GenericExample {
    public static void main(String[] args) {
        Calculator<Long> c1 = new Calculator<>();
        Calculator<Integer> c2 = new Calculator<>();
        Calculator<Double> c3 = new Calculator<>();

        c1.add(1L, 2L);
        c2.add(1, 2);
        c3.add(1.0, 2.0);
    }
}
