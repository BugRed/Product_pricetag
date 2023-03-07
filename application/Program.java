package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] main) throws ParseException {

		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> productList = new ArrayList<Product>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or importred(c/u/i)?");
			char resp = sc.next().charAt(0);
			System.out.print("Name: ");
			String productName = sc.nextLine();
			sc.nextLine();
			System.out.print("Price: ");
			double productPrice = sc.nextDouble();

			if (resp == 'u') {
				System.out.print("Manufacture date: ");
				LocalDate manufactureDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

				productList.add(new UsedProduct(productName, productPrice, manufactureDate));

			} else if (resp == 'c') {

				productList.add(new Product(productName, productPrice));

			} else if (resp == 'i') {

				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();

				productList.add(new ImportedProduct(productName, productPrice, customsFee));

			}

		}
		System.out.print("PRICE TAGS: ");
		for (Product p : productList) {
			System.out.println(p.priceTag());
		}
		sc.close();
	}

}
