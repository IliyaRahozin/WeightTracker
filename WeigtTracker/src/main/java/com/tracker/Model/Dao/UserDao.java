package com.tracker.Model.Dao;

import com.tracker.Model.Entities.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDao implements IDao<User> {
    final static private String SELECT = "select * from user where id = ?";
    final static private String SELECTALL = "select * from user";
    final static private String INSERT = "insert into user (username, password, age, height, weight, lifestyle) values(?, ?, ?, ?, ?, ?)";
    final static private String DELETE = "delete from user where id = ?";
    final static private String UPDATE = "update user set username = ?, password = ?, age = ?, height = ?, weight = ?, lifestyle = ? where id = ?";
    @Override
    public User findById(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new User(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getInt(6),
                    rs.getInt(7));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<User> findAll() {
        ArrayList<User> users = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            Statement ps = c.createStatement();
            ResultSet rs = ps.executeQuery(SELECTALL);
            while(rs.next()){
                users.add(new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7))
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void add(User entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(INSERT);
            ps.setString(1, entity.username());
            ps.setString(2, entity.password());
            ps.setInt(3, entity.age());
            ps.setInt(4, entity.height());
            ps.setInt(5, entity.weight());
            ps.setInt(6, entity.lifestyle());
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
    public void update(User entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(UPDATE);
            ps.setString(1, entity.username());
            ps.setString(2, entity.password());
            ps.setInt(3, entity.age());
            ps.setInt(4, entity.height());
            ps.setInt(5, entity.weight());
            ps.setInt(6, entity.lifestyle());
            ps.setInt(7, entity.id());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
