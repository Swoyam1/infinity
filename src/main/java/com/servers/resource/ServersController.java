package com.servers.resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.servers.model.Servers;
import com.servers.repository.ServersRepository;

@RestController


public class ServersController {
    @Autowired
    private ServersRepository repository;


    @PostMapping("/addServer")
    public String saveServer(@RequestBody Servers server) {
        repository.save(server);
        return "Added server with id : " + server.getId();
    }

    @GetMapping("/findAllServers")
    public List<Servers> getServers() {
        return repository.findAll();
    }

    @GetMapping("/findAllServers/{id}")
    public Optional<Servers> getServer(@PathVariable int id) {
        Optional<Servers> server=repository.findById(id);
        if(server.isPresent()){
            return repository.findById(id);

        }
        else{
            throw new ServerNotFoundException("Object of id-"+id+" not found");

        }
    }


    @DeleteMapping("/delete/{id}")
    public String deleteServer(@PathVariable int id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Server deleted with id : " + id;
        }else{
            throw new ServerNotFoundException("Object - "+id+" not found");
        }

    }
}
