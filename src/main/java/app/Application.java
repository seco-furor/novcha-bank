package app;

import db.entity.AccountEntity;
import service.MainService;

public class Application  {

    public void start(){
        new MainService().process();
    }

    /**
     * Singleton design pattern
    * */
    public static class Storage {
        private static final Application.Storage storage = new Storage();

        private Storage() {}

        public static Storage getStorage() {
            return storage;
        }

        private AccountEntity user;
        private String language;

        public boolean hasUser() {
            return user != null;
        }

        public AccountEntity getUser() {
            return user;
        }

        public void setUser(AccountEntity user) {
            this.user = user;
        }
    }
}
