package com.br.jean.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.br.jean.app.entities.Produto;

public class App {
	
	private static Double calcularTotal(List<Produto> list) {
		Double somaTotalTodosProdutos = 0.0;
		for (Produto p : list) {
			somaTotalTodosProdutos += (p.getPreco() * p.getQuantidade());
		}
		return somaTotalTodosProdutos;
	}
	
  public static void main( String[] args )  {
  	Scanner teclado = new Scanner(System.in);
  	Integer qtdProdutos = 0;
  	String nome = "";
  	Double preco;
  	Integer qtdParaProdutoAtual;
  	
    System.out.print("Informe a quantidade de produto que deseja cadastrar: ");
    qtdProdutos = Integer.parseInt(teclado.nextLine());
    
    List<Produto> listaDeProdutos = new ArrayList<>();
    
    for (int i = 0; i < qtdProdutos; i++) {
    	System.out.print("Entre com a quantidade (> 0) deste produto: ");
    	qtdParaProdutoAtual = Integer.parseInt(teclado.nextLine());
    	
    	if (qtdParaProdutoAtual > 0) {
    		System.out.print("Entre com o preço do produto: ");
      	preco = Double.parseDouble(teclado.nextLine());
      	
      	System.out.print("Entre com o nome do produto: ");
      	nome = teclado.nextLine();
      	
      	listaDeProdutos.add(new Produto(nome, preco, qtdParaProdutoAtual));
    	} else {
    		System.out.println("Quantidade de produto inválido");
    		i--;
    	}
    	
    }
    
    System.out.print("\n\nDeseja exibir lista dos produtos? [1 -> sim / 2 -> não]: ");
    switch(teclado.nextInt()) {
    	case 1:
    		for (Produto produto: listaDeProdutos) {
    			System.out.println(produto);
    		}
    		System.out.println("Valor total: " + calcularTotal(listaDeProdutos));
    		break;
    	case 2:
    		System.out.println("Saindo...");
    		break;
    	default:
    		System.out.println("Opção inválida");
    		break;
    }
    
    teclado.close();
  }
}
