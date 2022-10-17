package com.homework.webapi;

public class AccountRewards {
    private String accountId;
    private int rewards;

    public String getAccountId()
    {
        return accountId;
    }

    public void setAccountId(String newAccountId)
    {
        this.accountId = newAccountId;
    }

    public int getRewards()
    {
        return rewards;
    }

    public void setRewards(int newRewards)
    {
        this.rewards = newRewards;
    }
}
