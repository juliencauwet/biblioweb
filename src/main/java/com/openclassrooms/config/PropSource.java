package com.openclassrooms.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.util.Properties;

public class PropSource {

    private static final Logger log = LoggerFactory.getLogger(PropSource.class);


    Properties prop = new Properties();
    InputStream input = null;
    OutputStream output = null;


    public PropSource() {

    }

    public Properties getProp() {

        try

        {
            input = new FileInputStream("/Users/julien/IdeaProjects/biblioweb/src/main/resources/config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("extension-duration"));


        } catch (
                IOException ex)

        {
            ex.printStackTrace();
        } finally

        {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return prop;

    }

    public void setProp(String extDur, String borDur){
        try {

            output = new FileOutputStream("/Users/julien/IdeaProjects/biblioweb/src/main/resources/test.properties");

            // set the properties value
            prop.setProperty("extension-duration", extDur);
            prop.setProperty("borrowing-duration", borDur);

            // save properties to project root folder
            prop.store(output, null);
            log.info("fichier créé");

        } catch (IOException io) {
            io.printStackTrace();
        }
        finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}



