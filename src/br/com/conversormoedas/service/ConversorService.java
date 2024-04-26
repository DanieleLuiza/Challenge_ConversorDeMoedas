package br.com.conversormoedas.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.text.NumberFormat;


import com.google.gson.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class ConversorService {

    private String url = "https://v6.exchangerate-api.com/v6/af044cc9e68e1b0e08ecb027/latest/";

    public BigDecimal converterMoeda(String primeiraMoeda, String segundaMoeda) {

        String endereco = url.concat(primeiraMoeda);

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();

            JsonObject json = gson.fromJson(responseBody, JsonObject.class);
            JsonObject conversorMoeda = json.getAsJsonObject("conversion_rates");

            return conversorMoeda.get(segundaMoeda).getAsBigDecimal();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public BigDecimal converter(BigDecimal valorOrigem, BigDecimal cotacao){
        BigDecimal resultado = BigDecimal.ZERO;
        resultado = valorOrigem.multiply(cotacao);

        return resultado;
    }

}
