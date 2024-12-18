package com.asten.accounts.mapper;

import com.asten.accounts.dto.CustomerDto;
import com.asten.accounts.entity.Customer;

public class CustomerMapper {
    /**
     * Maps a {@link Customer} object to a {@link CustomerDto} object.
     *
     * @param customer the {@link Customer} object to map from
     * @param customerDto the {@link CustomerDto} object to map to
     * @return the mapped {@link CustomerDto} object
     */
    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    /**
     * Maps a {@link CustomerDto} object to a {@link Customer} object.
     *
     * @param customerDto the {@link CustomerDto} object to map from
     * @param customer the {@link Customer} object to map to
     * @return the mapped {@link Customer} object
     */
    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}
