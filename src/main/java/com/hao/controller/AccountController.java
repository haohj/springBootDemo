package com.hao.controller;

import com.hao.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 账户controller层
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping("/transfer")
    public String transferAccount() {
        try {
            accountService.transferAccounts(1, 2, 200);
            return "OK";
        } catch (Exception e) {
            return "NO";
        }
    }
}
