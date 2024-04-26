package com.addressapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addressapp.entity.Address;
import com.addressapp.repo.AddressRepo;
import com.addressapp.response.AddressResponse;

@Service
public class AddressService {
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AddressResponse findAddressByEmployeeId(int employeeId) {
		
		System.out.println("finding address for employee "+employeeId);
		
		Address address = addressRepo.findAddressByEmployeeId(employeeId);
		
		AddressResponse addressResponse = modelMapper.map(address, AddressResponse.class);
		
		return addressResponse;
		
	}

}
