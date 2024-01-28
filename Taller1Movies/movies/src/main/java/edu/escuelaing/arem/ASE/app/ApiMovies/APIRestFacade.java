package edu.escuelaing.arep.taller1.Facade;

import java.net.*;
import java.io.*;

public class APIRestFacade {

    // private static final String USER_AGENT = "Mozilla/5.0";
    private static final String MOVIE_URL = "https://www.omdbapi.com/?i=tt3896198&apikey=12135def";

    /**
     * Search for a specific movie by name on a external API
     * 
     * @param name name of the movie to search
     * @return a string with all data about the movie
     */
    public String searchMovie(String name) throws IOException {
        URL obj = new URL(MOVIE_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        // con.setRequestProperty("User-Agent", USER_AGENT);

        String finalResponse = "";

        // The following invocation perform the connection implicitly before getting the
        // code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            finalResponse = response.toString();
            // print result
            System.out.println(finalResponse);
        } else {
            return "la peticion no se pudo realizar";
        }
        return finalResponse;
    }
}
