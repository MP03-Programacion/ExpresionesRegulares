package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        /*conExpresionesRegulares();*/
        /*sinExpresionesRegulares();*/

    }

    private static void sinExpresionesRegulares() throws IOException {

        BufferedReader br = null;
        br = new BufferedReader(new FileReader("D:\\txt.txt"));
        String texto = br.readLine();

        String papaNoel = "*<]:-DOo";
        String reno = ">:o)";
        String folleti = "<]:-D";

        int hayPapaNoel;
        int hayReno;
        int hayFolleti;

        while (texto != null) {

            hayPapaNoel = 0;
            hayReno = 0;
            hayFolleti = 0;

            if (texto.contains(papaNoel)) {
                hayPapaNoel++;
                hayFolleti = 0;
            } else if (texto.contains(folleti)) {
                hayFolleti++;
            }

            if (texto.contains(reno)) {
                hayReno++;
            }

            System.out.println("Papa Noel: " + hayPapaNoel + " Reno: " + hayReno + " Folleti: " + hayFolleti);
            texto = br.readLine();
        }

    }

    private static void conExpresionesRegulares() throws IOException {

        BufferedReader br = null;
        br = new BufferedReader(new FileReader("D:\\txt.txt"));
        String texto = br.readLine();

        Pattern papaNoel = Pattern.compile("\\*<]:-DOo");
        Pattern reno = Pattern.compile(">:o\\)");
        Pattern folleti = Pattern.compile("<]:-D");

        int hayPapaNoel;
        int hayReno;
        int hayFolleti;

        while (texto != null) {

            hayPapaNoel = 0;
            hayReno = 0;
            hayFolleti = 0;

            Matcher matcherPapaNoel = papaNoel.matcher(texto);
            Matcher matcherReno = reno.matcher(texto);
            Matcher matcherFolleti = folleti.matcher(texto);

            while (matcherPapaNoel.find()){
                hayPapaNoel++;
            }

            if (hayPapaNoel != 0 ) {
                System.out.print("Papa Noel (" + hayPapaNoel + ") ");
                hayFolleti = 0;
            }

            while (matcherReno.find()){
                hayReno++;
            }

            if (hayReno != 0 ) {
                System.out.print("Renos (" + hayReno + ")");
            }

            while (matcherFolleti.find()){
                hayFolleti++;
            }

            if (hayFolleti != 0 && hayPapaNoel == 0) {
                System.out.print("Follet (" + hayFolleti + ")");
            }

            System.out.println("");
            texto = br.readLine();

        }

    }

}
