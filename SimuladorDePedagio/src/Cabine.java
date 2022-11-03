public class Cabine {

    private Veiculo inicio;
    private Veiculo fim;
    private int tamanho;

    public Cabine(){
        this.inicio = null;
        this.fim = null;    
        tamanho = 0;
    }

    public void entraNaCabine(Veiculo v){
        if(tamanho == 0){
            this.inicio = v;
            this.fim= v;
            tamanho++;
        }else{
            Veiculo aux = fim;
            fim = v;
            aux.proximo = fim;
            fim.anterior = aux;
            tamanho++;
        }
        
    }

    public Veiculo saiDaCabine(){
        Veiculo aux = this.inicio;
        Veiculo paux = aux.proximo;
        this.inicio = paux;
        tamanho--;
        return aux;
    }

    public String carroEmAtendimento(){
        return this.inicio + "Está sendo atendido";
    }

    public Veiculo getInicio(){
        return inicio;
    }

    public Veiculo getFim(){
        return fim;
    }
    
    public int getTamanho(){
        return tamanho;
    }

    public String toString() {
        String aux = "veiculos [ ";
        Veiculo paux = inicio;
        while (paux != null) {
            aux = aux + paux + "; ";
            paux = paux.proximo; 
        }
        aux += "]";
        return aux;
    }
}
