package com.github.phfbueno.encurtadorurl.Entity;

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
public class Url {

    @Id
    private String id;

    private String UrlOrinal;

    private LocalDateTime timeExpires;

    public Url(String id, String urlOrinal, LocalDateTime timeExpires) {
        this.id = id;
        this.UrlOrinal = urlOrinal;
        this.timeExpires = timeExpires;
    }

    public String getId() {
        return id;
    }

    public String getUrlOrinal() {
        return UrlOrinal;
    }

    public LocalDateTime getTimeExpires() {
        return timeExpires;
    }
}
