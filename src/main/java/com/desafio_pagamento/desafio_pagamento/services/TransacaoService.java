package com.desafio_pagamento.desafio_pagamento.services;

import com.desafio_pagamento.desafio_pagamento.dto.AuthorizeDto;
import com.desafio_pagamento.desafio_pagamento.dto.TransacaoDto;
import com.desafio_pagamento.desafio_pagamento.mapper.TransacaoMapper;
import com.desafio_pagamento.desafio_pagamento.model.StatusAuthorize;
import com.desafio_pagamento.desafio_pagamento.model.TipoDocumento;
import com.desafio_pagamento.desafio_pagamento.model.Transacao;
import com.desafio_pagamento.desafio_pagamento.model.Usuario;
import com.desafio_pagamento.desafio_pagamento.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TransacaoService {

    @Autowired
    TransacaoRepository transacaoRepository;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    Authorizeservice authorizeservice;

    TransacaoMapper transacaoMapper = TransacaoMapper.TRANSACAO_MAPPER;

    public TransacaoDto criarTransacao(TransacaoDto transacaoDto) throws RuntimeException {
        Transacao transacao = transacaoMapper.toEntity(transacaoDto);
        Usuario depositario = usuarioService.buscaUsuario(transacao.getDepositario().getDocumento().getNumero());
        Usuario destinatario = usuarioService.buscaUsuario(transacao.getDestinatario().getDocumento().getNumero());
        AuthorizeDto authorizeDto = authorizeservice.authorize();


        if ((depositario.getCarteira().getSaldo() < transacao.getValor()) || (depositario.getDocumento().getTipoDocumento().equals(TipoDocumento.CNPJ)) || (!Objects.equals(authorizeDto.status(), StatusAuthorize.success))) {
            throw new RuntimeException();
        }
        usuarioService.updateCarteiraUsuario(transacao.getValor(), depositario.getDocumento().getNumero(), destinatario.getDocumento().getNumero());
        transacao.setDepositario(depositario);
        transacao.setDestinatario(destinatario);

        transacaoRepository.save(transacao);
        return transacaoMapper.toDto(transacao);

    }

    public List<TransacaoDto> getAllTransacao() {

        return transacaoMapper.toListDto(transacaoRepository.findAll());
    }
}
