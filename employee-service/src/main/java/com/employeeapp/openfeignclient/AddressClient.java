package com.employeeapp.openfeignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employeeapp.response.AddressResponse;

@FeignClient(name = "ADDRESS-SERVICE", path = "address-app/api/")
public interface AddressClient {
//this is a proxy don't need to do anything implementation is given automatically at the runtime 	
	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int id);
	
}
