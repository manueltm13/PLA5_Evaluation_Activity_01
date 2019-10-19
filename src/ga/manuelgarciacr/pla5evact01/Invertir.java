package ga.manuelgarciacr.pla5evact01;

import org.springframework.stereotype.Component;

/**
 *
 * @author manuel
 */
@Component
public class Invertir implements ICodificar{

    @Override
    public String codificar(String cadena) {
        String str = "";
        for(int i = cadena.length() - 1; i >= 0 ; i--)
            str += cadena.substring(i, i + 1);
        return str;
    }

    @Override
    public String decodificar(String cadena) {
        return codificar(cadena);
    }
    
}
