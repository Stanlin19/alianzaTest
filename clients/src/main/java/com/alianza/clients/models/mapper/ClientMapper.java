package com.alianza.clients.models.mapper;

import com.alianza.clients.models.dto.ClientDTO;
import com.alianza.clients.models.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientDTO clientToClientDTO(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setBussinesId(client.getBussinesId());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setDataAdded(client.getDataAdded());
        clientDTO.setSharedKey(client.getSharedKey());
        return clientDTO;
    }

    public Client clientDTOToClient(ClientDTO clientDTO){
        Client client = new Client();
        client.setBussinesId(clientDTO.getBussinesId());
        client.setEmail(clientDTO.getEmail());
        client.setPhone(clientDTO.getPhone());
        client.setDataAdded(clientDTO.getDataAdded());
        client.setSharedKey(clientDTO.getSharedKey());
        return client;
    }
}
