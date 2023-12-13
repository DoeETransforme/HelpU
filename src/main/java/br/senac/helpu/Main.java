package br.senac.helpu;

import java.time.LocalDate;

import br.senac.helpu.modelo.entidade.alimento.Alimento;

public class Main {
	public static void main(String[] args) {
		
		Alimento alimento = new Alimento(LocalDate.now(), 10, "Arroz");
	}
}
