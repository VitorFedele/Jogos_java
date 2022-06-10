package ppspspspss;

  public class pessoaJuridica extends pessoa {
    private String CGC;
    private double TaxaIncentivo;   
    public pessoaJuridica(final String CGC, final String Nome, final int AnoInscrição){
  }    
    public double calcBonus(final int Ano){
      return Ano;
  }
    public void setTaxaIncentivo(final double TaxaIncentivo){
  }
    public String getCGC(){
     return CGC;
  }
    public double getTaxaIncentivo(){
      return TaxaIncentivo;
  }
  }