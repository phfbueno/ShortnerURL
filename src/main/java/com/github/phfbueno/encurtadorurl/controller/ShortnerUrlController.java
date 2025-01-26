package com.github.phfbueno.encurtadorurl.controller;

import com.github.phfbueno.encurtadorurl.Entity.Url;
import com.github.phfbueno.encurtadorurl.dto.ShortnerUrlRequest;
import com.github.phfbueno.encurtadorurl.dto.ShortnerUrlResponse;
import com.github.phfbueno.encurtadorurl.repository.UrlRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
public class ShortnerUrlController {


    private UrlRepository urlRepository ;

    public ShortnerUrlController(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }


    @PostMapping(value = "/shortner-url")
    public ResponseEntity<ShortnerUrlResponse> shortnerURL(@RequestBody ShortnerUrlRequest shortnerUrlRequest,
                                                           HttpServletRequest httpServletRequest) {
           String id;

            do {

                id = RandomStringUtils.randomAlphabetic(5 , 8);

            } while (urlRepository.existsById(id));

            urlRepository.save(new Url(id, shortnerUrlRequest.url(), LocalDateTime.now().plusMinutes(1)));

            var redirectUrl = httpServletRequest.getRequestURL().toString().replace("shortner-url", id);

            return ResponseEntity.ok(new ShortnerUrlResponse(redirectUrl));
    }

    @GetMapping
    public ResponseEntity<ShortnerUrlResponse> urlRedirect(@PathVariable("id") String id) {

       var urlOrting =  urlRepository.findById(id);

       if(urlOrting.isEmpty()) {
            return ResponseEntity.notFound().build();
       }

       HttpHeaders headrs = new HttpHeaders();

       headrs.setLocation(URI.create(urlOrting.get().getUrlOrinal()));

       return ResponseEntity.status(HttpStatus.FOUND).headers(headrs).build();


    }
}
