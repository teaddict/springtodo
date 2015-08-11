package tr.lkd.lyk2015.springtodo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.lkd.lyk2015.springtodo.model.Todo;
import tr.lkd.lyk2015.springtodo.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {
	
	
	@Autowired
	private TodoService todoService;

	@RequestMapping("")
	public String list(Model model) {
		List<Todo> todos = todoService.getAll();
		
		model.addAttribute("todoList", todos);
		return "todoList";
	}

	
	// "/todo/create" 
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createForm(@ModelAttribute Todo todo) {
		
		return "createForm";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute Todo todo) {
		todoService.create(todo);
		
		return "redirect:/todo";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute HashMap<String, String> map) {
		//todoService.update(todo);
		System.out.println(map);
		return "redirect:/todo";
	}
	
	@RequestMapping(value = "/mark", method = RequestMethod.POST)
	public String mark(@ModelAttribute Todo todo) {
		//todoService.update(todo);
		System.out.println(todo.getId() + " and  " + todo.isDone());
		todoService.updateById(todo);
		return "redirect:/todo";
	}

}
