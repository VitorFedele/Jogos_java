

//ARRUMAR TUDO!
//arrumar classe app e refazer "cabum" de forma com que fique novamente usavel








package jogodamina;

public class Cabum {
    private tabuleiro board;
    boolean Final = false;
    boolean ganhar =  false;
    int[] jogada;
    int rodada=0; 
    
    public Cabum(){
        board = new tabuleiro();
        jogar(board);
        jogada = new int[2];
    }

    private void jogar(tabuleiro board) {
        do{
            rodada++;
            System.out.println("rodada" + rodada);
            board.exibe();
            Final = board.setPosicao();

             if(!Final){
                 board.abrirVizinhas();
                 Final = board.setPosicao();

             }
        }while(!Final);

        if(board.ganhou()){
        System.out.println("tinha uma bomba aikkkkkkkkkkkkkk noob! começa de novo kkkkk");
        board.exibeMinas();
    } else {
        System.out.println("consegiu seu horrivel! nao fez mais que sua obrigação em " +rodada+ " rodada");
        board.exibeMinas();
        }

   

    }

}
