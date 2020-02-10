package angular.spring.controllers;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import angular.spring.domain.User;

@RestController
public class UserController {
	
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@GetMapping(value = "/home")
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	
	@GetMapping(value = "/userList")
	public @ResponseBody User getDetails() {
		
		logger.info("Fetching user details ...!");
		User user = new User();
		user.setName("Tinga");
		user.setDepartment("compro");
		logger.info("User details are: " + user.toString());
		return user;
	}
}
