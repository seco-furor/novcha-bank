package util;

import java.util.Scanner;

public class Utils {
    public static String doUpdateInput(Scanner sc, String oldValue) {
//        1 -> yes 0 -> no
        System.out.printf("Aldingi qiymat %s, o'zgarituwdi qaliysama", oldValue);
        if (sc.nextInt() == 1) {
            return sc.next();
        } else {
            return oldValue;
        }
    }
}
