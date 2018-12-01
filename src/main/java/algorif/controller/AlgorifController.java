package algorif.controller;

import algorif.model.Portugol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlgorifController {
    @Autowired
    private AlgorifService algorifService;

    @RequestMapping("/teste")
    public List<Portugol> Interpreter(){
        return algorifService.Interpreter();
    }
}
