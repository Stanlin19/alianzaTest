package com.alianza.clients.service;

import com.alianza.clients.models.dto.ClientDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IClientService {

    public List<ClientDTO> findAll();
    public Optional<ClientDTO> findBySharedKey(String sharedKey);
    public void save(ClientDTO clientDTO);
    public void delete(Long id);
}
