package ga.manuelgarciacr.pla5evact01;

import java.text.Normalizer;
import org.springframework.stereotype.Component;

/**
 *
 * @author manuel
 */
@Component
public class Cesar implements ICodificar{
    private final int STEP = 2;

    @Override
    public String codificar(String cadena) {
        String str = Normalizer.normalize(cadena, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        StringBuilder sb = new StringBuilder(str);
        char chr;
        int base, chrVal;
        String output = "";
        
        for(int i = 0; i < cadena.length(); i++)
            if(cadena.charAt(i) == 'Ñ' || cadena.charAt(i) == 'ñ')
                sb.setCharAt(i, cadena.charAt(i));
        str = sb.toString();
        for(int i = 0; i < str.length(); i++){
            chr = str.charAt(i);
            base = getBase(chr);
            if(base == 0){ // No es una letra
                output += chr;
                continue;
            }
            chrVal = charToAscii(chr, base);
            chrVal += STEP;
            if(chrVal > base + 26) // Posterior a la Z
                chrVal -= 27;
            chr = asciiToChar(chrVal, base);
            output += chr;
        }
        return output;
    }

    @Override
    public String decodificar(String cadena) {
        String output = "";
        char chr;
        int base, chrVal;
        
        for(int i = 0; i < cadena.length(); i++){
            chr = cadena.charAt(i);
            base = getBase(chr);
            if(base == 0){ // No es una letra
                output += chr;
                continue;
            }
            chrVal = charToAscii(chr, base);
            chrVal -= STEP;
            if(chrVal < base) // Anterior a la A
                chrVal += 27;
            chr = asciiToChar(chrVal, base);
            output += chr;
        }
        return output;
    }
    
    /**
     * Devuelvo el valor ASCII de la A mayúscula o minúscula según chr. Si no es una letra
     * retorno cero
     * @param chr - Caracter para chequear si es mayúscula, minúscula o no es una letra
     * @return - Valor ASCII de la letra A mayúscula o minúscula o cero
     */
    private int getBase(char chr){
        int type = Character.getType(chr);
        if(type == Character.LOWERCASE_LETTER)
            return 97;
        else if(Character.getType(chr) != Character.UPPERCASE_LETTER)
            return 0;
        else
            return 65;
    }
    
    /**
     * Busco pseudovalor ASCII de un caracter. Intercalo la Ñ entre la N y la O.
     * @param chr - Caracter del que obtendré el pseudovalor ASCII
     * @param base - Valor ASCII de la A mayúscula o minúscula según lo sea chr
     * @return - Valor ASCII de chr con Ñ intercalada
     */
    private int charToAscii(char chr, int base){
        int chrVal = (int) chr;
        
        if(chrVal == base + 144) // Es una Ñ
            chrVal -= 130; // Posición detrás de la N
        else if(chrVal > base + 13) // Es posterior a la N pero no es una Ñ
            chrVal++; // Dejo hueco para la Ñ
        return chrVal;
    }
    
    /**
     * Convierto pseudovalor ASCII en un caracter. La Ñ está intercalada entre la N y la O.
     * @param chrVal - Pseudovalor ASCII a convertir.
     * @param base - Valor ASCII de la A mayúscula o minúscula según lo sea chrVal 
     * @return - Caracter correspondiente al pseudovalor chrVal
     */
    private char asciiToChar(int chrVal, int base){
        if(chrVal == base + 14) // Ñ
            chrVal += 130;
        else if (chrVal > base + 13) // Posterior a la N
            chrVal --;
        return (char)chrVal;
    }
}
