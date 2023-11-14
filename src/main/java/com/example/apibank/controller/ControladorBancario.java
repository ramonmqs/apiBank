package com.example.apibank.controller;

import com.example.apibank.dto.TransferenciaDto;
import com.example.apibank.models.Compra;
import com.example.apibank.models.Usuario;
import com.example.apibank.service.ServicoBancario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ControladorBancario {
    @Autowired
    private ServicoBancario servicoBancario;

    @CrossOrigin
    @PostMapping("/compra")
    public String realizarCompra(@RequestBody Compra compra) {
        return servicoBancario.aprovarCompra(compra);
    }

    @CrossOrigin
    @PostMapping("/depositar")
    public String depositar(@RequestParam Long usuarioId, @RequestParam double valor) {
        return servicoBancario.depositar(usuarioId, valor);
    }

    @CrossOrigin
    @GetMapping("/saldo")
    public Usuario verificarSaldo(@RequestParam Long usuarioId) {
        return servicoBancario.verificarSaldo(usuarioId);
    }

    @CrossOrigin
    @PostMapping("/usuarios")
    public Usuario criarUsuario(@RequestBody Usuario usuario){
        return servicoBancario.criarUsuario(usuario);
    }

    @CrossOrigin
    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return servicoBancario.listarUsuarios();
    }

    @CrossOrigin
    @PutMapping("/usuarios/{id}/inativar")
    public Usuario inativarUsuario(@PathVariable Long id) {
        return servicoBancario.inativarUsuario(id);
    }
    @CrossOrigin
    @PutMapping("/usuarios/{id}/status")
    public Usuario alterarStatusUsuario(@PathVariable Long id, @RequestBody Map<String, Boolean> body) {
        return servicoBancario.alterarStatusUsuario(id, body.get("ativo"));
    }
    @CrossOrigin
    @GetMapping("/usuarios/{cpf}")
    public Usuario buscarUsuarioPorCpf(@PathVariable String cpf) {
        return servicoBancario.buscarUsuarioPorCpf(cpf);
    }

    @CrossOrigin
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
