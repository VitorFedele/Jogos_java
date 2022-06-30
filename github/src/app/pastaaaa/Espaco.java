package app.pastaaaa;
import java.util.ArrayList;



public class Espaco{
    boolean minado;
    boolean revelado;
    boolean marcado;
    boolean clicado;
    ArrayList<Espaco> vizinhos;

public Espaco(){
    this.minado = false;
    this.revelado = false;
    this.marcado = false;
    this.clicado = false;
    
    this.vizinhos = new ArrayList();
}

    public void AddVizinhos(Espaco e){
        this.vizinhos.add(e);
    }


    public boolean minar(){
        if(!this.minado){
            this.minado = true;
            return true;

        }else{
            return false;
        }   
  }
    public boolean marcar(){
        this.marcado = !this.marcado;
        return this.marcado;
    }
    public int clicar(){
        this.clicado = true;
        if(this.minado){
            return-1;

        }else{
            return NumMinasNosVizinhos();

        }

    }
    public int NumMinasNosVizinhos(){
       int n = 0;
        for(Espaco e: this.vizinhos){
            if(e.minado) n++;
        }
        return n;
    }
    public void reset(){
        this.minado = false;
        this.revelado = false;
        this.marcado = false;
        this.clicado = false;
    }
    public String toString(){
        if(this.minado)
        return "-1";
        return "+" + this.NumMinasNosVizinhos();
    }

}


