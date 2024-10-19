package rating;
import DbConnection.DbConnection;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
public class RatingDAO {
    // Retrieve all ratings from the database
    public List<Rating> getAllRatings() {
        List<Rating> ratingList = new ArrayList<>();
        try {
            Connection con = DbConnection.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM rating");
            while (rs.next()) {
                Rating rt = new Rating(
                    rs.getInt("rating_id"),
                    rs.getInt("order_id"),
                    rs.getString("stars"),
                    rs.getString("comment")
                );
                ratingList.add(rt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ratingList;
    }

    // Insert a new rating into the database
    public boolean insertRating(Rating rating) {
        String query = "INSERT INTO rating (order_id, stars, comment) VALUES (?, ?, ?)";
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, rating.getOrderID());
            ps.setString(2, rating.getRating());
            ps.setString(3, rating.getReview());

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update an existing rating
    public boolean updateRating(Rating rating) {
        String query = "UPDATE rating SET stars = ?, comment = ? WHERE rating_id = ?";
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, rating.getRating());
            ps.setString(2, rating.getReview());
            ps.setInt(3, rating.getRatingID());

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a rating from the database
    public void deleteRating(int ratingID) {
        String query = "DELETE FROM rating WHERE rating_id = ?";
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, ratingID);

            int result = ps.executeUpdate();
            if(result > 0) {
            	System.out.println("Succeffully deleted");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    // Retrieve a rating by ID
    public Rating getRatingById(int ratingID) {
        String query = "SELECT * FROM rating WHERE rating_id = ?";
        Rating rating = null;
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, ratingID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                rating = new Rating(
                    rs.getInt("rating_id"),
                    rs.getInt("order_id"),
                    rs.getString("stars"),
                    rs.getString("comment")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rating;
    }
}

