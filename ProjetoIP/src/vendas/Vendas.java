package vendas;

public class Vendas {
	private String saleid;
	private Long distance;
	private String deliver;
	private Double cost;

	public Vendas(String saleid, String store, String deliver) {
		this.saleid = saleid;
		this.deliver = deliver;
		int aux = 0;
		while (aux < this.deliver.length() && aux <= 10) {
			this.distance *= Character.getNumericValue(deliver.charAt(0));
			aux++;
			this.cost=0.0;
		}
	}

	public String getSaleid() {
		return saleid;
	}

	public void setSaleid(String saleid) {
		this.saleid = saleid;
	}

	public Long getDistance() {
		return distance;
	}

	public void setDistance(Long distance) {
		this.distance = distance;

	}

	public String getDeliver() {
		return deliver;
	}

	public void setDeliver(String deliver) {
		this.deliver = deliver;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Long distance, double price, double entregador, int quantidade) {
		this.cost = distance * entregador + price * quantidade;
	}
}