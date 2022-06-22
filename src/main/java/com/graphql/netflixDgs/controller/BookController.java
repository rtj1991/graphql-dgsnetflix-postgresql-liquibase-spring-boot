package com.graphql.netflixDgs.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.graphql.dgs.client.GraphQLClient;
import com.netflix.graphql.dgs.client.GraphQLResponse;
import com.netflix.graphql.dgs.client.HttpResponse;
import com.netflix.graphql.dgs.client.RequestExecutor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {

    @RequestMapping("hello")
    public String hellow(){
        return "Hello World";
    }

    @PostMapping("/all_book")
    public String getAllBooks(@RequestBody String id){
        String result="";
        RequestExecutor executor=(url,header,body)->{
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            header.forEach(httpHeaders::addAll);
            ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(body, httpHeaders), String.class);

            return new HttpResponse(exchange.getStatusCodeValue(),exchange.getBody(),exchange.getHeaders());
        };
        GraphQLClient client=GraphQLClient.createCustom("http://localhost:8080/graphql",executor);
        GraphQLResponse response = client.executeQuery(id);
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(response.getJson());
            result = jsonNode.get("data").get("allBooks").toString();
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
