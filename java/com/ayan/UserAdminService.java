package com.ayan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ayan.bussiness.UserAdminSvc;
import com.ayan.helper.RoleAdminServiceHelper;
import com.ayan.helper.RoleAdminServiceHelperImpl;
import com.ayan.serviceObject.RoleSO;
import com.ayan.user.User;

@Controller
@RequestMapping("/user")
public class UserAdminService {

	@Autowired
	private UserAdminSvc userAdminSvc;

	private RoleAdminServiceHelper roleHelper = new RoleAdminServiceHelperImpl();

	@RequestMapping("/ping")
	@ResponseBody
	private String ping() {
		return "User Service is Up and ruuning !!";
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	private ResponseEntity<User> createUser(@RequestBody User user) {
		Long userId = userAdminSvc.createUser(user);
		roleHelper.addRoles(new RoleSO(1L, "New Role", userId));
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@RequestMapping(path = "/{userId}", method = RequestMethod.GET)
	private ResponseEntity<User> getUser(@PathVariable Long userId) {
		if (userId == null) {
			return null;
		}

		User user = userAdminSvc.getUser(userId);

		return new ResponseEntity<User>(user, HttpStatus.FOUND);
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	private ResponseEntity<List<User>> getUsers() {

		List<User> users = userAdminSvc.getUsers();

		return new ResponseEntity<List<User>>(users, HttpStatus.FOUND);
	}

	@RequestMapping(path = "/", method = RequestMethod.PUT)
	private ResponseEntity<User> updateUser(@RequestBody User user) {

		userAdminSvc.updateUser(user);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(path = "/{userId}", method = RequestMethod.DELETE)
	private ResponseEntity deleteUser(@PathVariable Long userId) {

		userAdminSvc.deleteUser(userId);

		return new ResponseEntity<User>(HttpStatus.OK);
	}

}
