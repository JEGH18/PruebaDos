package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;

import javax.xml.crypto.Data;

import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller shop;

	public Executable() {

		reader = new Scanner(System.in);
		shop = new Controller();
	}

	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

	public void menu() {

		System.out.println("Bienvenido a ReaderX!");

		boolean flag = false;

		while (!flag) {

			System.out.println("\nMENU PRINCIPAL");
			System.out.println("\n1. Registrar libro");
			System.out.println("2. Vender libro");
			System.out.println("3. Consultar informacion registrada en el sistema");
			System.out.println("4. Salir");
			int option = reader.nextInt();

			switch (option) {

			case 1:
				registerBook();
				break;

			case 2:
				sellBook(option, null, option);
				break;
			case 3:
				showAllBookInfo(option);
				break;

			case 4:
				flag = true;
				break;

			}

		}

	}

	public void registerBook() {



		System.out.println("Digite a continuacion la informacion de un nuevo libro");

		// Limpieza de buffer
		reader.nextLine();
		System.out.println("\nDigite el identificador. Ej.: A1F");
		String id = reader.nextLine();

		System.out.println("Digite el nombre");
		String name = reader.nextLine();

		System.out.println("Digite el tipo de genero. \n1. Ciencia Ficcion \n2. Fantasia \n3. Novela historica");
		int genre = reader.nextInt();

		System.out.println("Digite el valor de venta");
		double price = reader.nextDouble();

		if (shop.registerBook(id, name, genre, price)) {

			System.out.println("Libro registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el libro exitosamente");
		}
	}

	private void sellBook(int index, Calendar date, double purchaseValue) {

		String query = shop.getBookList();

		if (query.equals("")) {

			System.out.println("No hay libros registrados");
		} else {

			System.out.println("\nEste es el listado de libros registrados");

			System.out.println(query);

			System.out.println("\nSeleccione el libro a vender");

			int option = reader.nextInt();

			System.out.println("Ingrese la fecha de venta del libro (dd/MM/yyyy)");

			String inputDate = reader.nextLine();

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

			Date date;

			try{
				date=dateFormat.parse(inputDate);
			} catch (ParseException e){
				System.out.println("la fecha ingresada no es validad. Por favor ingresela en el formato dd/MM/yyyy");
			}

			Calendar cal = Calendar.getInstance();
			cal.setTime(date); 


			if (shop.sellBook(option - 1, date, purchaseValue)) {

				System.out.println("\nTransaccion realizada exitosamente");

			} else {

				System.out.println("\nError en la transaccion");
			}

		}

	}

	public void showAllBookInfo(int index) {

		String query = shop.getBookList();

		if (query.equals("")) {

			System.out.println("No hay libros registrados");

		} else {
			System.out.println("Este es el listado de libros registrados en el sistema:");
			System.out.println(query);

			System.out.println("Seleccione el libro que desea ver la informacion");

			int option = reader.nextInt();

			String bookInfo = shop.getAllKBookInfo(option - 1);

			if (bookInfo.equals("")){

				System.out.println("No se pudo obtener la informacion del libro");

			}else{
				System.out.println(bookInfo);
			}
		}

	}

}