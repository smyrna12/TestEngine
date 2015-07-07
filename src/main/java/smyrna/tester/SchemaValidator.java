package smyrna.tester;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Erdem.Akdogan on 6/4/15
 */
public class SchemaValidator {

    public String validate(URL schemaFile, Source xmlToCheck) throws SchemaException {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            javax.xml.validation.Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            String errorLog = "";
            try {
                validator.validate(xmlToCheck);
                return errorLog;
            } catch (SAXException e) {
                errorLog = e.getMessage();
            }

            return errorLog;
        } catch (SAXException ex) {
            throw new SchemaException("Error during schema validation", ex);
        } catch (IOException ex) {
            throw new SchemaException("Error during schema validation", ex);
        }
    }

    public class SchemaException extends Exception {
        public SchemaException(String message, Exception ex) {
            super(message, ex);
        }
    }
}
