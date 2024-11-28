//package com.example.demo;
//
//import java.io.IOException;
//import java.net.http.HttpClient;
//
//import org.springframework.http.client.reactive.ReactorClientHttpConnector;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import com.example.demo.Entity.Book;
//
//import reactor.netty.transport.logging.AdvancedByteBufFormat;
//
//public class Transfer {
//	public static void main(String[] args) throws IOException {
//		
//		//get call
////		RestTemplate rest=new RestTemplate();
////		ResponseEntity<String> response=rest.getForEntity("http://localhost:8088/book/1", String.class);
////		System.out.println(response.getBody().toString());
//		
//		HttpClient httpClient = HttpClient.create()
//	            .wiretap("reactor.netty.http.client.HttpClient",
//	                io.netty.handler.logging.LogLevel.INFO, // Log level: INFO
//	                AdvancedByteBufFormat.TEXTUAL);         // Human-readable format
//		
//		WebClient webClient=WebClient.builder()
//				.baseUrl("http://localhost:8088/")
//				.clientConnector(new ReactorClientHttpConnector(httpClient))
//	            .build();
//		
//		
//		Book book=new Book("NET Core in Action","sai krishna","978-1-61729-427-3",288,2018);
//		//update using post call
//		Book updatedBook=webClient.post()
//				.uri("books")
//				//.body(Mono.just(book),Book.class)
//				.headers((headers)->headers.add("a", ""))
//				.retrieve()
//				.bodyToMono(Book.class)
//				.block();
//		System.out.println("updated book "+updatedBook);
//		
//		
//	}
//	
//
//}
