package app;

import service.MainService;

public class Application {
    public void start() {
        new MainService().process();
    }
}
