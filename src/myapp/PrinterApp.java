package myapp;

import java.text.SimpleDateFormat;

import myapp.cadastros.Empresa;
import myapp.pedidos.Pedido;

public class PrinterApp {
	public static void imprimirPedido(Pedido pedido) {
		System.out.printf("Mr.%2$s,%1$s\n\n", "GLEYSON", "SAMPAIO");
		
		//ENDERECO - LOGRADOURO, NUMERO, BAIRRO, CIDADE - SIGLA ESTADO
		Empresa empresa = pedido.getEmpresa();
		
		StringBuilder sb = new StringBuilder();
		sb.append(empresa.getCadastro().getNome() + "\n");
		sb.append(empresa.getCadastro().getEndereco() + "\n");
		sb.append(String.format("CNPJ: %s \n", empresa.getCadastro().getCpfCnpj()));
		sb.append(String.format("IE: %d\nIM: %d\n",empresa.getIe(), empresa.getIm()));
		sb.append("------------------------------------------------------------------\n");
		
		//NUMA LINHA DATA FORMATADA - CCF (6) DIGITOS - COO (6DIGITOS)
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		String dataFormatada = formatador.format(pedido.getData());
		sb.append(dataFormatada);
		
		sb.append("------------------------------------------------------------------\n");
		sb.append(String.format("TOTAL %.2f", pedido.getValorTotal()));
		
		
		
		
		System.out.println(sb.toString());
		/*
		System.out.println(empresa.getCadastro().getNome());
		System.out.println(empresa.getCadastro().getEndereco());
		System.out.println("CNPJ:" + empresa.getCadastro().getCpfCnpj());
		System.out.println("IE:" +empresa.getIe());
		System.out.println("IM:" +empresa.getIm());
		*/
		
	}
}
