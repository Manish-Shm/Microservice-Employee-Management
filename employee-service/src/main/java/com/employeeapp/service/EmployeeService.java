package com.employeeapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.employeeapp.entity.Employee;
import com.employeeapp.openfeignclient.AddressClient;
import com.employeeapp.repo.EmployeeRepo;
import com.employeeapp.response.AddressResponse;
import com.employeeapp.response.EmployeeResponse;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private WebClient webClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AddressClient addressClinet;
//	@Autowired
//	private DiscoveryClient discoveryClient;
	
//	@Autowired
//	private LoadBalancerClient loadBalancerClient;
	
	
	public EmployeeResponse getEmployeeById(int id) {
		
		
		//convert employee to employeeResponse 
		Employee employee = employeeRepo.findById(id).get();
		EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
		
		ResponseEntity<AddressResponse> addressResponseEntity = addressClinet.getAddressByEmployeeId(id);
		AddressResponse addressResponse = addressResponseEntity.getBody();

		employeeResponse.setAddressResponse(addressResponse);

		return employeeResponse;
		
	}

	private AddressResponse callToAddressServiceUsingWebClient(int id) {
								return webClient
											.get()
											.uri("/address/"+id)
											.retrieve()
											.bodyToMono(AddressResponse.class)
											.block();
	}

	
	private AddressResponse callingAddressServiceUsingRESTTemplate(int id) {
//	get me the details for the ip and the port number 
		
//		List<ServiceInstance> instances = discoveryClient.getInstances("address-service");
//		ServiceInstance serviceInstance = instances.get(0);  //get(0) means only one instnace we need 
//		String uri = serviceInstance.getUri().toString();
		
//insted of discoveryClient we are using LoadBalancerClient this will help me to do load balancing 		
//		ServiceInstance serviceInstance = loadBalancerClient.choose("address-service");
//		String uri = serviceInstance.getUri().toString();
//		String contextRoot = serviceInstance.getMetadata().get("configPath");
//		
//		System.out.println(serviceInstance.getMetadata().get("user"));
//		
//		System.out.println("uri >>>>>>>>>>>> "+uri+contextRoot);
		
		return restTemplate.getForObject("http://ADDRESS-SERVICE/address-app/api/address/{id}", AddressResponse.class, id);
	}
}
