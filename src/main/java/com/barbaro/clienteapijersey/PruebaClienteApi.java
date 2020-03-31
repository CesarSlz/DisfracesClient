
package com.barbaro.clienteapijersey;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PruebaClienteApi {
    
   public static final String URI_BASE = "http://localhost:8080/ApiDisfraces/api/";
    
    public static void main(String[] args) {
        
        // Crear una instancia que permitira realizar una peticion HTTP
        Client client = ClientBuilder.newClient();
        
        // Indicando la direccion a donde se a va dirigir la peticion
        WebTarget target = client.target(URI_BASE);
        WebTarget targetDisfraz = target.path("partes");
        
        // Configurar peticion que responde un MIME type JSON
        // Obtener peticion
        Invocation.Builder request = targetDisfraz.request(MediaType.APPLICATION_JSON_TYPE);
        
        // Obtener la respuesta de la peticion de tipo GET
        Response response = request.get();
        
        // Procesar respuesta para convertirla a JSON
        String jsonResponse = response.readEntity(String.class);
        
        System.out.println(jsonResponse);
    }
}
