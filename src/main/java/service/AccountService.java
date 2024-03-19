package service;

import db.dao.AccountDAO;
import db.entity.AccountEntity;

import java.util.List;
import java.util.Scanner;

import static app.AppConstants._ACCOUNT_INITIAL_MESSAGE;

public class AccountService implements BaseService{
    private boolean condition = true;
    private final Scanner scanner;
    private final AccountDAO accountDAO;

    public AccountService(Scanner scanner){
        this.scanner = scanner;
        accountDAO = new AccountDAO();
    }
    @Override
    public void process() {
        while (condition) {
            System.out.println(_ACCOUNT_INITIAL_MESSAGE);
            switch (scanner.nextInt()){
                case 1: {
                    AccountEntity accountEntity = new AccountEntity();

                    System.out.println("Enter the user_name: ");
                    accountEntity.setUser_name(scanner.next());

                    System.out.println("Enter the last_name: ");
                    accountEntity.setLast_name(scanner.next());

                    boolean insert = accountDAO.insert(accountEntity);

                    if(!insert) {
                        System.out.println("Account kirite almadin'...");
                    }else System.out.println("Account created successfully!");
                    break;
                }

                case 2: {
                    List<AccountEntity> listAll = accountDAO.getListAll();
                    System.out.println(listAll);
                    // System.out.println("Sign in");
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

    private void signIn(){
        AccountEntity accountEntity = new AccountEntity();
// find account -> findByUser_name
        System.out.println("user_name => ");
        String next = scanner.next();
        AccountEntity byUserName =accountDAO.findByUserName(next);

        if (byUserName != null){
            System.out.println("User exist");
        }else System.out.println("User not found");



    }
}
