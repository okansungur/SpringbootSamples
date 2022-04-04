package com.example.camelquarkus.route;


import com.example.camelquarkus.entity.Student;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import java.util.List;

public class StudentListRoute extends RouteBuilder {

    public static final String MEDIA_TYPE_APP_JSON = "application/json";

    @Override
    public void configure() throws Exception {

        rest("/student")
                .bindingMode(RestBindingMode.json)
                .post()
                .type(Student.class)
                .outType(Student.class)
                .consumes(MEDIA_TYPE_APP_JSON)
                .produces(MEDIA_TYPE_APP_JSON)
                .route()
                .routeId("save-student-route")
                .log("saving students")
                .to("jpa:" + Student.class.getName())
                .endRest()
                .get()
                .outType(List.class)
                .produces(MEDIA_TYPE_APP_JSON)
                .route()
                .routeId("list-student-route")
                .log("listing students")
                .to("jpa:" + Student.class.getName()+ "?query={{query}}")
                .endRest();

    }
}
//curl -H "ContentType: application/json" -X POST "http://localhost:8080/student" -d "{ \"phone\": \"132456\",\"name\": \"Emma Keen\", \"email\": \"emma@gmail.com\"}"