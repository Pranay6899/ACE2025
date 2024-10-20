package promotion;
import DbConnection.DbConnection;

import Exceptions.*;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class PromotionDAO {

    // Retrieve all promotions from the database
    public List<Promotion> getAllPromotions() {
        List<Promotion> promotions = new ArrayList<>();
        try {
            Connection con = DbConnection.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Promotion");

            while (rs.next()) {
                Promotion promotion = new Promotion(
                    rs.getInt("promotion_id"), 
                    rs.getInt("restaurant_id"), 
                    rs.getString("promotion_details"), 
                    rs.getDate("start_date"), 
                    rs.getDate("end_date")
                );
                promotions.add(promotion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return promotions;
    }

    // Retrieve a promotion by ID
    public Promotion getPromotionById(int promotionId) throws PromotionNotFoundException {
        String query = "SELECT * FROM Promotion WHERE promotion_id = ?";
        Promotion promotion = null;
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, promotionId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                promotion = new Promotion(
                    rs.getInt("promotion_id"), 
                    rs.getInt("restaurant_id"), 
                    rs.getString("promotion_details"), 
                    rs.getDate("start_date"), 
                    rs.getDate("end_date")
                );
            } else {
                throw new PromotionNotFoundException("ID " + promotionId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return promotion;
    }

    // Insert a new promotion into the database
    public boolean insertPromotion(Promotion promotion) {
        String query = "INSERT INTO Promotion (promotion_id, restaurant_id, promotion_details, start_date, end_date) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, promotion.getPromotionId());
            ps.setInt(2, promotion.getRestaurantId());
            ps.setString(3, promotion.getPromotionDetails());
            ps.setDate(4, new java.sql.Date(promotion.getStartDate().getTime()));
            ps.setDate(5, new java.sql.Date(promotion.getEndDate().getTime()));


            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update an existing promotion
    public boolean updatePromotion(Promotion promotion) throws PromotionNotFoundException {
        String query = "UPDATE Promotion SET promotion_details = ?, start_date = ?, end_date = ? WHERE promotion_id = ?";
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, promotion.getPromotionDetails());
            ps.setDate(2, new java.sql.Date(promotion.getStartDate().getTime()));
            ps.setDate(3, new java.sql.Date(promotion.getEndDate().getTime()));
            ps.setInt(4, promotion.getPromotionId());

            int result = ps.executeUpdate();
            if (result > 0) {
                return true;
            } else {
                throw new PromotionNotFoundException("ID " + promotion.getPromotionId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a promotion
    public void deletePromotion(int promotionId) throws PromotionNotFoundException {
        String query = "DELETE FROM Promotion WHERE promotion_id = ?";
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, promotionId);
            int result = ps.executeUpdate();

            if (result == 0) {
                throw new PromotionNotFoundException("ID " + promotionId);
            } else {
                System.out.println("Promotion with ID " + promotionId + " deleted successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
