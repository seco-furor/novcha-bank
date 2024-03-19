package service;

import app.Application;
import db.dao.AccountDAO;
import db.dao.CardDAO;
import db.entity.AccountEntity;
import db.entity.CardEntity;

import java.util.List;
import java.util.Scanner;

import static app.AppConstants._ACCOUNT_INITIAL_MESSAGE;
import static app.AppConstants._ACCOUNT_INITIAL_MESSAGE_HAS_USER;

public class AccountService implements BaseService {
    private boolean condition = true;
    private final Scanner scanner;
    private final AccountDAO accountDAO;
    private final CardDAO cardDAO;
    private final Application.Storage storage = Application.Storage.getStorage();

    public AccountService(Scanner scanner) {
        this.scanner = scanner;
        this.cardDAO = new CardDAO();
        accountDAO = new AccountDAO();
    }

    @Override
    public void process() {
        condition = true;

        while (condition) {
            if (storage.hasUser()) {
                System.out.println(_ACCOUNT_INITIAL_MESSAGE_HAS_USER);
                switch (scanner.nextInt()) {
                    case 1: {
//                        show cards
                        List<CardEntity> byAccountId = cardDAO.findByAccountId(storage.getUser().getId());

                        byAccountId.forEach(it -> System.out.println(it));
                        break;
                    }

                    case 0: {
                        condition = false;
                        break;
                    }

                    default:
                        System.out.println("error in account dao, back");
                }
            } else {
                System.out.println(_ACCOUNT_INITIAL_MESSAGE);
                switch (scanner.nextInt()) {
                    case 1: {
                        createAccount();
                        break;
                    }
                    case 2: {
                        signIn();
                        break;
                    }

                    case 0: {
                        condition = false;
                        break;
                    }

                    default:
                        System.out.println("error in account dao, back");
                }
            }
        }
    }

    private void createAccount() {
        AccountEntity accountEntity = new AccountEntity();

        System.out.println("Enter the user_name: ");
        accountEntity.setUser_name(scanner.next());

        System.out.println("Enter the last_name: ");
        accountEntity.setLast_name(scanner.next());

        boolean insert = accountDAO.insert(accountEntity);

        AccountEntity byUserName = accountDAO.findByUserName(accountEntity.getUser_name());

        if (byUserName != null) {
            System.out.println("Account created successfully!");
            storage.setUser(byUserName);
        } else {
            System.out.println("Account kirite almadin'...");
        }
    }

    private void signIn() {
        System.out.print("In order to sign in please type the username: \n");
        String typedUsername = scanner.next();

        // username barma joqma listdan qaraw
        AccountEntity byUserName = accountDAO.findByUserName(typedUsername);

        // user bar bolsa password soraw
        if (byUserName != null) {
            storage.setUser(byUserName);
//            urinislar soni 3 dan otmawi karak
            int attempts = 0;
//            while (attempts < 3) {
//                System.out.print("Enter the password: \n");
//                String typedPassword = scanner.next();
//
//                if (byUserName.getPassword().equals(typedPassword)) {
//                    currentUser = accounts[foundUsersIndex];
//                }
//
//                if (currentUser != null) {
//                    System.out.println("Success");
//                    break;
//                } else {
//                    System.out.println("Password wrong attempted !!!");
//                    attempts++;
//                }
//            }

//            if (attempts == 3 && currentUser == null) {
//                System.out.println("3 martadan otip ketti, qayttan kir;");
//            }
        } else {
            System.out.println("User with username: " + typedUsername + " not found");
        }
    }
}
