package service;

import db.dao.AccountDAO;
import db.dao.CardDAO;
import db.entity.AccountEntity;

import java.util.List;
import java.util.Scanner;

import static app.AppConstants._ACCOUNT_INITIAL_MESSAGE;
import static app.AppConstants._CARD_INITIAL_MESSAGE;

public class CardService implements BaseService{
    private boolean condition = true;
    private final Scanner scanner;
    private final CardDAO cardDAO;
    private final AccountDAO accountDAO;

    public CardService(Scanner scanner){
        this.scanner = scanner;
        accountDAO = new AccountDAO();
        cardDAO = new CardDAO();
    }
    @Override
    public void process() {
        condition = true;

        while (condition) {
            System.out.println(_CARD_INITIAL_MESSAGE);

            switch (scanner.nextInt()){
                case 1: {
                    // find account -> findByUser_name
                    System.out.println("user_name => ");
                    String next = scanner.next();
                    AccountEntity byUserName =accountDAO.findByUserName(next);

                    if (byUserName != null){
                        System.out.println("User exist");
                    }else System.out.println("User not found");

                    break;
                }

                case 2: {
                    System.out.println("jhgf");
                    break;
                }

                case 0: {
                    condition = false;
                    break;
                }

                default:
                    System.out.println("error in card dao, back");
            }
        }
    }

}
