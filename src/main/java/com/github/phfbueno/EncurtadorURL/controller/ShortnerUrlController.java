package com.github.phfbueno.EncurtadorURL.controller;

import com.github.phfbueno.EncurtadorURL.dto.ShortnerUrlRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortnerUrlController {

    @PostMapping(value = "/shortner-url")
    public ResponseEntity<Void> shortnerURL(@RequestBody ShortnerUrlRequest shortnerUrlRequest) {



            return ResponseEntity.ok().build();
    }
}
