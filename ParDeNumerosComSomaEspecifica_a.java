import java.util.ArrayList;
import java.util.List;
 
public class ParDeNumerosComSomaEspecifica_a {
 
    public static void main(String[] args) {
        // Exemplo de uma lista de números
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            nums.add((int) (Math.random() * 100000)); // Preenchendo com números aleatórios 
        }
        int target = 50000; // Soma alvo
        //estou com sono
        long startTime = System.currentTimeMillis();
        List<int[]> pares = encontrarPares(nums, target);
        long endTime = System.currentTimeMillis();
 
        System.out.println("Número de pares encontrados: " + pares.size());
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");


        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                List<List<Integer>> listaDePares = new ArrayList<>();

                // Adicionando pares à lista
                List<Integer> par1 = new ArrayList<>();
                par1.add(1);
                par1.add(100);
            }
        }



    }


 
    public static List<int[]> encontrarPares(List<Integer> nums, int target) {
        long tempoInicial = System.nanoTime();
        List<int[]> pares = new ArrayList<>();
        // Algoritmo não otimizado: verificar todos os pares possíveis
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) == target) {
                    pares.add(new int[] { nums.get(i), nums.get(j) });
                }
            }
        }
        
        long tempoFinal = System.nanoTime();
        long tempoTotal = tempoFinal - tempoInicial;
        System.out.println("Tempooooo: " + tempoTotal);
        return pares;
    }
}