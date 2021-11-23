package view.UsandoSwitchCase;

import java.io.IOException;

public class ControleDeFluxoGame {
    
    
    public static void main(String[] args) throws IOException {

        System.out.print("Digite uma das letras da palavra APLICATIVOS: ");

        int codigoASCII = System.in.read();

         switch ((char) codigoASCII) {
             case 'A':
             case 'P':
             case 'L':
             case 'I':
             case 'C':
             case 'a':
             case 'T':
             case 'i':
             case 'V':
             case 'O':
             case 'S':
             case 'p':
             case 'l':
             case 'c':
             case 't':
             case 'v':
             case 'o':
             case 's':
             
             System.out.println("Código da tecla: " + codigoASCII);
             System.out.println("Letra digitada: " + (char) codigoASCII);
                break;
         
             default:
                System.out.println("LETRA NÃO ENCONTRADA !");
         }
        
    }
}
