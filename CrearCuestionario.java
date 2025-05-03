package ProyectoXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class CrearCuestionario {
    ArrayList<Pregunta> preguntas;
    private int totalpreguntas;

    public CrearCuestionario() {
        preguntas = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("quiz.xml"));

            // Normalizar
            doc.getDocumentElement().normalize();

            NodeList listaPreguntas = doc.getElementsByTagName("Pregunta");
            for (int i = 0; i < listaPreguntas.getLength(); i++) {
                //creamos nodo pregunta
                Node nodoPregunta = listaPreguntas.item(i);

                if (nodoPregunta.getNodeType() == Node.ELEMENT_NODE) {
                    Element Pregunta = (Element) nodoPregunta;

                    // Obtener Enunciado
                    String Enunciado = Pregunta.getElementsByTagName("Enunciado").item(0).getTextContent();

                    // Obtener respuestas
                    Element Opcion1 = (Element) Pregunta.getElementsByTagName("Opcion1").item(0);
                    Element Opcion2 = (Element) Pregunta.getElementsByTagName("Opcion2").item(0);
                    Element Opcion3 = (Element) Pregunta.getElementsByTagName("Opcion3").item(0);
                    String[] respuestas = new String[3];
                    respuestas[0] = Opcion1.getTextContent();
                    respuestas[1] = Opcion2.getTextContent();
                    respuestas[2] = Opcion3.getTextContent();

                    // Obtener Respuesta correcta
                    String respuesta = Pregunta.getElementsByTagName("RespuestaCorrecta").item(0).getTextContent();

                    Pregunta quiz= new Pregunta(Enunciado, respuestas, respuesta);
                    preguntas.add(quiz);
                }
                totalpreguntas=preguntas.size();
                }
            }catch(Exception e){
                e.printStackTrace();
            }

    }

    public ArrayList<Pregunta> Cuestionario15Preguntas() {
        ArrayList<Pregunta> arrayListJuego = new ArrayList<>();
        Random random = new Random();
        while (arrayListJuego.size() < 15) {
            // Obtener un índice aleatorio
            int indiceAleatorio = random.nextInt(preguntas.size());

            // Obtener el elemento correspondiente y agregarlo si aún no está en la listaAleatoria
            Pregunta elemento = preguntas.get(indiceAleatorio);
            if (!arrayListJuego.contains(elemento)) {
                arrayListJuego.add(elemento);
            }

        }
        return arrayListJuego;
    }

    //total preguntas
    public int getTotalpreguntas() {
        return totalpreguntas;
    }
}
