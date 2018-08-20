package com.capgemini.capstore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.beans.Authentication;
import com.capgemini.capstore.repo.LoginRepo;


@Service
public class LoginServicesImpl implements UserDetailsService {

	@Autowired
	private LoginRepo loginRepo;

	@Override
	public UserDetails loadUserByUsername(String mobile_no) throws UsernameNotFoundException {
		Authentication authenticate = this.loginRepo.findUserAccount(mobile_no);

		if (authenticate == null) {
			throw new UsernameNotFoundException("User " + mobile_no + " was not found in the database");
		}
			// [ROLE_USER, ROLE_ADMIN,..]
		List<String> roleNames = this.loginRepo.getRoleNames(authenticate.getMobileNo());

		List<GrantedAuthority> grantList = new ArrayList<>();
		if (roleNames != null) {
			for (String role : roleNames) {
				// ROLE_USER, ROLE_ADMIN,..
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}
		UserDetails userDetails = (UserDetails) new User(authenticate.getMobileNo(),authenticate.getPassword(), grantList);
		return userDetails;
	}

}
