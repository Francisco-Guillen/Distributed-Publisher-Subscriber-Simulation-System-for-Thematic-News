package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PublisherController {

	@Autowired
	private PublisherRepository pr;
	
	@Autowired
	private NewsRepository nr;
	
	@GetMapping(path="/")
	public String main (Model model) {
	 	return "index";
	}
	
	@RequestMapping(value="/registarPublisher", method=RequestMethod.GET)
	public String form() {
		return "formPublisher";
	}
	
	@RequestMapping(value="/registarPublisher", method=RequestMethod.POST)
	public String form(@Validated Publisher publisher, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Erro, verifique os parâmetros!");
			return "redirect:/{codePublisher}";
		}
		pr.save(publisher);
		attributes.addFlashAttribute("mensagem", "Publisher adicionado com sucesso!");
		return "redirect:/registarPublisher";
	}
		
	@RequestMapping("/publishers")
	public ModelAndView listPublishers() {
		ModelAndView mv = new ModelAndView("Main");
		Iterable<Publisher> publisher = pr.findAll();
		mv.addObject("publishers", publisher);
		
		return mv;
	}
			
	@RequestMapping(value="/{codePublisher}", method=RequestMethod.GET)
	public ModelAndView publisherDetails(@PathVariable("codePublisher") long code) {
		Publisher publisher = pr.findByCode(code);
		ModelAndView mv = new ModelAndView("publisherDetails");
		mv.addObject("publisher", publisher);
		
		Iterable<News> news = nr.findByPublisher(publisher);
		mv.addObject("noticias", news);
		
		return mv;
	}
	
	
	@RequestMapping(value="/{codePublisher}", method=RequestMethod.POST)
	public String publisherDetailsPost(@PathVariable("codePublisher") long code, @Validated News news, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Erro, verifique os parâmetros!");
			return "redirect:/{codePublisher}";
		}
		
		Publisher publisher = pr.findByCode(code);
		news.setList(publisher);
		nr.save(news);

		attributes.addFlashAttribute("mensagem", "Notícia adicionada com sucesso!");
		return "redirect:/{codePublisher}";
	}
		
	@RequestMapping("/deletePublisher")
	public String deletePublisher(long code) {	
		Publisher publisher = pr.findByCode(code);
		pr.delete(publisher);
		
		return "redirect:/publishers";
	}
		
	@RequestMapping("/deleteNews")
	public String deleteNews(Integer intNews) {
		News news = nr.findByintNews(intNews);
		nr.delete(news);
		
		Publisher publisher = news.getList();
		long codeLong = publisher.getCode();
		String code = "" +codeLong;
		
		return "redirect:/" +code;
	}
}
