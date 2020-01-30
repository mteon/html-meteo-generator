import java.io.*;

public class HTMLGenerator {
    public static void main (String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("src/meteo.data"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("page.html"));
        String line;

        writer.write("<!DOCTYPE html> <html> <head> <meta charset = \"utf-8\">" +
                " <title> la metéo </title> </head> <body> <table>");
        writer.write("<thread><th>Année</th><th>J</th><th>F</th><th>M</th><th>A</th><th>M</th><th>J</th>" +
                "<th>J</th><th>A</th><th>S</th><th>O</th><th>N</th><th>D</th></thread>");
        while (null != (line = reader.readLine())) {
            String tokens[] = line.split("\t");
            int temperature = Integer.parseInt(tokens[2]);
            String classe;
                if(temperature<=0){
                    classe = "very-cold";
                } else if (temperature<=10) {
                    classe = "cold";
                } else if (temperature<=20) {
                    classe = "warm";
                } else if (temperature<=30) {
                    classe = "hot";
                } else if (temperature>=30) {
                    classe = "very-hot";
                }

            if (tokens[1].equals("1")) {
                writer.write("<tr><td>" + tokens[0] + "</td><td>" + tokens[2] + "</td>");
            } else if (tokens[1].equals("12")) {
                writer.write("<td>" + tokens[2] + "</td></tr>");
            } else {
                writer.write("<td>" + tokens[2] + "</td>");
            }
        }
        reader.close();
        writer.write( "</table>" +
                            "</body>" +
                            "</html>");
        writer.close();
    }
}
