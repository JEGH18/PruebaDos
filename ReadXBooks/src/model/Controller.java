package model;

import java.util.Calendar;
import java.util.Date;

public class Controller {

	private Book[] books;
	private Transaction[] transactions;

	public Controller() {

		books = new Book[50];
		transactions = new Transaction[1000];
		testCases();

	}

	public void testCases() {

		books[0] = new Book("A1F", "A Game of Thrones", 20);
		books[1] = new Book("A1A", "Dune", 10);

	}

	public boolean registerBook(String id, String name, int genre, double price) {

		boolean added = false;

		for (int i = 0; i < books.length && !added; i++){

			if (books[i] == null) {
				books[i] = new
			Book(id, name, price);
				added = true;
			}
		}
		return added;
	}

	public String getBookList() {

		String msg = "";

		for (int i = 0; i < books.length; i++) {

			if (books[i] != null) {
				msg += "\n" + (i + 1) + ". " + books[i].getName();
			}

		}

		return msg;
	}

	public String getAllKBookInfo(int index) {

		String info = "";

		if (index >=0 && index < books.length && books[index] !=null){

			Book book = books [index];
			info = "ID: " + book.getId() + "\n"+ "Nombre: " + book.getName() + "\n" + "Precio: " + book.getPrice() + "\n" + "Unidades vendidas " + book.getUnitsSold();

		}

		return info;

	}

	public boolean sellBook(int index, Date date, double purchaseValue) {

		boolean sold = false;

		if (index >= 0 && index < books.length && books[index] !=null){
			Book book = books [index];

			book.setUnitsSold(book.getUnitsSold() + 1);

			Transaction transaction = new Transaction(date, purchaseValue);

			for (int i = 0; i < transactions.length && !sold; i++){

				if (transactions[i]==null){
					transactions[i]=transaction;

					sold=true;
				}
			}
		}

		return sold;
	}

    public void agregarProyecto(Proyect proyecto) {
    }

    public void mostrarProyectos() {
    }

}
