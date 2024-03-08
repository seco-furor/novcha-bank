package service;

import db.dao.AccountDAO;
import db.entity.AccountEntity;

import java.util.Scanner;

import static app.AppConstants._ACCOUNT_INITIAL_MESSAGE;

public class AccountService implements BaseService {
    private boolean condition = true;
    private final Scanner scanner;

    private final AccountDAO accountDAO;

    public AccountService(Scanner scanner) {
        this.scanner = scanner;
        accountDAO = new AccountDAO();
    }

    @Override
    public void process() {
        while (condition) {
            System.out.println(_ACCOUNT_INITIAL_MESSAGE);

            switch (scanner.nextInt()) {
                case 1: {
                    AccountEntity accountEntity = new AccountEntity();

                    System.out.println("User_name kirit");
                    accountEntity.setUser_name(scanner.next());

                    System.out.println("Last_name kirit");
                    accountEntity.setLast_name(scanner.next());

                    boolean insert = accountDAO.insert(accountEntity);

                    if (!insert) {
                        System.out.println("Account kirita almading !!!");
                    }
                    break;
                }

                case 2: {
                    condition = false;
                    break;
                }
                default:
                    System.out.println("error in account dao, back");
                    return;
            }
        }
    }
}
