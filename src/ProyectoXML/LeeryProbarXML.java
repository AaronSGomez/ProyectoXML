package ProyectoXML;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LeeryProbarXML {
    public static void main(String[] args) {
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
                    String[] respuestas=new String[3];
                    respuestas[0] = Opcion1.getTextContent();
                    respuestas[1] = Opcion2.getTextContent();
                    respuestas[2] = Opcion3.getTextContent();

                    // Obtener Respuesta correcta
                    String respuesta = Pregunta.getElementsByTagName("RespuestaCorrecta").item(0).getTextContent();

                    // Mostrar por consola
                    System.out.println("Pregunta "+ (i+1) +": ");
                    System.out.println(Enunciado);
                    for(int j=0;j<respuestas.length;j++){
                        System.out.println("Opcion "+ (j+1) +" : " + respuestas[j]);
                    }
                    System.out.println("-----------------------------");
                    System.out.println("  Respuesta :" + respuesta);
                    System.out.println("-----------------------------");
                }



            }




        }catch (Exception e){}
    }


}



