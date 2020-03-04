package com.example.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * The type Customer.
 */
@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @OneToOne
  @JoinColumn(name = "endereco")
  private Endereco endereco;

  @Column(nullable = false)
  @Email
  private String email;

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets email.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets email.
   *
   * @param email the email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets endereco.
   *
   * @return the endereco
   */
  public Endereco getEndereco() {
    return endereco;
  }

  /**
   * Sets endereco.
   *
   * @param endereco the endereco
   */
  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }
}
