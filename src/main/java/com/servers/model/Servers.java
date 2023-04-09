package com.servers.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

@Document(collection = "servers")
public class Servers {
    @Id
    private int id;
    private String serverName;
    private String serverLanguage;
    private String serverFramework;

}
