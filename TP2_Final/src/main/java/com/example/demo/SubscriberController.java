package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SubscriberController {
	
	@Autowired
	private NewsRepository nr;
	
	@Autowired
	private SubscriberRepository sr;
	
	@RequestMapping(value="/registarSubscriber", method=RequestMethod.GET)
	public String form() {
		return "formSubscriber";
	}
	
	@RequestMapping(value="/registarSubscriber", method=RequestMethod.POST)
	public String form(@Validated Subscriber subscriber, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Erro, verifique os parâmetros!");
			return "redirect:/{codeSubscriber}";
		}
		sr.save(subscriber);
		attributes.addFlashAttribute("mensagem", "Subscriber adicionado com sucesso!");
		return "redirect:/registarSubscriber";
	}
	
	@RequestMapping("/subscribers")
	public ModelAndView listSubscribers() {
		ModelAndView mv = new ModelAndView("Main2");
		Iterable<Subscriber> subscriber = sr.findAll();
		mv.addObject("subscribers", subscriber);
		
		return mv;
	}
		
	@RequestMapping(value="/{codeSubscriber}"+"sub", method=RequestMethod.GET)
	public ModelAndView subscriberDetails(@PathVariable("codeSubscriber") Integer subCode) {
		Subscriber subscriber = sr.findBysubCode(subCode);

		ModelAndView mv = new ModelAndView("subscribersDetails");
		mv.addObject("subscriber", subscriber);
		
		Iterable<News> news = nr.findBytopic(subscriber.getSubTopic());
			
		mv.addObject("noticiasSubs", news);
		
		return mv;
	}
	
	@RequestMapping(value="/{codeSubscriber}"+"sub", method=RequestMethod.POST)
	public String subscriberDetailsPost(@PathVariable("codeSubscriber") Integer subCode, @Validated News news, BindingResult result2, RedirectAttributes attributes2) {
		if(result2.hasErrors()) {
			attributes2.addFlashAttribute("mensagem", "Erro, verifique os parâmetros!");
			return "redirect:/{codeSubscriber}";
		}
		
		Subscriber subscriber = sr.findBysubCode(subCode);
		//String topico = subscriber.getSubCode();
		news.setSubscriber(subscriber);
		nr.save(news);
		
		attributes2.addFlashAttribute("mensagem", "Notícia com tópico subscrito adicionada!");
		return "redirect:/{codeSubscriber}";
	}
	
	@RequestMapping("/deleteSubscriber")
	public String deleteSubscriber(Integer subCode) {	
		Subscriber subscriber = sr.findBysubCode(subCode);
		sr.delete(subscriber);
		
		return "redirect:/subscribers";
	}
}
