package promotion;

import java.sql.Date;
import java.util.Scanner;
import java.util.Set;

import Customer.Customer;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import Exceptions.*;

public class PromotionUtility {

    private PromotionDAO promotionDAO;
    private static List<Promotion> promotionList = new ArrayList();
   

    // Get all promotions and handle exceptions
    public void fetchAllPromotions() {
    	promotionList = promotionDAO.getAllPromotions();
        System.out.format("%-5s %-20s %-30s %s\n", "ID", "Name", "Description", "End Date");
        for (Promotion p : promotionList) {
            System.out.format("%-5s %-20s %-30s %s\n", p.getPromotionId(), p.getRestaurantId(), p.getPromotionDetails(), p.getStartDate(),p.getEndDate());
        }
    }

    // Fetch a promotion by ID
    public void fetchPromotionById() {
    	Scanner s=new Scanner(System.in);
    	int promotionId=s.nextInt();
    	
        try {
        	PromotionDAO p=new PromotionDAO();
            Promotion promotion=p.getPromotionById(promotionId);
        } catch (PromotionNotFoundException e) {
            System.out.println("Promotion not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error fetching promotion: " + e.getMessage());
        }
    }

    // Add a new promotion
    public void addNewPromotion() {
        Scanner s = new Scanner(System.in);
        try {
            int promotionId = idGeneration();
            System.out.println("Generated promotion ID is: " + promotionId);
            System.out.println("Enter the restaurant ID:");
            int restaurantId = s.nextInt();
            s.nextLine();
            System.out.println("Enter promotion details:");
            String promotionDetails = s.nextLine();
            System.out.println("Enter promotion start date (YYYY-MM-DD):");
            String startDateStr = s.nextLine();
            Date startDate = Date.valueOf(startDateStr);
            System.out.println("Enter promotion end date (YYYY-MM-DD):");
            String endDateStr = s.nextLine();
            Date endDate = Date.valueOf(endDateStr);
            Promotion promotion = new Promotion(promotionId, restaurantId, promotionDetails, startDate, endDate);
            promotionList.add(promotion);       
            boolean isInserted = promotionDAO.insertPromotion(promotion);
            if (isInserted) {
                System.out.println("Promotion added successfully!");
            }
        } catch (Exception e) {
            System.out.println("Error adding promotion: " + e.getMessage());
        }
    }

    private int idGeneration() {
        Set<Integer> set = new HashSet<>();
        for (Promotion promotion :promotionList) {
            set.add(promotion.getPromotionId());
        }
        Random rand = new Random();
        int id = rand.nextInt(10, 100);
        while (set.contains(id)) {
            id = rand.nextInt(10, 100);
        }
        return id;
    }


    // Delete a promotion by ID
    public void removePromotion() {
    	Scanner s=new Scanner(System.in);
        try {
        	System.out.println("Enter the promotion id");
        	int promotionId=s.nextInt();
            promotionDAO.deletePromotion(promotionId);
            System.out.println("Promotion removed successfully!");
        } catch (PromotionNotFoundException e) {
            System.out.println("Promotion not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error deleting promotion: " + e.getMessage());
        }
    }

    // Check if a promotion has expired
    public void validatePromotionExpiry() throws PromotionNotFoundException{
    	Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter Promotion ID:");
            int promotionId = s.nextInt();
            s.nextLine();
            Promotion promotion = null;
            for (Promotion p : promotionList) {
                if (p.getPromotionId() == promotionId) {
                    promotion = p;
                    break;
                }
            }
            if (promotion == null) {
                throw new PromotionNotFoundException("Promotion not found");
            }
            if (isPromotionExpired(promotion)) {
                System.out.println("The promotion is expired.");
            } else {
                System.out.println("The promotion is still valid.");
            }
        } catch (PromotionExpiredException e) {
            System.out.println("Promotion expired: " + e.getMessage());
        } catch (PromotionNotFoundException e) {
            System.out.println("Promotion not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error checking promotion expiry: " + e.getMessage());
        }    }
    public boolean isPromotionExpired(Promotion promotion) throws PromotionExpiredException {
        Date currentDate = new Date(System.currentTimeMillis());
        if (promotion.getEndDate().before(currentDate)) {
            throw new PromotionExpiredException("ID " + promotion.getPromotionId());
        }
        return false;
    }
}

