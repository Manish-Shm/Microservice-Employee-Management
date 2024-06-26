package com.addressapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.addressapp.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{
//we need to find the address based on the employee id so we are writing a query for the same
	
	@Query(nativeQuery = true,value = "SELECT ea.id,ea.lane1,ea.lane2,ea.state,ea.zip FROM seleniumexpressnew.address ea join seleniumexpressnew.employee e on e.id=ea.employee_id where ea.employee_id=:employeeId")
	Address findAddressByEmployeeId(@Param("employeeId") int employeeId);
	
}
