package example;

public class Calculator<T extends Number> {

    void add(T n1, T n2) {
        System.out.println(n2 + " " + n1);
    }
}
