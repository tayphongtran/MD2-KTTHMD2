package controllers;

import io.ReaderAndWriteProduct;
import models.Product;
import sort.SortByPrice;
import validate.ValidateProduct;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerProduct {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Product> products = new ArrayList<>();
    ValidateProduct validateProduct = new ValidateProduct();
    ReaderAndWriteProduct readerAndWriteProduct = new ReaderAndWriteProduct();

    public void menu() {
        System.out.println("Chương trình quản lý sản phẩm");
        System.out.println("1. hiển thị");
        System.out.println("2. thêm mới");
        System.out.println("3. chỉnh sửa");
        System.out.println("4. xóa");
        System.out.println("5. sắp xếp");
        System.out.println("6. đọc file");
        System.out.println("7. ghi file");
        System.out.println("8. thoát");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                show();
                break;
            case 2:
                addProduct(createProduct());
                break;
            case 3:
                editProduct();
                break;
            case 4:
                deleteProduct();
                break;
            case 5:
                sortByScore();
                break;
            case 6:
                products = readerAndWriteProduct.reader();
                System.out.println("đọc thành công");
                break;
            case 7:
                readerAndWriteProduct.Write(products);
                System.out.println("Ghi thành công");
                break;
            case 8:
        }
    }

    public void show() {
        for (int i = 0; i < products.size(); i++) {
            if ((i+1) % 5 == 0) {
                System.out.println(products.get(i));
                scanner.nextLine();
            } else {
                System.out.println(products.get(i));
            }
        }
    }

    public Product createProduct() {
        int id = validateProduct.validateID(products);
        String name = validateProduct.validateString("name :");
        int quantity = validateProduct.validateQuantity();
        double price = validateProduct.validatePricce();
        String describe = validateProduct.validateString("describe :");
        return new Product(id, name,price,quantity,describe );
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void editProduct() {
        System.out.println("Nhập id cần sửa");
        int id = Integer.parseInt(scanner.nextLine());
        int index = validateProduct.getIndexId(id, products);
        if (index != -1){
            products.set(index, createProduct());
        } else {
            System.err.println("id không tồn tại");
        }
    }

    public void deleteProduct() {
        System.out.println("Nhập id cần xóa");
        int id = Integer.parseInt(scanner.nextLine());
        int index = validateProduct.getIndexId(id, products);
        if (index != -1){
            products.remove(index);
        } else {
            System.err.println("id không tồn tại");
        }
    }

    public void sortByScore(){
        products.sort(new SortByPrice());
        System.out.println("sắp xếp thành công");
    }

}
