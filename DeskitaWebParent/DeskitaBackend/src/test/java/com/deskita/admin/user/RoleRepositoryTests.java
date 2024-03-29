package com.deskita.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

import com.deskita.admin.repository.RoleRepository;
import com.deskita.common.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
	
	@Autowired
	private RoleRepository roleRepository;
	
	 @Autowired
	   private JdbcTemplate jdbcTemplate;
	 
	@Test
	public void testCreateFirstRole() {
		Role roleAdmin=new Role("Admin","manage everything");
		Role savedRole=roleRepository.save(roleAdmin);
		assertThat(savedRole.getId()).isGreaterThan(0);
	}
	//Test nhanh cua Long
	
	@Test
	public void testCreateRestRole() {
		Role roleSalesperson=new Role("Salesperson","manage product, customers, shipping, orders and sales report");
		Role roleEditor=new Role("Editor"," manage categories, brands, products, articles and menus");
		Role roleShipper=new Role("Shipper","view products, view orders, and update order status");
		
		roleRepository.save(roleSalesperson);
		roleRepository.save(roleEditor);
		roleRepository.save(roleShipper);
		
	}
}
