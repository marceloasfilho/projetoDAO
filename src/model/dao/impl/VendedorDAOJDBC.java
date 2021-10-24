package model.dao.impl;

import db.DB;
import db.DBException;
import model.dao.VendedorDAO;
import model.entities.Departamento;
import model.entities.Vendedor;

import java.sql.*;
import java.util.List;

public class VendedorDAOJDBC implements VendedorDAO {

    private Connection connection;

    public VendedorDAOJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Vendedor vendedor) {

    }

    @Override
    public void update(Vendedor vendedor) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Vendedor findById(Integer id) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT seller.*,department.Name as DepartamentName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id WHERE seller.Id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                Integer DepartmentId = resultSet.getInt("DepartmentId");
                String departmentName = resultSet.getString("DepartamentName");

                Departamento departamento = new Departamento(DepartmentId, departmentName);

                Integer vendedorId = resultSet.getInt("Id");
                String vendedorName = resultSet.getString("Name");
                String vendedorEmail = resultSet.getString("Email");
                Double vendedorSalarioBase = resultSet.getDouble("BaseSalary");
                Date vendedorBirthDate = resultSet.getDate("BirthDate");

                Vendedor vendedor = new Vendedor(vendedorId, vendedorName, vendedorEmail, vendedorBirthDate, vendedorSalarioBase, departamento);
                return vendedor;
            }

            return null;

        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }
    }

    @Override
    public List<Vendedor> findAll() {
        return null;
    }
}
