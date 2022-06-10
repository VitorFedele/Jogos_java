package jogodamina;

import java.util.Random;
import java.util.Scanner;


public class tabuleiro {
    private int[][] minas;
    private char[][]tabulelo;
    private int x, y; 
    Random K = new Random();
    Scanner sk = new Scanner(System.in);
    
public tabuleiro(){
    minas = new int[10][10];
    tabulelo = new char[10][10];
    iniciaMinas();
    sortearMinas();
    preencherDicas(); 
    iniciarTabuleiro();

}
public boolean ganhou() {
    int contar= 0;
    for(x = 1; x < 9; x++)
        for(y = 1; y < 9; y++)
            if(tabulelo[x][y]=='_')
                contar++;
    if (contar== 10)
        return true;
    else
        return false;
}
public void abrirVizinhas() {
    for(int i=-1; i<2; i++)
        for (int j=-1; j<2; j++)
            if((minas[x+i][y+j] != -1) && (y != 0 && y != 9 && x != 0 && x != 9)){
                tabulelo[x+i][y+j]= Character.forDigit(minas[x+i][y+j], 10);

            }
    public int getPosicao(int x, int y){
            return (minas[x][y]);
}
    public boolean setPosicao() {
        do{ 
        System.out.println("linha: ");
            x= sk.nextInt();
        System.out.println("coluna: ");
            y= sk.nextInt();
        if((tabulelo[x][y]!= '_')&&(( x <9 && x >0) &&(y <9 && y>0)))
            System.out.println("esse campo não existe, ou ja esta sendo exibido");
        if(x < 1 ||x > 8 || y < 1 || y > 8)
        System.out.println(" escolha um numero de 1 a 8");
        }while((x <1 && x >8 )&&(y<1 && y>8 ) || (tabulelo[x][y]!= '_'));
        if (getPosicao(x, y)== -1)
        return true;
    else
        return false;
}
    public void exibe() {
        System.out.println("");
    }

 
    public void exibeMinas() {
    }
}
