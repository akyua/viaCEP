package tk.gabrielsilveira.viacep.search;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import tk.gabrielsilveira.viacep.model.Address;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class SearchCEP {
    public Address searchAddress(String cep) throws IOException, InterruptedException {
        URI address = URI.create("https://viacep.com.br/ws/" + cep + "/json/");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Address.class);
        } catch (IOException | InterruptedException | JsonSyntaxException e) {
            throw new RuntimeException("Não consegui obter o endereço a partir do CEP informado.");
        }


    }
}
