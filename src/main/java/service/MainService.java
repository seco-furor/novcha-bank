package service;

import java.util.Scanner;

import static app.AppConstants._INITIAL_MESSAGE;

public class MainService implements BaseService {
    private boolean condition = true;
    private final Scanner scanner;

    private final AccountService accountService;

    public MainService() {
        this.scanner = new Scanner(System.in);
        this.accountService = new AccountService(this.scanner);
    }

    @Override
    public void process() {
        while (condition) {
            System.out.println(_INITIAL_MESSAGE);

            switch (scanner.nextInt()) {
                case 1: {
                    accountService.process();
                    break;
                }
                case 2: {
                    condition = false;
                    break;
                }

                default:
                    System.out.println("Something went wrong !!!");
            }
        }
    }
}
