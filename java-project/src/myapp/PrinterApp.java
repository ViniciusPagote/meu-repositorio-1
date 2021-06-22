package myapp;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class PrinterApp {
	//sobrecarga de metodos
	public static void print(String conteudo,File dir, String fileName) throws Exception {
		File file = new File(dir, fileName);
		print(conteudo, dir, file);

	}
	public static void print(String conteudo,File dir, File file) throws Exception {
		if (!dir.exists())
			dir.mkdirs();
		
		Path path = new File(dir,file.getName()).toPath();
		Files.write(path, conteudo.getBytes());
	}	
}

//GERAR O CUPOM
//CRIAR O OBJETO - ENDERECO - LOGRADOURO, NUMERO, BAIRRO, CIDADE - SIGLA ESTADO
//FORMATAR O CNPJ, IE, EM - PLUS

//substring
//split
//regex
//pattern
//matches
//String celFormatado = new Long(11987652345L).toString().replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1)$2-$3");


///System.out.printf("Mr.%2$s,%1$s\n\n", "GLEYSON", "SAMPAIO");
		

//String myCep = "65450897";/
//String b1 = myCep.substring(0,2);
//String b2= myCep.substring(2,5);
//String b3= myCep.substring(5,8);

//System.out.println(b1 + "." + b2 + "-" + b3);
//System.out.println(String.format("%s.%s-%s", b1,b2,b3));


//System.out.println(myCep.replaceAll( ("(\\d{2})(\\d{3})(\\d{3})"), "$1.$2-$3") );


//Path path = Paths.get(newFile);
//Files.write(path, bytes);
