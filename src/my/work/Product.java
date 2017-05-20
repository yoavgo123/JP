package my.work;

import java.util.ArrayList;

public class Product {

	private String name;
	private int sales = 0;
	private double total = 0;
	ArrayList<Double> list = new ArrayList<Double>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {

		list.add(total - this.total);

		this.total = total;
	}

	public ArrayList<Double> getList() {
		return list;
	}

	public void setList(ArrayList<Double> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", sales=" + sales + ", total=" + total + ", list=" + list + "]";
	}

}
