package com.desafio_pagamento.desafio_pagamento.services;

import com.desafio_pagamento.desafio_pagamento.dto.AuthorizeDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Authorizeservice {

    public AuthorizeDto authorize(){
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject("https://util.devi.tools/api/v2/authorize", AuthorizeDto.class);

    }

}
