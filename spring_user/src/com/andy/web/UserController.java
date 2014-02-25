package com.andy.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.andy.model.User;
import com.andy.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {
	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}
	
	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value={"/users","/"},method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("pagers", userService.find());//pagers是用来给前台显示准备的数据model
		return "user/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new User());//如果不写model的name，默认为类型的String为其name
		return "user/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated User user,BindingResult br) {
		if(br.hasErrors()) {
			return "user/add";
		}
		userService.add(user);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String show(@PathVariable int id,Model model) {
		model.addAttribute(userService.load(id));
		return "user/show";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		model.addAttribute(userService.load(id));
		return "user/update";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(@PathVariable int id,@Validated User user,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "user/update";
		}
		User tu = userService.load(id);
		tu.setPassword(user.getPassword());
		tu.setNickname(user.getNickname());
		tu.setEmail(user.getEmail());
		userService.update(tu);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/user/users";
	}
}
