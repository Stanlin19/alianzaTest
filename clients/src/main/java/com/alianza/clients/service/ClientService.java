package com.alianza.clients.service;

import com.alianza.clients.models.dto.ClientDTO;
import com.alianza.clients.models.entity.Client;
import com.alianza.clients.models.mapper.ClientMapper;
import com.alianza.clients.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService{

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

    @Override
    public List<ClientDTO> findAll() {
        logger.info("Searching clients");
        return clientRepository.
                findAll().stream().
                map(clientMapper::clientToClientDTO)
                .toList();
    }

    @Override
    public Optional<ClientDTO> findBySharedKey(String sharedKey) {
        logger.info("Searching client by {}", sharedKey);
        return clientRepository.findBySharedKey(sharedKey)
                .map(clientMapper::clientToClientDTO);
    }

    @Override
    public void save(ClientDTO clientDTO) {
        logger.info("saving client {}", clientDTO);
        Client client = clientMapper.clientDTOToClient(clientDTO);
        client.setDataAdded(LocalDate.now());
        String[] sharedKey = clientDTO.getBussinesId().toLowerCase().split(" ");
        if(sharedKey.length > 1){
            client.setSharedKey(sharedKey[0].charAt(0)+sharedKey[1]);
        } else {
            client.setSharedKey(clientDTO.getBussinesId());
        }
        client.setSharedKey(validateSharedKey(client.getSharedKey(), clientDTO.getBussinesId()));
        clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        logger.info("Deleting client {}", id);
        clientRepository.deleteById(id);
    }

    public String validateSharedKey(String sharedKey, String bussinesId){
        Optional<ClientDTO> shared = findBySharedKey(sharedKey);
        if(shared.isPresent()){
            String[] shrdkey = bussinesId.toLowerCase().split(" ");
            sharedKey = shrdkey[0].charAt(0)+shrdkey[1]+((int)(Math.random() * 50 + 1));
            if(findBySharedKey(sharedKey).isPresent()){
                validateSharedKey(sharedKey, bussinesId);
            } else {
                return sharedKey;
            }
        }
        return sharedKey;
    }
}
