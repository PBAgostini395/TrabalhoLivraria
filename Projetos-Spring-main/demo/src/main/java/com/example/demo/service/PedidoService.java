package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Pedido;
import com.example.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    public List<Pedido> listarPedido() {
        return pedidoRepository.findAll();
    }

    public Pedido criar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizar(Long id, Pedido pedido) {
        if(pedidoRepository.existsById(id)) {
            pedido.setId(id);
            return pedidoRepository.save(pedido);
        }
        return null;
    }

    public boolean deletar(Long id) {
        if(pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
