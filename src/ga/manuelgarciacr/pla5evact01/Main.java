package ga.manuelgarciacr.pla5evact01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author manuel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str = "aAmM, nNñÑ,    oOxXyY y zZááÁÁ.    @#$% ,.;-\"'`", strCod;
        
        System.out.println(str);
        
        System.out.println();
        
        // Cargar el contexto
        try(AnnotationConfigApplicationContext context = new
            AnnotationConfigApplicationContext(ConfigPalabrasInvertir.class)){

            // Pedir el bean
            Codificador codificador = context.getBean("codificador", Codificador.class);
            System.out.println(strCod = codificador.codificar(str));
            System.out.println(codificador.decodificar(strCod));
        }
        
        System.out.println();
        
        // Cargar el contexto
        try(AnnotationConfigApplicationContext context = new
            AnnotationConfigApplicationContext(ConfigPalabrasCesar.class)){

            // Pedir el bean
            Codificador codificador = context.getBean("codificador", Codificador.class);
            System.out.println(strCod = codificador.codificar(str));
            System.out.println(codificador.decodificar(strCod));
        }
    }
    
}
