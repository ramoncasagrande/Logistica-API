package com.ramon.logisticaapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ramon.logisticaapi.exception.NegocioException;
import com.ramon.logisticaapi.model.Cliente;
import com.ramon.logisticaapi.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente verificaCliente(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new NegocioException("Cliente não encontrado"));
    }

    @Transactional
    public Cliente salvar(Cliente cliente){
        boolean emailJaCadastrado = clienteRepository.findByEmail(cliente.getEmail())
                            .stream()
                            .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
        if(emailJaCadastrado){
            throw new NegocioException("E-mail já cadastrado");
        }
        return clienteRepository.save(cliente);


    }

    @Transactional
    public void excluir(Long id){
        clienteRepository.deleteById(id);
    }
    

}
