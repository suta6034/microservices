package com.asten.accounts.service;

import com.asten.accounts.dto.CustomerDto;

public interface IAccountsService {
    /**
     * Create a new account in the system.
     *
     * @param customerDto Information about the account to be created.
     */
    void createAccount(CustomerDto customerDto);
}
