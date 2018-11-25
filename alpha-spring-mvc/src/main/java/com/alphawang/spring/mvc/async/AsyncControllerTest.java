package com.alphawang.spring.mvc.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;

@Slf4j
public class AsyncControllerTest {

    public static void main(String[] args) {
        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();

        ListenableFuture<ResponseEntity<String>> future = 
            asyncRestTemplate.getForEntity("http://localhost:8080/api/async", String.class);
   
        future.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {
            @Override 
            public void onFailure(Throwable throwable) {
                log.error(" ==== async response error", throwable);
            }

            @Override 
            public void onSuccess(ResponseEntity<String> stringResponseEntity) {
                log.error(" ==== async api success: {}", stringResponseEntity.getBody());
            }
        });
        
        log.error(" <<<< Future END.");
    }
}
