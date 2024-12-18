package com.asten.accounts.mapper;

import com.asten.accounts.dto.AccountsDto;
import com.asten.accounts.entity.Accounts;

public class AccountsMapper {
    /**
     * Maps an {@link Accounts} object to an {@link AccountsDto} object.
     *
     * @param accounts the {@link Accounts} object to map from
     * @param accountsDto the {@link AccountsDto} object to map to
     * @return the mapped {@link AccountsDto} object
     */
    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    /**
     * Maps an {@link AccountsDto} object to an {@link Accounts} object.
     *
     * @param accountsDto the {@link AccountsDto} object to map from
     * @param accounts the {@link Accounts} object to map to
     * @return the mapped {@link Accounts} object
     */
    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}
