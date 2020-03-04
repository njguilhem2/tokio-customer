package com.example.api.domain;

import javax.persistence.*;

@Entity
public class Endereco {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String rua;
  @Column(nullable = false)
  private Integer cep;
  @Column(nullable = false)
  private String bairro;
  @Column(nullable = false)
  private String cidade;
  @Column(nullable = false)
  private String estado;

  public Endereco(Long id, String rua, Integer cep, String bairro, String cidade, String estado) {
    this.id = id;
    this.rua = rua;
    this.cep = cep;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public Integer getCep() {
    return cep;
  }

  public void setCep(Integer cep) {
    this.cep = cep;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }
}
