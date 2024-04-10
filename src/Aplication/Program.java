package Aplication;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String [] arg) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter the number of products: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Product #" + (i+1) + " data: ");
            System.out.println("Comun, used, or imported? (c/u/i)");
            char op = sc.next().toLowerCase().charAt(0);
            sc.nextLine();
            System.out.println("Name: ");
            String name = sc.nextLine();
            System.out.println("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            if (op == 'c'){
                products.add(new Product(name,price));
            }if (op == 'i'){
                System.out.println("Customs fee: ");
                double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name,price,customsFee));
            }if (op == 'u'){
                System.out.println("Manufacture date (DD/MM/YYYY): ");
                String date = sc.nextLine();
                Date date1 = sdf.parse(date);
                products.add(new UsedProduct(name, price, date1));
            }

        }
        System.out.println("PRICE TAGS: ");
        for (Product product : products) {
            System.out.println(product.priceTag());
        }
    }
}
