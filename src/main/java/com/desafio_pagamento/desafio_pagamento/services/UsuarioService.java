package com.desafio_pagamento.desafio_pagamento.services;

import com.desafio_pagamento.desafio_pagamento.dto.UsuarioDto;
import com.desafio_pagamento.desafio_pagamento.mapper.CarteiraMapper;
import com.desafio_pagamento.desafio_pagamento.mapper.DocumentoMapper;
import com.desafio_pagamento.desafio_pagamento.mapper.UsuarioMapper;
import com.desafio_pagamento.desafio_pagamento.model.Documento;
import com.desafio_pagamento.desafio_pagamento.model.Role;
import com.desafio_pagamento.desafio_pagamento.model.Usuario;
import com.desafio_pagamento.desafio_pagamento.repository.DocumentoRepository;
import com.desafio_pagamento.desafio_pagamento.repository.RoleRepository;
import com.desafio_pagamento.desafio_pagamento.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private DocumentoRepository documentoRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    RoleRepository roleRepository;


    private final UsuarioMapper usuarioMapper = UsuarioMapper.USUARIO_MAPPER;
    private final CarteiraMapper carteiraMapper = CarteiraMapper.CARTEIRA_MAPPER;
    private final DocumentoMapper documentoMapper = DocumentoMapper.DOCUMENTO_MAPPER;

    public UsuarioDto criarUsuario(UsuarioDto usuarioDto) throws DataIntegrityViolationException {
        Optional<Role> role = roleRepository.findById(2L);

        if (role.isEmpty())
            throw new DataIntegrityViolationException("");
        Set<Role> roles = new HashSet<>();
        roles.add(role.get());

        Usuario usuario = usuarioMapper.toEntity(usuarioDto);
        usuario.setPassword(bCryptPasswordEncoder.encode(usuarioDto.password()));
        usuario.setRoles(roles);
        Usuario usuariosave = usuarioRepository.save(usuario);

        return usuarioMapper.toDto(usuariosave);

    }

    public UsuarioDto updateUsuarios(Long numero, UsuarioDto usuarioDto) throws EntityNotFoundException {
        Usuario usuarioUpdate = buscaUsuario(numero);
        usuarioUpdate.setNome(usuarioDto.nome());
        usuarioUpdate.setEmail(usuarioDto.email());
        usuarioUpdate.setPassword(bCryptPasswordEncoder.encode(usuarioDto.password()));
        usuarioRepository.save(usuarioUpdate);

        return usuarioMapper.toDto(usuarioUpdate);
    }

    public void updateCarteiraUsuario(Double valor, Long depositario, Long destinatario) throws EntityNotFoundException {
        Usuario usuarioDepositario = buscaUsuario(depositario);
        Usuario usuarioDestinatario = buscaUsuario(destinatario);

        usuarioDepositario.getCarteira().setSaldo(usuarioDepositario.getCarteira().getSaldo() - valor);
        usuarioDestinatario.getCarteira().setSaldo(usuarioDestinatario.getCarteira().getSaldo() + valor);
        usuarioRepository.save(usuarioDepositario);
        usuarioRepository.save(usuarioDestinatario);

    }

    public void deleteUsuario(Long numero) throws EntityNotFoundException {
        usuarioRepository.delete(buscaUsuario(numero));
    }

    public UsuarioDto getUsuario(Long numero) throws EntityNotFoundException {
        return usuarioMapper.toDto(buscaUsuario(numero));
    }

    protected Usuario buscaUsuario(Long numero) {
        Optional<Documento> documento = documentoRepository.findByNumero(numero);
        if (documento.isEmpty()) {
            throw new EntityNotFoundException();
        }
        Optional<Usuario> usuario = usuarioRepository.findByDocumento(documento.get());
        if (usuario.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return usuario.get();
    }

    public List<UsuarioDto> getAllUsuario() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarioMapper.toListDto(usuarios);

    }
}
