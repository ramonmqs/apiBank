package com.example.leobank.service;

import com.example.leobank.models.Compra;
import com.example.leobank.models.Usuario;
import com.example.leobank.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ServicoBancario {

    @Autowired
    public UserRepository userRepository;
    public Usuario verificarSaldo(Long usuarioId) {
        return userRepository.findById(usuarioId).orElse(null);
    }

    public String aprovarCompra(Compra compra) {
        Usuario usuario = verificarSaldo(compra.getUsuarioId());
        if (usuario != null && usuario.getSaldo() >= compra.getValor()) {
            usuario.setSaldo(usuario.getSaldo() - compra.getValor());
            userRepository.save(usuario);
            return "Compra aprovada";
        } else {
            return "Compra negada, saldo insuficiente";
        }
    }

    public String depositar(Long usuarioId, double valor) {
        Usuario usuario = verificarSaldo(usuarioId);
        if (usuario != null) {
            usuario.setSaldo(usuario.getSaldo() + valor);
            userRepository.save(usuario);
            return "Depósito realizado com sucesso";
        } else {
            return "Usuário não encontrado";
        }
    }

    public Usuario criarUsuario(Usuario usuario) {
        usuario.setAtivo(true);
        return userRepository.save(usuario);
    }


    public List<Usuario> listarUsuarios() {
        return userRepository.findAll().stream()
                .filter(Usuario::isAtivo)
                .collect(Collectors.toList());
    }

    public Usuario inativarUsuario(Long id) {
        Usuario usuario = userRepository.findById(id).orElse(null);
        if (usuario != null){
            usuario.setAtivo(false);
            userRepository.save(usuario);
        }
        return usuario;
    }

    public Usuario alterarStatusUsuario(Long id, Boolean novoStatus) {
        Usuario usuario = userRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setAtivo(novoStatus);
            userRepository.save(usuario);
        }
        return usuario;
    }

    @Transactional
    public void transferir(Long remetenteId, Long destinatarioId, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor a ser transferido deve ser positivo");
        }

        Usuario remetente = verificarSaldo(remetenteId);
        Usuario destinatario = verificarSaldo(destinatarioId);

        if (remetente == null) {
            throw new IllegalArgumentException("Usuário remetente não encontrado");
        }

        if (destinatario == null) {
            throw new IllegalArgumentException("Usuário destinatário não encontrado");
        }

        if (remetente.getSaldo() < valor) {
            throw new IllegalArgumentException("Saldo insuficiente para transferência");
        }

        remetente.setSaldo(remetente.getSaldo() - valor);
        destinatario.setSaldo(destinatario.getSaldo() + valor);

        try {
            userRepository.save(remetente);
            userRepository.save(destinatario);
        } catch (TransactionSystemException e) {
            throw new RuntimeException("Erro ao realizar transferência", e);
        }
    }


    public Usuario buscarUsuarioPorCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }

    public List<Usuario> listarTodosUsuarios() {
        return userRepository.findAll();
    }


}
