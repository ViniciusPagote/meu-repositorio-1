package myapp.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import myapp.cadastros.Empresa;
import myapp.cadastros.Endereco;
import myapp.pedidos.Pedido;
import myapp.pedidos.PedidoItem;
import myapp.util.FormatUtil;
import myapp.util.ReaderApp;

public class CupomService {
	public static List<Pedido> gerarPedidos(File dir, String fileName) throws Exception {
		SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMdd"); 
		List<String> linhas = ReaderApp.ler(dir, fileName);
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		for(String l: linhas) {
			Pedido p = new Pedido();
			p.setData(formatador.parse(l.substring(0,8)));
			p.setCcf(Integer.valueOf(l.substring(8,10)));
			p.setCoo(Integer.valueOf(l.substring(10,13)));
			
			pedidos.add(p);
		}
		return pedidos;
	}
	public static String gerarCupom(Pedido pedido) {
		
		Empresa empresa = pedido.getEmpresa();
		
		System.out.println(empresa.getCadastro().getEndereco());
		
		Endereco e = empresa.getCadastro().getEndereco();
		String cep = e.getCep().toString().replaceAll( ("(\\d{2})(\\d{3})(\\d{3})"), "$1.$2-$3");
		
		StringBuilder sb = new StringBuilder();
		sb.append("----------------------------------------------------------------\n");
		sb.append(empresa.getCadastro().getNome() + "\n");
		sb.append(String.format("%s, %s, %s - %s - %s Cep: %s \n", e.getLogradouro(), e.getNumero(),e.getBairro(), e.getCidade(),e.getUf(), cep   ));
		sb.append(String.format("CNPJ: %s \n", FormatUtil.formatCnpj(empresa.getCadastro().getCpfCnpj())));
		sb.append(String.format("IE: %s\nIM: %s\n",empresa.getIe().toString().replaceAll( ("(\\d{3})(\\d{3})(\\d{3})"), "$1.$2.$3"), 
				empresa.getIm().toString().replaceAll( ("(\\d{2})(\\d{3})(\\d{3})"), "$1.$2.$3")));
		sb.append("----------------------------------------------------------------\n");
		
		//NUMA LINHA DATA FORMATADA - CCF (6) DIGITOS - COO (6DIGITOS)
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		String dataFormatada = formatador.format(pedido.getData());
		sb.append(String.format("%-40s CCF:%06d CCO:%06d",dataFormatada, pedido.getCcf(), pedido.getCoo()) );
		
		
		sb.append("\n----------------------------------------------------------------\n");
		
		List<PedidoItem> itens = pedido.getItens();
		
		sb.append(String.format("%-35s%10s%10s%10s\n", "ITEM","QUANT", "R$ UNIT", "R$ TOTAL"));
		
		for(PedidoItem i: itens) {
			String q = String.format("%.2f",i.getQuantidade());
			String vu = String.format("%.2f",i.getValorVenda());
			String vt = String.format("%.2f",i.getValorTotal());
			
			sb.append(String.format("%-35s%10s%10s%10s\n",i.getProduto().getTitulo(),  q,vu,vt));
			
		}
		sb.append("\n----------------------------------------------------------------\n");
		
		sb.append(String.format("%-58s %.2f\n","TOTAL", pedido.getValorTotal()));
		return sb.toString();
	}	
}
