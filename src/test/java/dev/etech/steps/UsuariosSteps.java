package dev.etech.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.etech.endpoints.UsuariosEndpoint;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class UsuariosSteps {
    private UsuariosEndpoint usuariosEndpoint = new UsuariosEndpoint();
    String json;
    @Dado("que o payload possua dados de um novo usuário")
    public void que_o_payload_possua_dados_de_um_usuario() throws JsonProcessingException {
        json = usuariosEndpoint.carregaPayloadNovoUsuario();
    }

    @Quando("realizar a criação de um novo usuário")
    public void realizarACriaçãoDeUmNovoUsuário() {
    }

    @Então("deve validar  o status code {string}")
    public void deveValidarOStatusCode(String arg0) {
    }
}


