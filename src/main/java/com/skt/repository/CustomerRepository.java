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
	
    //저장하기
    public void saveCustomer(Customer customer) {
    	customerTable.putItem(customer);
    }

    //조회하기
    public Customer getCustomerById(String customerId) {
        return customerTable.getItem(Key.builder().partitionValue(customerId).build());
    }
    
    //수정하기
    public void updateCustomer(Customer customer) {
    	customerTable.updateItem(customer);
    }
    
    //삭제하기
    public void deleteCustomer(String customerId) {
    	customerTable.deleteItem(Key.builder().partitionValue(customerId).build());
    }

}