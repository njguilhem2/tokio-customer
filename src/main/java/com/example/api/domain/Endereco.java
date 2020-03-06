package com.example.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class Endereco {
  @Id
  @JsonIgnore
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String CEP;
  @Column(nullable = false)
  private String logradouro;
  @Column(nullable = false)
  private String complemento;
  @Column(nullable = false)
  private String bairro;
  @Column(nullable = false)
  private String localidade;
  @Column(nullable = false)
  private String uf;
  @Column(nullable = false)
  private String unidade;
  @Column(nullable = false)
  private String ibge;
  @Column(nullable = false)
  private String gia;

  public Endereco(){}

  public Endereco(Long id, String CEP, String logradouro, String complemento, String bairro, String localidade, String uf, String unidade, String ibge, String gia) {
    this.id = id;
    this.CEP = CEP;
    this.logradouro = logradouro;
    this.complemento = complemento;
    this.bairro = bairro;
    this.localidade = localidade;
    this.uf = uf;
    this.unidade = unidade;
    this.ibge = ibge;
    this.gia = gia;
  }
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCEP() {
    return CEP;
  }

  public void setCEP(String CEP) {
    this.CEP = CEP;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getLocalidade() {
    return localidade;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public String getUnidade() {
    return unidade;
  }

  public void setUnidade(String unidade) {
    this.unidade = unidade;
  }

  public String getIbge() {
    return ibge;
  }

  public void setIbge(String ibge) {
    this.ibge = ibge;
  }
  public String getGia() {
    return gia;
  }

  public void setGia(String gia) {
    this.gia = gia;
  }
}
