package io;

import models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWriteProduct {
    File file = new File("D:\\java\\Bai_Thi_Thu_C0322g1-e76f52115191bbcbb6dbd651ce6af89d794f28cc\\src\\data\\product.csv");

    public void Write(List<Product> products) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("id,name,price,quantity,describe");
            bufferedWriter.newLine();
            for (Product s : products) {
                bufferedWriter.write(s.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> reader() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                double price = Double.parseDouble(arr[2]);
                int quantity = Integer.parseInt(arr[3]);
                String describe = arr[4];

                products.add(new Product(id, name, price, quantity, describe));
            }

            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
