package ga.manuelgarciacr.pla5evact01;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author manuel
 */
@Component
public class Codificador {
    private final IProcesar procesar;
    private final ICodificar codificar;

    public Codificador(@Qualifier("proceso") IProcesar procesar, 
            @Qualifier("codificacion") ICodificar codificar) {
        this.procesar = procesar;
        this.codificar = codificar;
    }
    
    public String codificar(String cadena){
        ArrayList<String> al = procesar.dividir(cadena), alCod = new ArrayList<>();
        for(String str: al)
            alCod.add(codificar.codificar(str));
        return procesar.unir(alCod);
    }
    
    public String decodificar(String cadena){
        ArrayList<String> al = procesar.dividir(cadena), alCod = new ArrayList<>();
        for(String str: al)
            alCod.add(codificar.decodificar(str));
        return procesar.unir(alCod);
    }
    
}
