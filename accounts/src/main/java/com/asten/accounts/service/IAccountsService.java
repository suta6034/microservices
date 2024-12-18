package com.asten.accounts.service;

import com.asten.accounts.dto.CustomerDto;

public interface IAccountsService {
    /**
     * Create a new account in the system.
     *
     * @param customerDto Information about the account to be created.
     */
    void createAccount(CustomerDto customerDto);

    /**
     * Fetches the account details for a given mobile number.
     *
     * @param mobileNumber The mobile number of the account holder.
     * @return A {@link CustomerDto} object containing the account details.
     */
    CustomerDto fetchAccount(String mobileNumber);
}
