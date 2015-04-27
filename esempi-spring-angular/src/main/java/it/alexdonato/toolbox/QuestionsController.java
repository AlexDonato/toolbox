/**
 * 
 */
package it.alexdonato.toolbox;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author alex
 *
 */
@Controller
@RequestMapping (value = "/domande")
public class QuestionsController {
	
	@RequestMapping (
		value = "/{id}", 
		method = RequestMethod.GET,
		produces = "application/json")
	public @ResponseBody Domanda getDomanda (@PathVariable Integer id) {
		Domanda domanda = new Domanda ();
		domanda.setId(id);
		domanda.setDomanda("Cippa lippa");
		return domanda;
	}
}
