package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> list = new ArrayList<Product>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			sc.nextLine();
			char ch = sc.next().charAt(0);
			switch (ch) {
			case 'c':
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Price: ");
				double price = sc.nextDouble();

				list.add(new Product(name, price));
				break;
			case 'i':
				System.out.print("Name: ");
				sc.nextLine();
				name = sc.nextLine();

				System.out.print("Price: ");
				price = sc.nextDouble();
				System.out.print("Custom fee: ");
				double customFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customFee));
				break;
			case 'u':
				System.out.print("Name: ");
				sc.nextLine();
				name = sc.nextLine();
				System.out.print("Price: ");
				price = sc.nextDouble();
				System.out.print("Manufacture date (DD/MM/YYYY):");
				sc.nextLine();
				Date date = sdf.parse(sc.nextLine());
				list.add(new UsedProduct(name, price, date));
				break;
			default:
				System.out.println("Invalido!");
			}
		}

		System.out.println("");
		System.out.println("PRICE TAGS:");
		for (Product x : list) {
			System.out.println(x.priceTag());
		}

		sc.close();
	}

}
