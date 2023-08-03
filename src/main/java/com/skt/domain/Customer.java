package com.skt.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Builder
@DynamoDbBean
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Customer {

	@Getter(onMethod_=@DynamoDbPartitionKey)
    private String customerId;

	@Getter
    private String firstName;

	@Getter
    private String lastName;

	@Getter
    private String email;

}