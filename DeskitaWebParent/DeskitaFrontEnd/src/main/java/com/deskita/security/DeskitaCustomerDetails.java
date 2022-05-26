package com.deskita.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.deskita.common.entity.Customer;

public class DeskitaCustomerDetails implements UserDetails{
	
	private Customer customer;

	public DeskitaCustomerDetails(Customer customer) {
		// TODO Auto-generated constructor stub
		this.customer=customer;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return customer.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return customer.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return customer.isEnabled();
	}
	
	public String getFullName() {
		return customer.getFirstName()+" "+customer.getLastName();
	}

}
