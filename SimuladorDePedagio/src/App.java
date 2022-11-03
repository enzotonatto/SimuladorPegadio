import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void veiculoCabine(Cabine cabine){
            Random random = new Random();
            int chance  = random.nextInt(99);
            if(chance >=50){
            Veiculo v = Veiculo.gerarNovoVeiculo();
            cabine.entraNaCabine(v);
            }       
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<Cabine> pedagio = new ArrayList<>();

        ArrayList<Atendimento> atendimentos = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            Cabine c = new Cabine();
            Atendimento a = new Atendimento(c);
            pedagio.add(c);
            atendimentos.add(a);
        }
        
        int hora = 0;

        while(hora<50){
            for(int i = 0; i < 5; i ++){
                Cabine aux = pedagio.get(i);

                veiculoCabine(aux);
                System.out.println("cabines: " + aux);
                
                if(aux.getTamanho() == 0){

                }else{
                    atendimentos.get(i).removeCarro();
                }
            }
            System.out.println("Digite 'y' para continuar: ");
            String letra = sc.next().toLowerCase();

            System.out.println("Atendimentos: "+atendimentos);

            hora++;
        } 

        System.out.println("Fim do dia!");
    }
}
