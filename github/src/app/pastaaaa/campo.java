package app.pastaaaa;

import java.util.Random;

public class campo {
    Espaco[][] matriz;

    public campo(){
        matriz = new Espaco[C.NUM_LINHAS][C.NUM_COLUNAS];
        for(int i = 0; i< C.NUM_LINHAS; i++){
        for(int j = 0; j < C.NUM_COLUNAS; j++){
            matriz[i][j] = new Espaco();
            }
        }
        for(int i = 0; i< C.NUM_LINHAS; i++){
            for(int j = 0; j < C.NUM_COLUNAS; j++){
                if(i > 0){
                if (j > 0)matriz[i][j].AddVizinhos(matriz[i-1][j-1]);
                matriz[i][j].AddVizinhos(matriz[i-1][j]);
                if (j < C.NUM_COLUNAS -1) matriz[i][j].AddVizinhos(matriz[i-1][j+1]);
                }
                if (j > 0)matriz[i][j].AddVizinhos(matriz[i][j-1]);
                if (j < C.NUM_COLUNAS -1)matriz[i][j].AddVizinhos(matriz[i][j+1]);
                
                if(i < C.NUM_LINHAS -1){
                if (j > 0) matriz[i][j].AddVizinhos(matriz[i+1][j-1]);
                matriz[i][j].AddVizinhos(matriz[i+1][j]);
                if (j < C.NUM_COLUNAS -1)matriz[i][j].AddVizinhos(matriz[i+1][j+1]);
    }
            }


}

    }

    public void addMinas(){
        int n = C.NUM_MINAS;
        Random randInt = new Random();
        while (n > 0){
            
            int lin = randInt.nextInt(C.NUM_LINHAS);
            int col = randInt.nextInt(C.NUM_COLUNAS);
            
            if(matriz[lin][col].minar()){
                n--;
            }
            

        }

    }

        public int clicar(int linha, int coluna){
            return matriz[linha][coluna].clicar();
        }
        public boolean Finalizado(){
            for(int i = 0; i< C.NUM_LINHAS; i++ ){
                for(int j = 0; j < C.NUM_COLUNAS; j++){
                    if(!matriz[i][j].Finalizado()) return false;
                }

        }
            return true;
        }
        public Espaco getEspaco(int linha, int coluna){
            return matriz[linha][coluna];
        }
        public String toString(){
            String Str ="";
            for(int i = 0; i < C.NUM_LINHAS; i++){
                for(int j = 0; j < C.NUM_COLUNAS; j++){
                    Str += matriz[i][j]+" ";
                }
                Str += "\n";
            }
            return Str;

        }


}

