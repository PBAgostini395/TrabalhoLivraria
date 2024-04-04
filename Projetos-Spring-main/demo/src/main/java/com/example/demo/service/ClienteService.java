package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }

    public Cliente criar(Cliente cliente) {return clienteRepository.save(cliente);}

    public Cliente atualizar(Long id, Cliente cliente) {
        if(clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public boolean deletar(Long id) {
        if(clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public int qtdCliente () {
        return clienteRepository.findAll().size();
    }
}
