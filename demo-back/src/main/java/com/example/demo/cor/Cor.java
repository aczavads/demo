package com.example.demo.cor;

import java.util.UUID;

public class Cor {
	private String id;
	private String nome;

	public Cor() {
		this.id = UUID.randomUUID().toString();
	}

	public Cor(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Cor(String nome) {
		this();
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
