package ProyectoXML;

import java.util.ArrayList;
import java.util.Scanner;

public class JuegoApp {
    public static void main(String[] args) {
        CrearCuestionario cuestionario = new CrearCuestionario();
        ArrayList<Pregunta> preguntas = new ArrayList(cuestionario.Cuestionario15Preguntas());
        Scanner sc = new Scanner(System.in);
        int opcion;
        int puntos=0;
        System.out.println("Total de preguntas del XML: "+ cuestionario.getTotalpreguntas());

        for( Pregunta pre : preguntas){
            pre.mostrarInfo();
            System.out.println("Introduce tu respuesta: ");
            opcion= sc.nextInt();
            puntos+= pre.comprobarSolucion(opcion);

        }

        System.out.println("Tu Puntuacion es " + puntos);
        if(puntos==150){
            System.out.println("Eres un autentico profesional");
        }else if(puntos<150 && puntos>100 ){
            System.out.println("Eres un entendido de juegos");
        } else if (puntos<100 && puntos>50) {
            System.out.println("Necesitas Practicar");
        }else{
            System.out.println("Eres un manta");
        }
    }
}
