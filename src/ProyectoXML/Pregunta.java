package ProyectoXML;

import java.util.Arrays;

public class Pregunta {
    // el enunciado de la pregunta
    // tres posibles respuestas
    // solucion

    private String pregunta;
    private String[] respuestas;
    private String solucion;

    public Pregunta(String pregunta, String[] respuestas, String solucion) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
        this.solucion = solucion;
    }
    //getter y setter
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String[] respuestas) {
        this.respuestas = respuestas;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    //metodo comprobar respuesta correcta
    public int comprobarSolucion(int opcion){
        int puntos=0;
        opcion=opcion-1;
        if(respuestas[opcion].equals(solucion)){
            puntos =10;
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("Respuesta Correcta");
            System.out.println("----------------------------------------------------------------------------------");
        }       else{
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("Respuesta incorrecta");
            System.out.println("Respuesta : "+ solucion);
            System.out.println("----------------------------------------------------------------------------------");
        }
        return puntos;
    }


    //mostrar informacion
    public void mostrarInfo() {
        System.out.println("");
        System.out.println("Pregunta ");
        System.out.println(pregunta);
        for(int j=0;j<respuestas.length;j++){
            System.out.println("Opcion "+ (j+1) +" : " + respuestas[j]);
        }
    }
}
