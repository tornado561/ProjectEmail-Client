package com.EmailClient;

import com.google.gson.Gson;
import com.EmailClient.model.UserData;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import javax.swing.*;
import java.io.IOException;



public class Main extends GUI {


    static void exampleHttpClientForPostMethod(String recipient,String title,String content) throws IOException {

        final CloseableHttpClient client = HttpClients.createDefault();
        final HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/email/send");

        Gson gson = new Gson();

        UserData uR = new UserData(recipient,title,content);

        // Serializacja obiektu do JSONa
        final String json = gson.toJson(uR);



            final StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            final CloseableHttpResponse response = client.execute(httpPost);

            System.out.println("Kod odpowiedzi serwera: " + response.getStatusLine().getStatusCode());

                JFrame frame = new JFrame();
              if(response.getStatusLine().getStatusCode()==200) {
                  JOptionPane.showMessageDialog(frame,
                          "Message Send Succesfully");
              }
              else
              {
                  JOptionPane.showMessageDialog(frame,
                          "Wrong Address",
                          "Request Error",
                          JOptionPane.ERROR_MESSAGE);
              }


        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {


        System.out.println("Test metody POST: \n");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
        System.out.println();
    }
}
