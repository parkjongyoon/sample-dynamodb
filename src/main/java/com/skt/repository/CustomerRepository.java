package com.skt.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skt.domain.Customer;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class CustomerRepository {

	private final DynamoDbTable<Customer> customerTable;

    public CustomerRepository(@Autowired DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.customerTable = dynamoDbEnhancedClient.table("Customer", TableSchema.fromBean(Customer.class));
    }	
	
    public void saveCustomer() {
    	Customer customer = Customer.builder()
    			.customerId("abc")
    			.firstName("kang")
    			.lastName("suji")
    			.email("suji@naver.com")
    			.build();
    	
    	customerTable.putItem(customer);
    	
    }

    public Customer getCustomerById(String customerId) {
        return customerTable.getItem(Key.builder().partitionValue(customerId).build());
    }

}