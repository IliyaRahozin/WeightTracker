package com.tracker.Model.Dao;

import com.tracker.Model.Entities.LifeStyle;

import java.sql.*;
import java.util.ArrayList;

public class LifeStyleDao implements IDao<LifeStyle> {
    final static private String SELECT = "select * from lifestyle where id = ?";
    final static private String SELECTALL = "select * from lifestyle";
    final static private String INSERT = "insert into lifestyle (type) values(?)";
    final static private String DELETE = "delete from lifestyle where id = ?";
    final static private String UPDATE = "update lifestyle set type = ? where id = ?";
    @Override
    public LifeStyle findById(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new LifeStyle(
                    rs.getInt(1),
                    rs.getString(2)
            );
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<LifeStyle> findAll() {
        ArrayList<LifeStyle> faculties = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            Statement ps = c.createStatement();
            ResultSet rs = ps.executeQuery(SELECTALL);
            while(rs.next()){
                faculties.add(new LifeStyle(
                        rs.getInt(1),
                        rs.getString(2))
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return faculties;
    }

    @Override
    public void add(LifeStyle entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(INSERT);
            ps.setString(1, entity.type());
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
    public void update(LifeStyle entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(UPDATE);
            ps.setString(1, entity.type());
            ps.setInt(2, entity.id());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
