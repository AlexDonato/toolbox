package it.alexdonato.toolbox;

import it.alexdonato.toolbox.form.ScommessaForm;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@ModelAttribute ScommessaForm scommessaForm, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		model.addAttribute("scommessaForm", scommessaForm);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("scommessaForm", scommessaForm);
		
		return "home";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String homePost (@Valid @ModelAttribute ScommessaForm scommessaForm, BindingResult result, Locale locale, Model model) {
		logger.info("Post .", locale);
		if(result.hasErrors()) {
			model.addAttribute("scommessaForm", scommessaForm);
			return "home"; // la view
		}
		model.addAttribute("scommessaForm", scommessaForm);
		
		return "home";
	}	
	
}
