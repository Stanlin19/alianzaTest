package com.alianza.clients.controller;

import com.alianza.clients.models.dto.ClientDTO;
import com.alianza.clients.service.IClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("client")
@CrossOrigin("*")
public class ClientController {

    private final IClientService iClientService;

    public ClientController(IClientService iClientService) {
        this.iClientService = iClientService;
    }

    @GetMapping
    public List<ClientDTO> getAll(){
        return iClientService.findAll();
    }

    @GetMapping("/{sharedKey}")
    public Optional<ClientDTO> findBuId(@PathVariable String sharedKey){
        return iClientService.findBySharedKey(sharedKey);
    }

    @PostMapping
    public void save(@RequestBody ClientDTO clientDTO){
        iClientService.save(clientDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        iClientService.delete(id);
    }
}
