package com.codegym.controller;

import com.codegym.model.ContactBook;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static com.codegym.Main.*;

public class ContactBookManger implements ReadWriteCsv<ContactBook> {

    List<ContactBook> listBook = new LinkedList<>();

    public List<ContactBook> getListBook() {
        return listBook;
    }

    public void setListBook(List<ContactBook> listBook) {
        this.listBook = listBook;
    }

    public void showContacts() {
        int count = 0;
        for (ContactBook contact : listBook) {
            System.out.println(contact);
            count++;
            if (count == 5) {
                count = 0;
                input.nextLine();
            }
        }
    }

    public void addContact(ContactBook contact) {
        listBook.add(contact);
    }

    public void updateContact(int number, ContactBook contact) {
        int index = findNumberPhone(number);
            listBook.set(index, contact);

    }

    public void removeContact(int numberPhone) {
        int index = findNumberPhone(numberPhone);
            listBook.remove(index);
    }

    public int findNumberPhone(int numberPhone) {
        int index = -1;
        for (int i = 0; i < listBook.size(); i++) {
            if (listBook.get(i).getNumberPhone() == numberPhone) {
                return index = i;
            }
        }
        return index;
    }

    public ContactBook findByName(String name) {
        for (ContactBook contact : listBook) {
            if (contact.getFullName().contains(name))
                return contact;
        }
        return null;
    }

    @Override
    public void writeFileCsv(ContactBook contact) {

        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(contact + DOWN_THE_LINE);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void readFileCsv() {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            System.err.println("Tệp không tồn tại hoặc xảy ra lỗi!");
        }
    }


}
