import java.util.ArrayList;
import java.util.Random;

public class Atendimento {
    private Cabine cabine;
    private ArrayList<Veiculo> relatorioVeiculo;
    private ArrayList<Integer> tempoAtendimento;
    private ArrayList<Double> valorPagoVeiculo;
    private double valorTotal;
    private int tempoCarro;

    public Atendimento(Cabine cabine){
        relatorioVeiculo = new ArrayList<>();
        tempoAtendimento = new ArrayList<>();
        valorPagoVeiculo = new ArrayList<>();
        this.cabine = cabine;
        this.valorTotal = 0f;
        this.tempoCarro = 20;
    }

    public void removeCarro(){
        Boolean condicao = tempoDeAtendimento();
        if(condicao == false){
            
        }else{
            valorPago();
            Veiculo aux = cabine.saiDaCabine();
            relatorioVeiculo(aux);
        }
        
        
    }

    public Boolean tempoDeAtendimento(){
        if(tempoCarro == 60){
            tempoCarro = 0;
        }
        Random random = new Random();
        int tempo  = random.nextInt(60);
        if(tempo < tempoCarro){
            tempoCarro += 20;
            return false;
        }else{
            tempoAtendimento.add(tempo);
            return true;
        }
    }

    public void valorPago(){
        if(cabine.getInicio().getTipo() == TipoVeiculo.CARRO){
            valorPagoVeiculo.add(3.00);
            valorTotal += 3.00;
        }else if(cabine.getInicio().getTipo() == TipoVeiculo.CAMINHAO){
            valorPagoVeiculo.add(10.00);
            valorTotal += 10.00;
        }else{
            valorPagoVeiculo.add(1.00);
            valorTotal += 1.00;
        }
    }

    public void relatorioVeiculo(Veiculo v){
        this.relatorioVeiculo.add(v);
    }

    public String toString() {
        String aux = "Relatorio cabine {";
        for(int i = 0; i < relatorioVeiculo.size(); i ++){
            aux = aux + "[ " + relatorioVeiculo.get(i) + ", tempo de Atendimento: " +  tempoAtendimento.get(i) + "s , Valor Pago: " +  valorPagoVeiculo.get(i) + " ]";
        }
        aux += "}";
        return aux + " Valor Total Cabine: " + valorTotal +"; \n";
    }


}
