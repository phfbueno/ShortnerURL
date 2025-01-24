package com.github.phfbueno.EncurtadorURL.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "url")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Url {

    @Id
    private String id;

    private String UrlOrinal;

    private LocalDateTime timeExpires;
}
