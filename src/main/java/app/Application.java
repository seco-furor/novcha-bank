package app;

import db.dao.AccountDAO;
import db.entity.AccountEntity;
import db.entity.base.BaseDbEntity;
import service.AccountService;
import service.MainService;

import java.util.Scanner;

import static app.AppConstants._INITIAL_MESSAGE;

public class Application  {

    public void start(){
        new MainService().process();
    }
}
