package com.batuhanozudogru.autogallery.service.impl;

import com.batuhanozudogru.autogallery.dto.DtoAccount;
import com.batuhanozudogru.autogallery.dto.DtoAccountIU;
import com.batuhanozudogru.autogallery.model.Account;
import com.batuhanozudogru.autogallery.repository.AccountRepository;
import com.batuhanozudogru.autogallery.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    private Account createAccount(DtoAccountIU dtoAccountIU){
        Account account = new Account();
        account.setCreatedTime(new Date());
        BeanUtils.copyProperties(dtoAccountIU, account);
        return account;
    }
    @Override
    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
        Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));

        DtoAccount dtoAccount = new DtoAccount();
        BeanUtils.copyProperties(savedAccount, dtoAccount);
        return dtoAccount;
    }
}
