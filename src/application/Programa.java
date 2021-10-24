package application;

import model.dao.DAOFactory;
import model.dao.VendedorDAO;
import model.entities.Departamento;
import model.entities.Vendedor;

import java.util.Date;

public class Programa {
    public static void main(String[] args) {
        Departamento departamento = new Departamento(1, "Books");
        System.out.println(departamento);

        Vendedor vendedor = new Vendedor(21, "Bob", "bob@gmail.com", new Date(), 3000.00, departamento);
        System.out.println(vendedor);

        VendedorDAO vendedorDAO = DAOFactory.criarVendedorDAO();
    }
}