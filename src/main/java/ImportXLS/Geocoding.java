package ImportXLS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import Dao.DAOocorrenciaRepository;
import org.json.JSONArray;
import org.json.JSONObject;

public class Geocoding {

    public static void main(String[] args) throws Exception {
        DAOocorrenciaRepository daOocorrenciaRepository  = new DAOocorrenciaRepository();

        List<ModelOcorrencia> coordenadasList = new ArrayList<ModelOcorrencia>();

        try {
            List<ModelOcorrencia> ocorrenciaList = daOocorrenciaRepository.buscarEnd(); // Endereço que você quer transformar em coordenadas

            for (ModelOcorrencia ocorrencia : ocorrenciaList) {
                String endereco = ocorrencia.getEndereco();
                String coordenadas = obterCoordenadas(endereco);

                String[] coordenadasArray = coordenadas.split(",");
                String latitude = coordenadasArray[0];
                String longitude = coordenadasArray[1];
                ocorrencia.setLatitude(Double.parseDouble(latitude));
                ocorrencia.setLongitude(Double.parseDouble(longitude));
                coordenadasList.add(ocorrencia);
                System.out.println("Coordenadas: " + coordenadas);
            }

            daOocorrenciaRepository.gravarCoordenadas(coordenadasList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String obterCoordenadas(String endereco) throws IOException {
        String enderecoCodificado = URLEncoder.encode(endereco, "UTF-8");
        String urlStr = "https://nominatim.openstreetmap.org/search?format=json&q=" + enderecoCodificado;

        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Analisar a resposta JSON para obter as coordenadas
        // Usando a biblioteca org.json para análise JSON
        JSONArray jsonArray = new JSONArray(response.toString());
        if (jsonArray.length() > 0) {
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String lat = jsonObject.getString("lat");
            String lon = jsonObject.getString("lon");
            return lat + ", " + lon;
        } else {
            String lat = String.valueOf(-22.78027492891333);
            String lon = String.valueOf(-47.30021359681899);
            return lat + ", " + lon;
            //-22.78027492891333, -47.30021359681899 coordenadas HM Nova Odessa.
        }
    }
}
