package com.codegym;

import com.codegym.controller.ContactBookManger;
import com.codegym.model.ContactBook;
import com.codegym.model.ContactGroup;
import com.codegym.view.ContactBookMenu;

import java.util.Scanner;

public class Main {
   public static Scanner input = new Scanner(System.in);

   public static void main(String[] args) {
      ContactBookMenu contactBookMenu = new ContactBookMenu();
      contactBookMenu.run();

   }
}
