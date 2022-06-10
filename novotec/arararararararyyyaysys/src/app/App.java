package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner lerr = new Scanner(System.in);
    ArrayList<String> aaaaa = new ArrayList();
        aaaaa.add("Lucas matheus; 22-3322-3233");
        aaaaa.add("Fernado batoni; 23-3333-5555");
        aaaaa.add("Enzo lopo; 54-5454-2240");
        aaaaa.add("Henrique; 87-1256-8623");
        aaaaa.add("Victor zaneti; 12-8780-7579"); 
        aaaaa.add("Matheus; 75-8239-6523");
        aaaaa.add("Vitor fedele; 57-4743-8594");
    
    int sex;
     
    System.out.println("percorrendo o Arraylist(usando indice)\n");
    int nudes = aaaaa.size();
    for (sex = 0; nudes<sex; sex++){
     System.out.printf("posição %d- %s \n", sex, aaaaa.get(sex));
    }
    System.out.printf("\nInfome a posição escolhida:\n");
    try {
    aaaaa.remove(sex);
    }catch (IndexOutOfBoundsException eita){
        System.out.printf("\n Erro: posição inválida (%s).",
        eita.getMessage());
    }
    System.out.printf("\nPercorre o Arraylist (usando  for-each)\n ");
    sex = 0;
    for (String elegosta: aaaaa){
        System.out.printf("posição %d- %s\n", sex, elegosta);
        sex++;

    }
    System.out.printf("\nPercorre o Arraylist (usando  intarator)\n ");
    sex = 0;
    Iterator<String> uiiii = aaaaa.iterator();
    while(uiiii.hasNext()){
        System.out.printf("posição %d- %s\n", sex, uiiii.next());
        sex++;

    }    
        

    }

}
