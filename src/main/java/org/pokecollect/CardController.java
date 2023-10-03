package org.pokecollect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//testing spring annotations to ensure successful import
@Controller
public class CardController {

    /**
     * Listens for a connection to root (/) endpoint
     * @return start page
     */
    @RequestMapping("/")
    public String index() {
        return "start";
    }
}
