package com.example.demo;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.Entity.Book;

import reactor.core.publisher.Mono;

public class Transfer {
	public static void main(String[] args) throws IOException {
		
		//get call
//		RestTemplate rest=new RestTemplate();
//		ResponseEntity<String> response=rest.getForEntity("http://localhost:8088/book/1", String.class);
//		System.out.println(response.getBody().toString());
		
		WebClient webClient=WebClient.builder().baseUrl("http://localhost:8088/").build();
//		String response2=webClient.get().uri("/book/1").retrieve().bodyToMono(String.class).block();
//		System.out.println(response2);
		
		HttpHeaders headers=new HttpHeaders();
		
		Book book=new Book("NET Core in Action","sai krishna","978-1-61729-427-3",288,2018);
		//update using post call
		Book updatedBook=webClient.post()
				.uri("books")
				.body(Mono.just(book),Book.class)
				.headers((header)->header.addAll(headers))
				.retrieve()
				.bodyToMono(Book.class)
				.block();
		System.out.println("updated book "+updatedBook);
		
		
	}

}



/*

-- disable logging --
logging.level.org.springframework.web.reactive.function.client=OFF
logging.level.reactor.netty.http.client=OFF


import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

public class WebClientWithInterceptors {
    public static void main(String[] args) {
        // Create a WebClient with interceptors
        WebClient webClient = WebClient.builder()
            .baseUrl("https://api.example.com")
            .filter(logRequest()) // Add request interceptor
            .filter(logResponse()) // Add response interceptor
            .build();

        // Example POST request
        String response = webClient.post()
            .uri("/endpoint")
            .bodyValue(new MyRequestBody("value1", "value2"))
            .retrieve()
            .bodyToMono(String.class)
            .block();

        System.out.println("Response: " + response);
    }

    // Interceptor to log requests
    private static ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            System.out.println("Request: " + clientRequest.method() + " " + clientRequest.url());
            clientRequest.headers().forEach((name, values) -> 
                values.forEach(value -> System.out.println(name + ": " + value))
            );
            return Mono.just(clientRequest);
        });
    }

    // Interceptor to log responses
    private static ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            System.out.println("Response status: " + clientResponse.statusCode());
            return Mono.just(clientResponse);
        });
    }

    // Request body class
    static class MyRequestBody {
        private String field1;
        private String field2;

        public MyRequestBody(String field1, String field2) {
            this.field1 = field1;
            this.field2 = field2;
        }

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }
    }
}

*/
