import app.Application;
import db.util.DatabaseUtil;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        Application app = new Application();

        boolean tables = DatabaseUtil.createTables();

        //      initial check creating db tables
        if(tables) {
            app.start();
        }else {
            System.out.println("Ne boldi");
        }

    }
}
