package ga.manuelgarciacr.pla5evact01;

import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 *
 * @author manuel
 */
@Component
public class Bloques implements IProcesar{
    private final int BLOCK_LENGTH = 4;
    
    @Override
    public ArrayList<String> dividir(String cadena) {
        ArrayList<String> al = new ArrayList<>();
        for(int i = 0; i<cadena.length(); i += BLOCK_LENGTH)
            al.add(cadena.substring(i, (i + BLOCK_LENGTH >= cadena.length())?cadena.length(): i + BLOCK_LENGTH ));
        return al;
    }

    @Override
    public String unir(ArrayList<String> cadenas) {
        return cadenas.stream().collect(Collectors.joining());
    }
}
