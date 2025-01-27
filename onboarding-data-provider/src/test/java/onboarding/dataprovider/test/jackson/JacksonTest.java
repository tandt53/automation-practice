package onboarding.dataprovider.test.jackson;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JacksonTest {
    public static void main(String args[]) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = "{\n" +
                    "  \"id\": 123,\n" +
                    "  \"name\": \"Pankaj\",\n" +
                    "  \"permanent\": true,\n" +
                    "  \"address\": {\n" +
                    "    \"street\": \"Albany Dr\",\n" +
                    "    \"city\": \"San Jose\",\n" +
                    "    \"zipcode\": 95129\n" +
                    "  },\n" +
                    "  \"phoneNumbers\": [\n" +
                    "    123456,\n" +
                    "    987654\n" +
                    "  ],\n" +
                    "  \"role\": \"Manager\",\n" +
                    "  \"cities\": [\n" +
                    "    \"Los Angeles\",\n" +
                    "    \"New York\"\n" +
                    "  ],\n" +
                    "  \"properties\": {\n" +
                    "    \"age\": \"29 years\",\n" +
                    "    \"salary\": \"1000 USD\"\n" +
                    "  }\n" +
                    "}";
            JsonNode rootNode = mapper.readTree(jsonString);

            JsonNode nameNode = rootNode.path("address.street");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}