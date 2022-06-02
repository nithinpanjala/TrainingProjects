package com.foodmunch.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodmunch.Entity.Customer;
import com.foodmunch.Entity.CustomerAddress;
import com.foodmunch.Services.CustomerAddressService;



@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	CustomerAddressService addressService;

	
	@PostMapping(value = "/addAddress/{address}")
	public ResponseEntity<Customer> addAddress(@Valid @RequestBody CustomerAddress address) {

		return new ResponseEntity<Customer>(addressService.addAddress(address), HttpStatus.ACCEPTED);

	}
	@PostMapping(value = "/addUserAddress")
	public ResponseEntity<Customer> addUserAddress( @RequestParam String houseNumber, @RequestParam String addressLane1,@RequestParam String addressLane2, @RequestParam String landmark,
			 @RequestParam int pincode, @RequestParam String district, @RequestParam String state, @RequestParam long userId) {

		return new ResponseEntity<Customer>(addressService.addCustomerAddress(   houseNumber,  addressLane1,  addressLane2,  landmark,
				 pincode,  district,  state,  userId), HttpStatus.ACCEPTED);

	}
	
	
	@GetMapping(value = "/getSelectedAddress/{addressId}")
	public ResponseEntity<CustomerAddress> getSelectedAddress(@PathVariable("addressId") int addressId) {

		return new ResponseEntity<CustomerAddress>(addressService.getSelectedAddress(addressId), HttpStatus.ACCEPTED);

	}
	@GetMapping(value = "/getAllAddress/{userId}")
	public ResponseEntity<List<CustomerAddress>> getAllAddress(@Valid @PathVariable("userId") long userId) {

		return new ResponseEntity<List<CustomerAddress>>(addressService.getAllAddress(userId), HttpStatus.ACCEPTED);

	}
	
	
	
	
	
	@DeleteMapping(value = "/deleteAddressByUserId/{userId}/{userPassword}")
	public ResponseEntity<String> deleteAddressByUserId(@Valid @PathVariable long userId ,@Valid @PathVariable("userPassword") String userPassword) {
		return new ResponseEntity<String> ( addressService.deleteAddressByUserId(userId, userPassword), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteAddressByID/{addressId}")
	public ResponseEntity<String> deleteAddressByID(@Valid @PathVariable("addressId") int addressId) {
		return new ResponseEntity<String> ( addressService.deleteAddressByID(addressId), HttpStatus.OK);
	}
	
	
	

	@PutMapping(value = "/updateAddress/{address}")
	public  ResponseEntity<CustomerAddress> updateUser(@Valid @RequestBody CustomerAddress address) {
		return new ResponseEntity<CustomerAddress>(addressService.updateAddress(address), HttpStatus.ACCEPTED);

	}
	
	
	@PutMapping(value = "/updateLandmark")
	public ResponseEntity<CustomerAddress> updateUserEmail(@Valid @RequestParam int addressId,@Valid  @RequestParam String landmark) {
		return new ResponseEntity<CustomerAddress>(addressService.updateLandmark(addressId, landmark), HttpStatus.ACCEPTED);
	}
	


	@PutMapping(value = "/updateHouseNoAndStreet")
	public ResponseEntity<CustomerAddress> updateHouseNoAndStreet(@Valid @RequestParam int addressId,@Valid  @RequestParam String houseNumber,@Valid @RequestParam String addressLane1) {
		return new ResponseEntity<CustomerAddress>(addressService.updateHouseNoAndStreet(addressId, houseNumber,addressLane1), HttpStatus.ACCEPTED);
	}
	




	
}