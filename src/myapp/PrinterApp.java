package myapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import myapp.cadastros.Empresa;
import myapp.pedidos.Pedido;

public class PrinterApp {
	public static void imprimirPedido(Pedido pedido) {
		//GERAR O CUPOM
		//CRIAR O OBJETO - ENDERECO - LOGRADOURO, NUMERO, BAIRRO, CIDADE - SIGLA ESTADO
		//FORMATAR O CNPJ, IE, EM - PLUS
		
		//substring
		//split
		//regex
		//pattern
		//matches
		String celFormatado = new Long(11987652345L).toString().replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1)$2-$3");
		
		
		System.out.printf("Mr.%2$s,%1$s\n\n", "GLEYSON", "SAMPAIO");
		
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
		
		//depois de tudo bonitinho
		
		//vamos salvar o cupum no disco
		
		
		try {
			  File dir = new File("/mjv/cupom");
			  
			  if(!dir.exists())
				  dir.mkdir();
		      
			  File file = new File(dir, "cupom.txt" );
			  
			  FileWriter myWriter = new FileWriter(file);
		      //myWriter.write("Files in Java might be tricky, but it is fun enough!");
		      myWriter.write(sb.toString());
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  }
		
}
