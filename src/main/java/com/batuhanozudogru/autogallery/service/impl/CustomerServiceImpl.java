package com.batuhanozudogru.autogallery.service.impl;

import com.batuhanozudogru.autogallery.dto.DtoAccount;
import com.batuhanozudogru.autogallery.dto.DtoAddress;
import com.batuhanozudogru.autogallery.dto.DtoCustomer;
import com.batuhanozudogru.autogallery.dto.DtoCustomerIU;
import com.batuhanozudogru.autogallery.enums.MessageType;
import com.batuhanozudogru.autogallery.exception.BaseException;
import com.batuhanozudogru.autogallery.exception.ErrorMessage;
import com.batuhanozudogru.autogallery.model.Account;
import com.batuhanozudogru.autogallery.model.Address;
import com.batuhanozudogru.autogallery.model.Customer;
import com.batuhanozudogru.autogallery.repository.AccountRepository;
import com.batuhanozudogru.autogallery.repository.AddressRepository;
import com.batuhanozudogru.autogallery.repository.CustomerRepository;
import com.batuhanozudogru.autogallery.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AccountRepository accountRepository;

    private Customer createCustomer(DtoCustomerIU dtoCustomerIU) {
        Optional<Address> addressOptional = addressRepository.findById(dtoCustomerIU.getAddressId());
        if(addressOptional.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoCustomerIU.getAddressId().toString()));
        }
        Optional<Account> accountOptional = accountRepository.findById(dtoCustomerIU.getAccountId());
        if(accountOptional.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoCustomerIU.getAccountId().toString()));
        }


        Customer customer = new Customer();
        customer.setCreatedTime(new Date());
        BeanUtils.copyProperties(dtoCustomerIU, customer);
        customer.setAddress(addressOptional.get());
        customer.setAccount(accountOptional.get());

        return customer;
    }
    @Override
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();
        DtoAccount dtoAccount = new DtoAccount();

        Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));

        BeanUtils.copyProperties(savedCustomer, dtoCustomer);
        BeanUtils.copyProperties(savedCustomer.getAddress(), dtoAddress);
        BeanUtils.copyProperties(savedCustomer.getAccount(), dtoAccount);

        dtoCustomer.setAccount(dtoAccount);
        dtoCustomer.setAddress(dtoAddress);
        return dtoCustomer;
    }
}
