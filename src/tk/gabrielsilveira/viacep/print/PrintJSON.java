package tk.gabrielsilveira.viacep.print;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tk.gabrielsilveira.viacep.model.Address;

import java.io.FileWriter;
import java.io.IOException;

public class PrintJSON {

    public void printJson(Address address) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter writer = new FileWriter(address.cep() + ".json");
        writer.write(gson.toJson(address));
        writer.close();
    }
}
