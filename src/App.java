import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import models.Candidato;
import models.Sort;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<Candidato> listaCandidatos = new ArrayList<>();

        try{
            List<String> linhas = Files.readAllLines(Paths.get("dados.csv"));

            for(String linha : linhas){
                String[] informacoes = linha.split(",");
                listaCandidatos.add(new Candidato(informacoes[0], Double.parseDouble(informacoes[1])));
            }
            
        } catch(IOException e){
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        Candidato[] arrayCandidatos = listaCandidatos.toArray(new Candidato[0]);

        Sort quickSort = new Sort<>();

        quickSort.sort(arrayCandidatos);

        for (Candidato c : arrayCandidatos)
            System.out.println(c);
        
        
    }
}
