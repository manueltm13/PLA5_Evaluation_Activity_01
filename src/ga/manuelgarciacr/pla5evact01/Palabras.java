package ga.manuelgarciacr.pla5evact01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 *
 * @author manuel
 */
@Component
public class Palabras implements IProcesar{

    @Override
    public ArrayList<String> dividir(String cadena) {
        return new ArrayList<>(Arrays.asList(cadena.split(" ")));
    }

    @Override
    public String unir(ArrayList<String> cadenas) {
        return cadenas.stream().collect(Collectors.joining(" "));
    }
    
}
