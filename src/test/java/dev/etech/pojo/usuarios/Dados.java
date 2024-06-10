package dev.etech.pojo.usuarios;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    @JsonIgnore
    private Map<String,Object> additionProperties = new HashMap<>();

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

    public Map<String, Object> getAdditionProperties() {
        return additionProperties;
    }
    @JsonAnySetter
    public void setAdditionProperties(String key, Object value ) {
        this.additionProperties = additionProperties;
    }
}