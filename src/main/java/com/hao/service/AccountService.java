package com.hao.service;

/**
 * 账户Service接口
 *
 * @author Administrator
 */
public interface AccountService {
    /**
     * 从A用户转账b用户钱
     *
     * @param fromUser
     * @param toUser
     * @param account
     */
    public void transferAccounts(int fromUser, int toUser, float account);
}
