package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Pedido;
import com.example.demo.model.Cliente;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
