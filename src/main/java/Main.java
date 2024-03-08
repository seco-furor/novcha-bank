import app.Application;
import db.util.DatabaseUtil;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        Application app = new Application();

//        initial check creating db tables
        boolean tables = DatabaseUtil.createTables();

        if (tables) {
            app.start();
        } else {
            System.out.println("ne boldi qarag'imau");
        }
    }
}
