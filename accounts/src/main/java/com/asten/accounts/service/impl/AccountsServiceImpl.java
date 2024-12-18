package com.asten.accounts.service.impl;

import com.asten.accounts.constants.AccountsConstants;
import com.asten.accounts.dto.CustomerDto;
import com.asten.accounts.entity.Accounts;
import com.asten.accounts.entity.Customer;
import com.asten.accounts.exception.CustomerAlreadyExistsException;
import com.asten.accounts.mapper.CustomerMapper;
import com.asten.accounts.repository.AccountsRepository;
import com.asten.accounts.repository.CustomerRepository;
import com.asten.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountsServiceImpl implements IAccountsService {
    public AccountsServiceImpl(CustomerRepository customerRepository, AccountsRepository accountsRepository) {
        this.customerRepository = customerRepository;
        this.accountsRepository = accountsRepository;
    }

    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;
    /**
     * Create a new account in the system.
     *
     * @param customerDto Information about the account to be created.
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer with mobile number " + customerDto.getMobileNumber() + " already exists");
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    /**
     * Creates a new account for the given customer with a random account number,
     * default account type, and branch address.
     *
     * @param customer the customer for whom the account is being created
     * @return the newly created account
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");

        return newAccount;
    }
}
