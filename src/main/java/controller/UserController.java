package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sevice.UserService;
import model.User;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userServise;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() {
		return userServise.getAllUsers();
	}
	
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public ModelAndView validateUser() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userFromServer", new User());
		mav.setViewName("user_check_page");
		return mav;
	}
	
	@RequestMapping(value= "/check", method = RequestMethod.GET)
	public String checkUser (@ModelAttribute("userFromServer") User user) {
		if("admin".equals(user.getUserName()) && "admin".equals(user.getPassord()))
			return "valid";
		return "invalid username or password";
	}

}
