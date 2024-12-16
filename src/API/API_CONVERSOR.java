package API;

import RecordsConversor.Moneda;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API_CONVERSOR {

    private String api_url="https://v6.exchangerate-api.com/v6/917684daff275e56231d0c52/pair";

    public Moneda buscarTasas(String origen,String destino){

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(api_url+"/"+origen+"/"+destino))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request,HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(),Moneda.class);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    };

}
