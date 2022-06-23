
//arrumar app por inteiro



import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    
    Scanner gg = new Scanner(System.in);
        int pp;
        
        do{
    System.out.println("qual jogo você quer jogar? \n 1- Flappy Bird \n 2- Snake Game\n 3- Campo minado");
        pp = gg.nextInt();
        if(pp == 1){
    System.out.println("1- iniciando Flappy bird");
        break;
        }
        if(pp == 2){
    System.out.println("2- iniciando Snake game");
        break; 
        }
        if(pp == 3){
    System.out.println("3- iniciando campo minado");
        Cabum jogo = new Cabum();
        break;
        }
        if(pp >= 4){
    System.out.println("!Este jogo não existe!");
        break;        
        }
    
    }while (pp != 3);
       






        } 
    }


