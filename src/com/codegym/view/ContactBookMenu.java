package com.codegym.view;

import com.codegym.controller.ContactBookManger;
import com.codegym.model.ContactBook;
import com.codegym.model.ContactGroup;

import static com.codegym.Main.*;

public class ContactBookMenu {
    ContactBookManger contactBookManger = new ContactBookManger();
    int select;

    public void run() {
        do {
            showMenu();
            select = input.nextInt();
            switch (select) {
                case 1:
                    showContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    int numberPhone;
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContactByName();
                    break;
                case 6:
                    readToFile();
                    break;
                case 7:
                    saveToFile();
                    break;
            }

        } while (select != 8);
    }

    private void readToFile() {
        contactBookManger.readFileCsv();
    }

    private void searchContactByName() {
        System.out.print("Nhập tên cần tìm: ");
        String name = input.nextLine();
        input.nextLine();
        if(contactBookManger.findByName(name)!=null)
            System.out.println(contactBookManger.findByName(name).toString());
        else
            System.out.println("không tìm thấy tên trong danh bạ");
        return;
    }

    private void removeContact() {
        int numberPhone;
        numberPhone = inputNumberPhone();
        if (contactBookManger.findNumberPhone(numberPhone)>=0)
        contactBookManger.removeContact(inputNumberPhone());
    }

    private void updateContact() {
        int numberPhone = inputNumberPhone();
        if(contactBookManger.findNumberPhone(numberPhone)>=0)
        contactBookManger.updateContact(numberPhone, addContactNew());
        else
            System.out.println("Không tìm thấy số điện thoại trong danh bạ");
    }

    private void addContact() {
        contactBookManger.addContact(addContactNew());
    }

    private void showContacts() {
        contactBookManger.showContacts();
    }

    private void saveToFile() {
        System.out.print("You want to save changes? y/n:");
        input.nextLine();
        String changes = input.nextLine();
        if (changes.equals("y")) {
            for (ContactBook contact : contactBookManger.getListBook()) {
                contactBookManger.writeFileCsv(contact);
            }
        }

    }

    public int inputNumberPhone() {
        System.out.print("Nhập số điện thoại: ");
        int numberPhone = input.nextInt();
        return numberPhone;
    }

    public ContactBook addContactNew() {
        int numberPhone = inputNumberPhone();
        input.nextLine();
        System.out.print("Nhập họ và tên: ");
        String fullName = input.nextLine();
        System.out.print("Nhập giới tính: ");
        String gender = input.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = input.nextLine();
        System.out.print("Nhập nhóm liên lạc: ");
        String nameGroup = input.nextLine();
        ContactGroup contactGroup = new ContactGroup();
        contactGroup.setNameGroup(nameGroup);
        return new ContactBook(numberPhone, fullName, gender, address, contactGroup);

    }

    public void showMenu() {
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1.Xem danh sách");
        System.out.println("2.Thêm mới");
        System.out.println("3.Cập nhật");
        System.out.println("4.Xóa");
        System.out.println("5.Tìm Kiếm");
        System.out.println("6.Đọc từ file");
        System.out.println("7.Ghi vào file");
        System.out.println("8.Thoát");
        System.out.print("Chọn chức năng: ");
    }
}
