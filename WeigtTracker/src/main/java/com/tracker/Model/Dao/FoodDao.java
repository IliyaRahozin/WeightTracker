package com.tracker.Model.Dao;

import com.tracker.Model.Entities.Food;
import com.tracker.Model.Entities.User;

import java.sql.*;
import java.util.ArrayList;

public class FoodDao implements IDao<Food> {
    final static private String SELECT = "select * from food where id = ?";
    final static private String SELECTALL = "select * from food";
    final static private String INSERT = "insert into food (name, calories, proteins, fats, carbohydrates) values(?, ?, ?, ?, ?)";
    final static private String DELETE = "delete from food where id = ?";
    final static private String UPDATE = "update food set name = ?, calories = ?, proteins = ?, fats = ?, carbohydrates = ? where id = ?";
    @Override
    public Food findById(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Food(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getInt(6));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Food> findAll() {
        ArrayList<Food> foods = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            Statement ps = c.createStatement();
            ResultSet rs = ps.executeQuery(SELECTALL);
            while(rs.next()){
                foods.add(new Food(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6))
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return foods;
    }

    @Override
    public void add(Food entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(INSERT);
            ps.setString(1, entity.name());
            ps.setInt(2, entity.calories());
            ps.setInt(3, entity.proteins());
            ps.setInt(4, entity.fats());
            ps.setInt(5, entity.carbohydrates());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Food entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(UPDATE);
            ps.setString(1, entity.name());
            ps.setInt(2, entity.calories());
            ps.setInt(3, entity.proteins());
            ps.setInt(4, entity.fats());
            ps.setInt(5, entity.carbohydrates());
            ps.setInt(6, entity.id());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
