package curso.springmvc.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "index"; // Vai procurar pagina Html ou arquivo com nome index
	}
	
}
