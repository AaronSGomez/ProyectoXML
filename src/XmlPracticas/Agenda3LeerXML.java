package XmlPracticas;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

    public class Agenda3LeerXML {
        public static void main(String[] args) {
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(new File("agenda3.xml"));

                // Normalizar
                doc.getDocumentElement().normalize();

                // Obtener la lista de nodos "Contacto"
                NodeList listaContactos = doc.getElementsByTagName("Contacto");

                for (int i = 0; i < listaContactos.getLength(); i++) {
                    Node nodoContacto = listaContactos.item(i);

                    if (nodoContacto.getNodeType() == Node.ELEMENT_NODE) {
                        Element contacto = (Element) nodoContacto;

                        // Obtener nombre
                        String nombre = contacto.getElementsByTagName("Nombre").item(0).getTextContent();

                        // Obtener teléfono y atributo
                        Element telefono = (Element) contacto.getElementsByTagName("Teléfono").item(0);
                        String numeroTelefono = telefono.getTextContent();
                        String codigoPais = telefono.getAttribute("codigoPais");

                        // Obtener email
                        String email = contacto.getElementsByTagName("EMail").item(0).getTextContent();

                        // Mostrar por consola
                        System.out.println("Contacto:");
                        System.out.println("  Nombre: " + nombre);
                        System.out.println("  Teléfono: +" + codigoPais + " " + numeroTelefono);
                        System.out.println("  Email: " + email);
                        System.out.println("-----------------------------");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


