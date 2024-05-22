
package dev.etech.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
    "nome",
    "apelido",
    "telefone",
    "data_nascimento",
    "email",
    "senha",
    "endereco",
    "google_id"
})
public class UsuariosPOJO {

    @JsonProperty("nome")
    private String nome;
    @JsonProperty("apelido")
    private String apelido;
    @JsonProperty("telefone")
    private String telefone;
    @JsonProperty("data_nascimento")
    private String dataNascimento;
    @JsonProperty("email")
    private String email;
    @JsonProperty("senha")
    private String senha;
    @JsonProperty("endereco")
    private EnderecoPojo enderecoPojo;
    @JsonProperty("google_id")
    private String googleId;

    @JsonProperty("nome")
    public String getNome() {
        return nome;
    }

    @JsonProperty("nome")
    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonProperty("apelido")
    public String getApelido() {
        return apelido;
    }

    @JsonProperty("apelido")
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    @JsonProperty("telefone")
    public String getTelefone() {
        return telefone;
    }

    @JsonProperty("telefone")
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @JsonProperty("data_nascimento")
    public String getDataNascimento() {
        return dataNascimento;
    }

    @JsonProperty("data_nascimento")
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("senha")
    public String getSenha() {
        return senha;
    }

    @JsonProperty("senha")
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @JsonProperty("endereco")
    public EnderecoPojo getEndereco() {
        return enderecoPojo;
    }

    @JsonProperty("endereco")
    public void setEndereco(EnderecoPojo enderecoPojo) {
        this.enderecoPojo = enderecoPojo;
    }

    @JsonProperty("google_id")
    public String getGoogleId() {
        return googleId;
    }

    @JsonProperty("google_id")
    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

}
