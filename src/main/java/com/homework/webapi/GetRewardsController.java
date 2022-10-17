package com.homework.webapi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetRewardsController {

    @GetMapping("/getrewards")
    public List<AccountRewards> getRewards() {

        LocalDate baseDate = LocalDate.now().minusMonths(3);
        DataAccess dataAccess = new DataAccess();
        List<AccountRewards> accountRewards = new ArrayList<AccountRewards>();
        List<Transaction> transactions = dataAccess.getTransactions();

        Iterator<Transaction> courseIterator = transactions.iterator();
        while (courseIterator.hasNext()) {
            Transaction currentCourse = courseIterator.next();
            if (currentCourse.transDate.isBefore(baseDate)) {
                courseIterator.remove();
            }
        }

        Set<String> accountIds = new HashSet<>();
        for (final Transaction t : transactions) {

            accountIds.add(t.getAccountId());
        }

        for (String accoundId : accountIds) {
            AccountRewards accountReward = new AccountRewards();
            accountReward.setAccountId(accoundId);
            for (Transaction t : transactions) {
                if (t.transDate.isAfter(baseDate)) {
                    if (accoundId == t.getAccountId()) {
                        if (t.amount > 50 && t.amount <= 100) {
                            accountReward.setRewards(accountReward.getRewards() + (int) t.amount - 50);
                        } else if (t.amount > 100) {
                            accountReward.setRewards(accountReward.getRewards() + (((int) t.amount - 100) * 2) + 50);
                        }
                    }
                } else {
                    transactions.remove(t);
                }

            }
            accountRewards.add(accountReward);
        }

        return accountRewards;
    }
}
