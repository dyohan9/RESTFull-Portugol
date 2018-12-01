package algorif.controller;

import algorif.interpreter.InterpreterPortugol;
import algorif.model.Portugol;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AlgorifService {

//    private List<Portugol> portugolList = new ArrayList<Portugol>(Collections.singletonList(
//            new Portugol("1", "dsadsa", "")
//    ));

    List<Portugol> Interpreter(){
        return new InterpreterPortugol().run();
    }
}
