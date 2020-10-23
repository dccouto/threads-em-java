package br.com.dccouto.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextual implements Runnable {

	private String nomeArquivo;
	private String nome;

	public TarefaBuscaTextual(String nomeArquivo, String nome) {
		this.nomeArquivo = nomeArquivo;
		this.nome = nome;
	}

	@Override
	public void run() {
		try {
			Scanner scanner = new Scanner(new File(nomeArquivo));
			int contador = 1;
			while(scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				
				if(linha.contains(nome)) {
					System.out.println(nomeArquivo + " - " + contador + " - " + linha);
				}
				contador++;
			}
			
			scanner.close();
		
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
