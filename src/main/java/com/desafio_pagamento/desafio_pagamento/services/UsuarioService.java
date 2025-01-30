package com.desafio_pagamento.desafio_pagamento.services;

import com.desafio_pagamento.desafio_pagamento.dto.UsuarioDto;
import com.desafio_pagamento.desafio_pagamento.mapper.CarteiraMapper;
import com.desafio_pagamento.desafio_pagamento.mapper.DocumentoMapper;
import com.desafio_pagamento.desafio_pagamento.mapper.UsuarioMapper;
import com.desafio_pagamento.desafio_pagamento.model.Documento;
import com.desafio_pagamento.desafio_pagamento.model.Usuario;
import com.desafio_pagamento.desafio_pagamento.repository.DocumentoRepository;
import com.desafio_pagamento.desafio_pagamento.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private DocumentoRepository documentoRepository;

    private final UsuarioMapper usuarioMapper = UsuarioMapper.USUARIO_MAPPER;
    private final CarteiraMapper carteiraMapper = CarteiraMapper.CARTEIRA_MAPPER;
    private final DocumentoMapper documentoMapper = DocumentoMapper.DOCUMENTO_MAPPER;

    public UsuarioDto criarUsuario(UsuarioDto usuarioDto) throws DataIntegrityViolationException {
        Usuario usuario = usuarioMapper.toEntity(usuarioDto);
        Usuario usuariosave = usuarioRepository.save(usuario);

        return usuarioMapper.toDto(usuariosave);

    }

    public UsuarioDto updateUsuarios(Long numero, UsuarioDto usuarioDto) {

        Optional<Documento> documento = documentoRepository.findByNumero(numero);
        if (documento.isEmpty()) {
            throw new EntityNotFoundException();
        }
        Optional<Usuario> usuario = usuarioRepository.findByDocumento(documento.get());
        if (usuario.isEmpty()) {
            throw new EntityNotFoundException();
        }

        Usuario usuarioUpdate = usuario.get();
        usuarioUpdate.setNome(usuarioDto.nome());
        usuarioUpdate.setEmail(usuarioDto.email());
        usuarioUpdate.setPassword(usuarioDto.password());
        usuarioRepository.save(usuarioUpdate);

        return usuarioMapper.toDto(usuarioUpdate);
    }

    public void deleteUsuario(Long numero) throws EntityNotFoundException {
        Optional<Documento> documento = documentoRepository.findByNumero(numero);
        if (documento.isEmpty()) {
            throw new EntityNotFoundException();
        }
        Optional<Usuario> usuario = usuarioRepository.findByDocumento(documento.get());
        if (usuario.isEmpty()) {
            throw new EntityNotFoundException();
        }
        usuarioRepository.delete(usuario.get());
    }

    public UsuarioDto getUsuario(Long numero) throws EntityNotFoundException {
        Optional<Documento> documento = documentoRepository.findByNumero(numero);
        if (documento.isEmpty()) {
            throw new EntityNotFoundException();
        }
        Optional<Usuario> usuario = usuarioRepository.findByDocumento(documento.get());
        if (usuario.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return usuarioMapper.toDto(usuario.get());
    }

    public List<UsuarioDto> getAllUsuario() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarioMapper.toListDto(usuarios);

    }
}
