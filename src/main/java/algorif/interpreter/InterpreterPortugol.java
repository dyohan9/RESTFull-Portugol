package algorif.interpreter;

import algorif.model.Portugol;
import parser.OpenAlg;
import parser.OpenAlgInterpreter;
import parser.ParseException;
import util.OpenAlgNode;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InterpreterPortugol {
    public List<Portugol> run(){
        String stdout = "";
        try {
            String codePortugol = "algoritmo \"nome do algoritmo\"\n" +
                    "\n" +
                    "/* variáveis globais */\n" +
                    "var\n" +
                    "  i: inteiro\n" +
                    "\n" +
                    "/* Inicio do algoritmo */\n" +
                    "inicio\n" +
                    "  escreva(\"teste do escreva: \")\n" +
                    "fimalgoritmo";

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            PrintStream old = System.out;
            System.setOut(ps);

            OpenAlg parser = new OpenAlg(this.createTempFile(codePortugol));
            OpenAlgNode root = parser.start();
            new OpenAlgInterpreter(parser.globals).run(root);
            System.out.flush();
            System.setOut(old);

            stdout = baos.toString();

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(Collections.singletonList(
                new Portugol(stdout)
        ));

    }

    private String createTempFile(String codePortugol) throws IOException {
        File temp = File.createTempFile("portugol", ".tmp");
        BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
        bw.write(codePortugol);
        bw.close();
        return temp.getAbsolutePath();
    }
}
