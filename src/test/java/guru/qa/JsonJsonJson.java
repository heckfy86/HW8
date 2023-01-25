package guru.qa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.ArrayList;


import static org.assertj.core.api.Assertions.assertThat;

public class JsonJsonJson {

    ObjectMapper objectMapper = new ObjectMapper();
    @Test
    void jsonFileToPojo() throws IOException {
        File file = new File("src/test/resources/example.json");

        Employee employee = objectMapper.readValue(file, Employee.class);


        assertThat(employee.getName().equals("Pankaj Kumar"));
        assertThat(employee.getAddress().getCity().equals("San Jose"));
        assertThat(employee.getPhoneNumbers().get(0).equals("9988664422"));

    }


    @Test
    void pojoToJsonString() throws JsonProcessingException {

        Address addressEmployee2 = new Address( "Leninskaya", "Samara", 443031 );
        Employee employee2 = new Employee(2, "James", true, addressEmployee2,
                new ArrayList<String>() {{ add("89376431608"); }} ,"Developer");
        String json = objectMapper.writeValueAsString(employee2);
        try {

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("src/test/resources/example_2.json"), employee2);
        } catch (IOException e) {
            e.printStackTrace();
        }
         System.out.println(json);
    }

}
