package ppspspspss;

public abstract class pessoa {
    private String Nome;
    protected int AnoInscricao;
    protected double TotalCompra;
    
    public void Pessoa(String Nome, int AnoInscricao){
        this.AnoInscricao = AnoInscricao;
        this.Nome = Nome;
    }
    abstract public double calcBonus(int Ano);
        
    public void addCompras(double TotalCompra){
        this.TotalCompra = TotalCompra;
    }
    public int getAnoInscricao() {
        return AnoInscricao;
}
    public String getNome(){
        return Nome;
}
    public double getTotalCompra(){
        return TotalCompra;
}

}



