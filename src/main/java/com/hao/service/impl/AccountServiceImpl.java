package com.hao.service.impl;

import com.hao.dao.AccountDao;
import com.hao.entity.Account;
import com.hao.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * 帐号Service实现类
 *
 * @author Administrator
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    @Transactional
    public void transferAccounts(int fromUser, int toUser, float account) {
        //转账账户扣除转账金额
        Account fromAccount = accountDao.getOne(fromUser);
        fromAccount.setBalance(fromAccount.getBalance() - account);
        accountDao.save(fromAccount);

        //转入账户增加转账金额
        Account toAccount = accountDao.getOne(toUser);
        toAccount.setBalance(toAccount.getBalance() + account);

        int zero = 1 / 0;
        accountDao.save(toAccount);
    }
}
