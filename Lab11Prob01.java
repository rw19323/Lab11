/**
* File: Lab11Prob01.java
* Class: CSCI 1302
* Author: TJ White, Amin Mohammad Wasiuzzaman
* Created on: Apr 25, 2025
* Last Modified: Apr 25, 2025
* Description: Working with binary files
*/

import java.io.*;

public class Lab11Prob01 {
	public static void main(String[] args) {
        String inputFile = "src/people.dat";
        String outputFile = "src/people-copy.dat";

        try (
            DataInputStream dis = new DataInputStream(new FileInputStream(inputFile));
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(outputFile));
        ) {
            while (true) {
                try {
                    int age = dis.readInt();
                    String name = dis.readUTF();
                    String address = dis.readUTF();
                    int zip = dis.readInt();
                    double salary = dis.readDouble();

                    // Print to console
                    System.out.println("Age: " + age);
                    System.out.println("Name: " + name);
                    System.out.println("Address: " + address);
                    System.out.println("Zip: " + zip);
                    System.out.println("Salary: $" + salary);
                    System.out.println("----------------------------");

                    // Write to output file
                    dos.writeInt(age);
                    dos.writeUTF(name);
                    dos.writeUTF(address);
                    dos.writeInt(zip);
                    dos.writeDouble(salary);

                } catch (EOFException eof) {
                    break; // End of file reached
                }
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("File not found: " + fnf.getMessage());
        } catch (IOException io) {
            System.out.println("I/O error: " + io.getMessage());
            io.printStackTrace();
        }
    }
}
