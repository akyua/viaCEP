package tk.gabrielsilveira.viacep.model;

public record Address(String cep, String logradouro, String complemento, String localidade, String bairro, String uf) {
}
