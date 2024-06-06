package dev.etech.pojo.usuarios;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ultimo_acesso",
        "_id",
        "criado_em",
        "atualizado_em",
        "__v"
})
public class Dados extends UsuariosRequest {

    @JsonProperty("ultimo_acesso")
    public String ultimoAcesso;
    @JsonProperty("_id")
    public String id;
    @JsonProperty("criado_em")
    public String criadoEm;
    @JsonProperty("atualizado_em")
    public String atualizadoEm;
    @JsonProperty("__v")
    public Integer v;

    @JsonProperty("ultimo_acesso")
    public String getUltimoAcesso() {
        return ultimoAcesso;
    }
    @JsonProperty("_id")
    public String getId() {
        return id;
    }

    @JsonProperty("criado_em")
    public String getCriadoEm() {
        return criadoEm;
    }

    @JsonProperty("atualizado_em")
    public String getAtualizadoEm() {
        return atualizadoEm;
    }

    @JsonProperty("__v")
    public Integer getV() {
        return v;
    }
}