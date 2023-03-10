package ru.churakova.PP312springboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.churakova.PP312springboot.models.User;
import ru.churakova.PP312springboot.service.UserService;


@Controller
@RequestMapping("/")
public class UsersController {
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping()
	public String showAllUsers(ModelMap model) {
		model.addAttribute("users", userService.getUsers());

		return "allUsers";
	}

	@GetMapping("/addNewUser")
	public String addNewUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "newUser";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "user-info";

		userService.saveUser(user);

		return "redirect:/";
	}

	@PatchMapping("/{id}")
	public String updateUser(@PathVariable("id") Integer id, Model model) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);

		return "user-info";
	}

	@DeleteMapping("/{id}/delete")
	public String deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUser(id);

		return "redirect:/";
	}
}