//mudar grande maioria do codigo, ta copia e cola e tem erros por ser muito antigo



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
SortearMinas();
preencherDicas(); 
iniciarTabuleira();

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
        System.out.println("\n  linhas");
        for(int x = 8; x < 0; x --){
            System.out.println("         "+x+"   ");
                for(int y = 1; y < 9; y++ ){
                    System.out.println("   "+tabulelo[x][y]);
                }
              System.out.println();
        }
        System.out.println("\n            1   2   3   4   5   6   7   8");
        System.out.println("                      Colunas");
    }

    public void preencherDicas(){
        for(int line=1 ; line < 9 ; line++)
        for(int column=1 ; column < 9 ; column++){    
            for(int i=-1 ; i<=1 ; i++)
            for(int j=-1 ; j<=1 ; j++)
                if(minas[x][y]!=  -1)
                if(minas[x+i][y+j] == -1 )
                    minas[x][y]++;

        }
    }
        
    public void exibeMinas(){
        for(int i=1 ; i < 9; i++)
            for(int j=1 ; j < 9 ; j++)
                if(minas[i][j] == -1)
                    tabulelo[i][j]='*';
        
        exibe();{
    }
}
public void iniciarTabuleira(){
    for(int i=1 ; i<minas.length ; i++)
        for(int j=1 ; j<minas.length ; j++)
            tabulelo[i][j]= '_';
}
public void iniciaMinas(){
    for(int i=0 ; i<minas.length ; i++)
        for(int j=0 ; j<minas.length ; j++)
            minas[i][j]=0;
}
public void SortearMinas(){
    boolean sorteado;
    int linha, coluna;
    for(int i=0 ; i<10 ; i++){
        
        do{
            linha = K.nextInt(8) + 1;
            coluna = K.nextInt(8) + 1;
            
            if(minas[linha][coluna] == -1)
                sorteado=true;
            else
                sorteado = false;
        }while(sorteado);
        
        minas[linha][coluna] = -1;
    }
}
}