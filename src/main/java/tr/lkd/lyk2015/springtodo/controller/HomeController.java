package tr.lkd.lyk2015.springtodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/") // "/" urlinde çalışır
public class HomeController {
	
	@RequestMapping("")
	public String home(Model model){
		model.addAttribute("message", "Welcome message!");
		return "home";
		//burda gidip html altında home.html a gidip render ediyor
		//bunu webconfig dosyasında templateresolver ile ayarladık
	}
	
	@RequestMapping(value = "", params="unsafe")
	public String unsafe(@RequestParam("unsafe") Boolean unsafe, Model model){
		
		if(unsafe){
			model.addAttribute("message", "This is the unsafe page");
		}
		
		return "home";
	}
	
}
