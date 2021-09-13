package com.codegym.controller;

import java.io.File;

public interface ReadWriteCsv<E> {
    File file = new File("contacts.csv");
    String DOWN_THE_LINE = "\n";

    void writeFileCsv(E product);

    void readFileCsv();
}
