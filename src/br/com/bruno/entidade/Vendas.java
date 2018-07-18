package br.com.bruno.entidade;

public class Vendas {
	
	private int id;
	
	private int desconto;
	
	private int qtdeParcelas;
	
	private int quantidade;
	
	private double totalComDesconto;
	private double valorDesconto;
	private double totalSemDesconto;
	private double parcelaComDesconto;
	
	private double valorUnitario;
	
	private int idProduto;
	private int idCliente;

	
//	public Cliente cliente ;
//
//	private Produto produto;
	
	

	
	
	public double getValorUnitario() {
		return valorUnitario;
	}


	public int getIdProduto() {
		return idProduto;
	}


	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getTotalComDesconto() {
		return totalComDesconto;
	}

	public void setTotalComDesconto(double totalComDesconto) {
		this.totalComDesconto = totalComDesconto;
	}

	public double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public double getTotalSemDesconto() {
		return totalSemDesconto;
	}

	public void setTotalSemDesconto(double totalSemDesconto) {
		this.totalSemDesconto = totalSemDesconto;
	}

	public double getParcelaComDesconto() {
		return parcelaComDesconto;
	}

	public void setParcelaComDesconto(double parcelaComDesconto) {
		this.parcelaComDesconto = parcelaComDesconto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public int getQtdeParcelas() {
		return qtdeParcelas;
	}

	public void setQtdeParcelas(int qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}
	
	

}
