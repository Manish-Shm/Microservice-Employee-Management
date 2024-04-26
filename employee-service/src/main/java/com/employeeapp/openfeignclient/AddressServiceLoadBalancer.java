package com.employeeapp.openfeignclient;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

//we are doing load balancer using random by default round robin will be there 
//Now the load Balancing done randomly 
//@LoadBalancerClient(value = "ADDRESS-SERVICE", configuration = MyCustomLoadBalancerConfiguration.class)
@LoadBalancerClient(value = "ADDRESS-SERVICE") //This is the dafault round robbin way 
public class AddressServiceLoadBalancer {
	
	@LoadBalanced
	@Bean
	public Feign.Builder feiBuilder(){
		return Feign.builder();
	}

}
