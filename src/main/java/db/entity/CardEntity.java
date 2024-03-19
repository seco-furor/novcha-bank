package db.entity;

import db.entity.base.BaseDbEntity;

public class CardEntity extends BaseDbEntity {

    private String cardNumber;
    private Double balance;
    private Integer accounts_id;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getAccounts_id() {
        return accounts_id;
    }

    public void setAccounts_id(Integer Account_id) {
        this.accounts_id = Account_id;
    }

    @Override
    public String toString() {
        return "CardEntity{" +
                "cardNumber='" + cardNumber + '\'' +
                ", balance=" + balance +
                '}';
    }


}
