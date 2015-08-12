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
import org.springframework.web.bind.annotation.RequestParam;

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
	public String update(@ModelAttribute Todo todo, Model model) {
		//todoService.update(todo);
		System.out.println(todo);
		todoService.update(todo);
		model.addAttribute("message", "success");
		return "redirect:/todo/edit?id=" + todo.getId();
	}
	
	@RequestMapping(value = "/mark", method = RequestMethod.POST)
	public String mark(@ModelAttribute Todo todo) {
		//todoService.update(todo);
		System.out.println(todo.getId() + " and  " + todo.isDone());
		todoService.updateById(todo);
		return "redirect:/todo";
	}
	
	//bu şekilde de bi yöntem var fakat kullanılması tercih edilmez
/*	@RequestMapping(value = "/mark", method = RequestMethod.POST)
	public String mark(@ModelAttribute Todo todo,HttpServletRequest request) {
		//todoService.update(todo);
		String id = request.getParameter("id");
		String done = request.getParameter("done");
		System.out.println(todo.getId() + " and  " + todo.isDone());
		todoService.updateById(todo);
		return "redirect:/todo";
	}*/
	
	
	// required=true yazmasak da olur, default olarak true kabul ediyor
	@RequestMapping(value = "/edit", method = RequestMethod.GET,params={"id"})
	public String editForm(Model model,@RequestParam String id,@RequestParam (value="message",required=false) String message)
	{
		Long i = Long.valueOf(id).longValue();
		Todo todo = todoService.getById(i);
		model.addAttribute("todo", todo);
		model.addAttribute("message", message);
		return "editForm";
	}
	
	/* bu şekilde de yapabiliriz
		@RequestMapping(value = "/update", method = RequestMethod.GET, params="id")
		public String updateForm(@RequestParam("id") Long id,@ModelAttribute Todo todo) 
		{
		
			Long i = Long.valueOf(id).longValue();
			Todo todoNew = todoService.getById(todo.getId());
		
			//todo = todoNew ; diyemeyiz çünkü spring burda sadece todo nesnesini
			//tanıyor. bu nesneye başka referans verince artık spring onu tanımıyor
			
			todo.setName(todoNew.getName());
			todo.setDesc(todoNew.getDesc());
			todo.setDone(todoNew.isDone());
			todo.setDueDate(todoNew.getDueDate());
			return "editForm";
		}
	*/
}
