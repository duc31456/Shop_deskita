package com.deskita.admin.user;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {

	@Test
	public void testEncodePassword() {
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		String rawPassword="dungidol";
		String encodedPassword=passwordEncoder.encode(rawPassword);
		System.out.println(encodedPassword);
		boolean matches=passwordEncoder.matches(rawPassword, encodedPassword);
		System.out.println(matches);
	}
}
