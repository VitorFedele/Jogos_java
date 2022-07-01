package app;

import app.pastaaaa.campo;
import app.pastaaaa.JTelinhas;

public class App {
    public static void main(String[] args) throws Exception {
      
      campo c = new campo();
      c.addMinas();
     //System.out.println(c);
      JTelinhas T = new JTelinhas(c);

    }

    
}