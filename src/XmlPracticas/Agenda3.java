package XmlPracticas;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

//VAMOS A CREAR UNA AGENDA EN XML
public class Agenda3 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            //AHORA CREAMOS EL NODO RAÍZ
            Element rootElement = doc.createElement("Agenda");
            doc.appendChild(rootElement);

            //Primer elemento
            Element contacto = doc.createElement("Contacto");
            rootElement.appendChild(contacto);

            //OPCIÓN 2, SE GUARDA COMO ELEMENTOS HIJOS
            Element Nombre = doc.createElement("Nombre");
            Text texNombre = doc.createTextNode("AAA");
            Nombre.appendChild(texNombre);
            contacto.appendChild(Nombre);

            // Teléfono con atributo
            Element Telefono = doc.createElement("Teléfono");
            Attr attrPais = doc.createAttribute("codigoPais");
            attrPais.setValue("34");
            Telefono.setAttributeNode(attrPais);
            Text textTelefono = doc.createTextNode("666 666 666");
            Telefono.appendChild(textTelefono);
            contacto.appendChild(Telefono);

            Element Email = doc.createElement("EMail");
            Text textEmail = doc.createTextNode("AAAA@gmail.com");
            Email.appendChild(textEmail);
            contacto.appendChild(Email);

            //SEGUNDO ELEMENTO
            contacto = doc.createElement("Contacto");
            rootElement.appendChild(contacto);

            Nombre = doc.createElement("Nombre");
            texNombre = doc.createTextNode("BBBB");
            Nombre.appendChild(texNombre);
            contacto.appendChild(Nombre);

            // Teléfono con atributo
            Telefono = doc.createElement("Teléfono");
            attrPais = doc.createAttribute("codigoPais");
            attrPais.setValue("34");
            Telefono.setAttributeNode(attrPais);
            textTelefono = doc.createTextNode("111 111 111");
            Telefono.appendChild(textTelefono);
            contacto.appendChild(Telefono);

            Email = doc.createElement("EMail");
            textEmail = doc.createTextNode("BBBB@gmail.com");
            Email.appendChild(textEmail);
            contacto.appendChild(Email);

            //Se escribe el contenido del XML en un archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("agenda3.xml"));
            transformer.transform(source, result);
        } catch (ParserConfigurationException |TransformerException e)  {
            e.printStackTrace();
        }
        System.gc();
    }
}