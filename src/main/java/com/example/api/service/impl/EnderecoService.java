package com.example.api.service.impl;

import com.example.api.config.RestTemplateConfig;
import com.example.api.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
  @Autowired
  private RestTemplateConfig restTemplate;

  public Endereco cepEndereco(String CEP) {
    Endereco endereco = this.restTemplate.getForObject(this.restTemplate.uriRanked(CEP), Endereco.class);
    return endereco;
  }
}
