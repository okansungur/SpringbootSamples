package com.example.webflux;

import com.example.webflux.entity.Student;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SampleClient {

    public void call() {
        WebClient client = WebClient.create("http://localhost:7895");

        String response = client.get()
                .uri("/students")
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setBasicAuth("admin", "123"))
                .retrieve()
                .bodyToMono(String.class)
                .block();
        System.out.println(response);
        Mono<Student> monoStudent = client.get()
                .uri("/students/{id}", "3")
                .headers(headers -> headers.setBasicAuth("admin", "123"))
                .retrieve()
                .bodyToMono(Student.class);
        Student responseMono = monoStudent.block();

        System.out.println("Mono Response " + responseMono);

        Flux<Student> fluxStudent = client.get()
                .uri("/students/getAll")
                .headers(headers -> headers.setBasicAuth("admin", "123"))
                .retrieve()
                .bodyToFlux(Student.class);
        System.out.println("Flux Response ");
        fluxStudent.subscribe(System.out::print);

    }

}
