package com.project.service.account;

import com.project.model.Account;
import com.project.service.api.Accounts;
import java.time.LocalDateTime;

public class CryptoWallet extends Account {
    private final String walletAddress;

    public CryptoWallet(String institutionName, String walletAddress) {
        super(institutionName, Accounts.CryptoWallet.getCurrency(), Accounts.CryptoWallet.getName());
        this.walletAddress = walletAddress;
        this.balance = Accounts.CryptoWallet.getBalance();
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    protected void syncWithProvider() {
        this.balance = Accounts.CryptoWallet.getBalance();
    }

    @Override
    public LocalDateTime getLastSyncTime() {
        if (getBalance() == Accounts.CryptoWallet.getBalance()) {
            return time;
        }
        return null;
    }
}