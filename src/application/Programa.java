package application;

import model.entities.Departamento;

public class Programa {
    public static void main(String[] args) {
        Departamento departamento = new Departamento(1, "Books");
        System.out.println(departamento);
    }
}