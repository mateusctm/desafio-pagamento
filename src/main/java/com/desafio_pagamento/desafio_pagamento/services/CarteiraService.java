package com.desafio_pagamento.desafio_pagamento.services;

import org.springframework.stereotype.Service;

@Service
public class CarteiraService {

//    @Autowired
//    CarteiraRepository carteiraRepository;
//    @Autowired
//    UsuarioRepository usuarioRepository;
//    @Autowired
//    private DocumentoRepository documentoRepository;
//
//    CarteiraMapper carteiraMapper = CarteiraMapper.CARTEIRA_MAPPER;
//
//    public Carteira buscaCarteira(Long numero) {
//        Optional<Documento> documento = documentoRepository.findByNumero(numero);
//        if (documento.isEmpty()) {
//            throw new EntityNotFoundException();
//        }
//
//        Optional<Usuario> usuario = usuarioRepository.findByDocumento(documento.get());
//        if (usuario.isEmpty()) {
//            throw new EntityNotFoundException();
//        }
//
//        return usuario.get().getCarteira();
//    }
//
//    public void depositaCarteira(Double valor, Long depositario, Long destinatario){
////        Optional<Documento> documentoDepositario = documentoRepository.findByNumero(depositario);
////        Optional<Documento> documentoDestinatario = documentoRepository.findByNumero(destinatario);
////        if (documentoDepositario.isEmpty() || documentoDestinatario.isEmpty()) {
////            throw new EntityNotFoundException();
////        }
////
////        Optional<Usuario> usuarioDepositario = usuarioRepository.findByDocumento(documentoDepositario.get());
////        Optional<Usuario> usuarioDestinatario = usuarioRepository.findByDocumento(documentoDestinatario.get());
////        if (usuarioDepositario.isEmpty() || usuarioDestinatario.isEmpty() ) {
////            throw new EntityNotFoundException();
////        }
//
//        Carteira carteiraDepositario = buscaCarteira(depositario);
//        Carteira carteiraDestinatario = buscaCarteira(destinatario);
//        if(carteiraDepositario.getSaldo() < valor){
//            throw new RuntimeException();
//        }
//        carteiraDepositario.setSaldo(carteiraDepositario.getSaldo() - valor);
//        carteiraDestinatario.setSaldo(carteiraDestinatario.getSaldo() + valor);
//
//        carteiraRepository.save(carteiraDepositario);
//        carteiraRepository.save(carteiraDestinatario);
//
//    }


}