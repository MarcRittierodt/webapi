package com.homework.webapi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetRewardsController {
    
    @GetMapping("/getrewards")
    public List<Transaction> getRewards()
    {
     
        LocalDate baseDate = LocalDate.now().minusMonths(3);
        DataAccess dataAccess = new DataAccess();
        List<Transaction> transactions = dataAccess.getTransactions();
        
        Iterator<Transaction> courseIterator = transactions.iterator();
        while (courseIterator.hasNext()) {
            Transaction currentCourse = courseIterator.next();
            if (currentCourse.transDate.isBefore(baseDate)) {
                courseIterator.remove();
            }
        }

        List<Transaction> distinctAccounts = transactions.stream()
                                                .filter(distinctByKey(t -> t.accountId))
                                                .collect(Collectors.toList());
        for (Transaction accounts: distinctAccounts)
        {
        for (Transaction t: transactions)
        {
            if (t.transDate.isAfter(baseDate))
            {
            if (accounts.accountId == t.accountId)
            {
            if (t.amount > 50 && t.amount <= 100)
            {
                t.rewardsPoints = t.rewardsPoints + (int)t.amount - 50;
            }
            else if (t.amount > 100)
            {
                t.rewardsPoints = t.rewardsPoints + (((int)t.amount - 100) * 2) + 50;
            }
        }
        }
        else 
        {
            transactions.remove(t);
        }
        
    }
        }
    
        return transactions;
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
