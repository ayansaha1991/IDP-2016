package com.ayan.helper;

import java.net.URI;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.client.RestTemplate;

import com.ayan.serviceObject.RoleSO;

public class RoleAdminServiceHelperImpl implements RoleAdminServiceHelper {

	private static final Log log = LogFactory
			.getLog(RoleAdminServiceHelperImpl.class);

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public void addRoles(RoleSO role) {

		URI health = restTemplate.postForLocation("http://localhost:5050/role/", role, RoleSO.class); 
		log.info("Role Service Health : " + health.toASCIIString());
		
	}

	@Override
	public void removeRoles() {

	}

}
