package com.example.files.documents.model;

import com.example.files.documents.view.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "document")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;

    @JsonView(Views.Public.class)
    @Column(name = "filename")
    private String fileName;

    @JsonView(Views.customHash.class)
    @Column(name = "hash-sha-256")
    private String hashSha256;

    @JsonView(Views.customHash.class)
    @Column(name = "hash-sha-512")
    private String hashSha512;

    @JsonView(Views.Public.class)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastupload")
    private LocalDateTime lastUpload;

    @JsonView(Views.globalHash.class)
    @Transient
    private String hash;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getHashSha256() {
        return hashSha256;
    }

    public void setHashSha256(String hashSha256) {
        this.hashSha256 = hashSha256;
    }

    public String getHashSha512() {
        return hashSha512;
    }

    public void setHashSha512(String hashSha512) {
        this.hashSha512 = hashSha512;
    }

    public LocalDateTime getLastUpload() {
        return lastUpload;
    }

    public void setLastUpload(LocalDateTime lastUpload) {
        this.lastUpload = lastUpload;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
