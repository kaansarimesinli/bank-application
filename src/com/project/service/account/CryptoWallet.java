package com.project.service.account;

import com.project.model.Account;
import com.project.service.api.Accounts;

import java.time.LocalDateTime;

public class CryptoWallet extends Account {
    private final String walletAddress;
    private double cryptoBalance;

    public CryptoWallet(String institutionName, String walletAddress) {
        super(institutionName, Accounts.CryptoWallet.getCurrency(), Accounts.CryptoWallet.getName());
        this.walletAddress = walletAddress;
    }
    public String getWalletAddress() {
        return walletAddress;
    }
    @Override
    public double getBalance() {
        return cryptoBalance;
    }
    @Override
    protected void syncWithProvider() {
        this.cryptoBalance = Accounts.CryptoWallet.getBalance();
    }

    @Override
    public LocalDateTime getLastSyncTime() {
        if (getBalance() == Accounts.CryptoWallet.getBalance()) {
            return time;
        }
        return null;
    }
}
