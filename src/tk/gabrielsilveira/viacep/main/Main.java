package tk.gabrielsilveira.viacep.main;

import com.google.gson.JsonSyntaxException;
import tk.gabrielsilveira.viacep.model.Address;
import tk.gabrielsilveira.viacep.search.SearchCEP;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner reader = new Scanner(System.in);
        SearchCEP searchCEP = new SearchCEP();

        System.out.println("Digite o número do CEP que deseja procurar: ");
        var cep = reader.nextLine();

        try{
            Address address = searchCEP.searchAddress(cep);
            System.out.println(address);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando o programa!");
        }
    }
}
