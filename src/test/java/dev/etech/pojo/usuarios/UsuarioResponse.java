package dev.etech.pojo.usuarios;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "mensagem",
        "dados",
        "timestamp"
})

public class UsuarioResponse {

    @JsonProperty("mensagem")
    private String mensagem;
    @JsonProperty("dados")
    private Dados dados;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("mensagem")
    public String getMensagem() {
        return mensagem;
    }

    @JsonProperty("mensagem")
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @JsonProperty("dados")
    public Dados getDados() {
        return dados;
    }

    @JsonProperty("dados")
    public void setDados(Dados dados) {
        this.dados = dados;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}