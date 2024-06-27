package com.ttak.app.employee;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.io.Resources;
import com.ttak.app.model.Employees;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonUtils {

    private final ObjectMapper mapper;
    private static final Logger LOGGER = Logger.getLogger(JsonUtils.class.getName());

    public JsonUtils() {
        this.mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
    }

    /**
     * Reads JSON content from a file.
     *
     * @param fileName the name of the file
     * @return the JSON content as a string
     * @throws IOException if there is an error reading the file
     */
    public String readJsonFromFile(String fileName) throws IOException {
        URL url = Resources.getResource(fileName);
        try {
            return Resources.toString(url, StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading JSON file", e);
            throw e;
        }
    }

    /**
     * Parses JSON content into an Employees object.
     *
     * @param jsonString the JSON content as a string
     * @return the Employees object
     * @throws JsonProcessingException if there is an error processing the JSON content
     */
    public Employees parseEmployeesFromJson(String jsonString) throws JsonProcessingException {
        try {
            return mapper.readValue(jsonString, Employees.class);
        } catch (JsonProcessingException e) {
            LOGGER.log(Level.SEVERE, "Error parsing JSON content", e);
            throw e;
        }
    }
}
