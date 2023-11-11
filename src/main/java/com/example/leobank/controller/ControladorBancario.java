package com.example.leobank.controller;

import com.example.leobank.dto.TransferenciaDto;
import com.example.leobank.models.Compra;
import com.example.leobank.models.Usuario;
import com.example.leobank.service.ServicoBancario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ControladorBancario {
    @Autowired
    private ServicoBancario servicoBancario;

    @PostMapping("/compra")
    public String realizarCompra(@RequestBody Compra compra) {
        return servicoBancario.aprovarCompra(compra);
    }

    @PostMapping("/depositar")
    public String depositar(@RequestParam Long usuarioId, @RequestParam double valor) {
        return servicoBancario.depositar(usuarioId, valor);
    }

    @GetMapping("/saldo")
    public Usuario verificarSaldo(@RequestParam Long usuarioId) {
        return servicoBancario.verificarSaldo(usuarioId);
    }

    @PostMapping("/usuarios")
    public Usuario criarUsuario(@RequestBody Usuario usuario){
        return servicoBancario.criarUsuario(usuario);
    }

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return servicoBancario.listarUsuarios();
    }

    @PutMapping("/usuarios/{id}/inativar")
    public Usuario inativarUsuario(@PathVariable Long id) {
        return servicoBancario.inativarUsuario(id);
    }

    @PutMapping("/usuarios/{id}/status")
    public Usuario alterarStatusUsuario(@PathVariable Long id, @RequestBody Map<String, Boolean> body) {
        return servicoBancario.alterarStatusUsuario(id, body.get("ativo"));
    }

    @GetMapping("/usuarios/{cpf}")
    public Usuario buscarUsuarioPorCpf(@PathVariable String cpf) {
        return servicoBancario.buscarUsuarioPorCpf(cpf);
    }

    @PostMapping("/transferir")
    public String transferir(@RequestBody TransferenciaDto transferencia) {
        try {
            servicoBancario.transferir(transferencia.getRemetenteId(), transferencia.getDestinatarioId(), transferencia.getValor());
            return "Transferência realizada com sucesso";
        } catch (Exception e) {
            return "Erro ao realizar transferência: " + e.getMessage();
        }
    }




}
