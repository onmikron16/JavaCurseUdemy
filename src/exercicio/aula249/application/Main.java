package exercicio.aula249.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,Integer> votes = new LinkedHashMap<>();

        String path = "E:\\Udemy\\IN.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String lines = br.readLine();

            while (lines != null){

                String[] fields = lines.split(",");
                String name = fields[0];
                int count = Integer.parseInt(fields[1]);

                if (votes.containsKey(name)) {
                    int votesSoFar = votes.get(name);
                    votes.put(name, count + votesSoFar);
                }else {
                    votes.put(name, count);
                }


                lines = br.readLine();
            }

            for(String voto : votes.keySet()){
                System.out.println(votes.keySet() + ", " + votes.get(voto));
            }

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
