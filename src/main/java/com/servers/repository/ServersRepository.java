package com.servers.repository;

import java.util.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.servers.model.Servers;


public interface ServersRepository extends MongoRepository<Servers, Integer>{

}
