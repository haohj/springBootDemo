package com.hao.dao;

import com.hao.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Integer> {
}
