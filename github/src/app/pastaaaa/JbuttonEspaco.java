package app.pastaaaa;


import javax.swing.JButton;
import javax.swing.SwingUtilities;


public final class JbuttonEspaco extends JButton{
    int linha;
    int coluna;
    campo c;
    Espaco e;
    JTelinhas campinhoGraf;
    String text;
   
   
    public JbuttonEspaco(campo c, JTelinhas cg){
        this.campinhoGraf = cg;
        text = "";
        this.setText(text);
      this.c = c;
            this.addActionListener((java.awt.event.ActionEvent evt) -> {
                botPress(false);
            
        });

        this.addMouseListener( new java.awt.event.MouseAdapter() {           
            public void mousePressed(java.awt.event.MouseEvent e){
              if(SwingUtilities.isRightMouseButton(e)){
                botPress(true);
              };

            }
        } );
        
    }
    
    
    private void botPress(boolean mouseDireito){
        if(!mouseDireito){
           if (!this.e.marcado)
            this.clicar();
        }else{
            this.marcar();
           
        }
       this.campinhoGraf.estado();

    }
    public void clicar(){
        System.out.println("linha: " + linha + " coluna: " + coluna);

      
        int ret = e.clicar();

        if(this.e.minado){
            this.campinhoGraf.revelarMnias();
            
        }
        if(ret == 0){
           for(Espaco vizinho : e.vizinhos){
            if(!vizinho.clicado)
                vizinho.button.clicar();

           }
          
           // return;
        }
    
       this.text = Integer.toString(ret);
        this.MiRevela(this.text);
            //this.c.Finalizado()


    }
    public void marcar(){
        if(this.e.clicado) return;
        boolean estaMarcado = this.e.marcar();
        if( this.e.marcado){
            this.setText("◄");
        }else{
            this.setText("");
        

        }

    }
    public void setPos(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna; 
        this.e = c.getEspaco(linha, coluna);
    }


    
    public void MiRevela(String cod){
        this.setText(cod);
        this.setEnabled(false);
    }   
}