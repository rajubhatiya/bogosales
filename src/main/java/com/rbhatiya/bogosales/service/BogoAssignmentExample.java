package com.rbhatiya.bogosales.service;

import java.util.*;

/**
 * Assignment: Buy one Get one Free in Python
 * The Big Diwali Sale:
 * The Diwali sale is approaching. The marketing team has decided to run a campaign called
 * “BOGO” - Buy one Get one Free. Customers can buy any number of products.
 * Offer Rules: Customers can buy one product and get another product for free as long as the
 */
public class BogoAssignmentExample {

    public static void main(String[] args) {
//        System.out.println("----Rule1----");
//        bogoAssignmentRule1();
//        System.out.println("\n\n----Rule2----");
//        bogoAssignmentRule2();
//        System.out.println("\n\n----Rule3----");
//        bogoAssignmentRule3();

    }

    /**
     *
     * @param productPrice
     * @param productPriceList
     * @return
     */
    public static int calculateDiscount(int productPrice, ArrayList<Integer> productPriceList) {
        int discout = 0;

        for (int i = productPriceList.size() - 1; i >= 0; i--) {
            int pl = productPriceList.get(i);
            for (int j = 0; j < productPriceList.size(); j++) {
                discout += productPriceList.get(j);
                if (pl == discout) {
                    discout += pl;
                    return discout;
                }
            }
        }
        return 0;
    }


    /**
     * Offer Rules: Customers can buy one product and get another product for free as long as the
     * price of the product is equal to or less than the price of the first product.
     * Customer Objective: Discount maximization for Customers. The customer’s objective is to
     * create a pair of 2 items so that the discount is maximized.
     * Example1:
     * Input:
     * Product Price List = [ 10,20,30,40,50,60 ]
     * Output:
     * Discounted Items = [50,30,10]
     * Payable Items = [60,40,20]
     * Example 2:
     * Input:
     * Product Price List = [ 10,20,30,40,50,50,60 ]
     * Output:
     * Discounted Items = [50,40,20]
     * Payable Items = [60,50, 30,10]
     */
    public static void bogoAssignmentRule1(){
        ArrayList<Integer> productPriceList1 = new ArrayList<Integer>(
                Arrays.asList(10, 20, 30, 40, 50, 60));
        ArrayList<Integer> productPriceList2 = new ArrayList<Integer>(
                Arrays.asList(10, 20, 30, 40, 50, 60));
        System.out.println("Example 1:");
        calculateDiscountedAndPayableItems1(productPriceList1);
        System.out.println("\nExample 2:");
        calculateDiscountedAndPayableItems1(productPriceList2);

    }
    public static void calculateDiscountedAndPayableItems1(List<Integer> productPriceList) {
        List<Integer> discountedItems = new ArrayList<>();
        List<Integer> payableItems = new ArrayList<>();

        // Sort the product price list in descending order
        Collections.sort(productPriceList, Collections.reverseOrder());

        for (int i = 0; i < productPriceList.size(); i++) {
            // If the current item is the last one or its price is not less than the next item's price,
            // add it to the payable items list
            if (i == productPriceList.size() - 1 || productPriceList.get(i) >= productPriceList.get(i + 1)) {
                payableItems.add(productPriceList.get(i));
            } else {
                // Otherwise, add the current and next items to the discounted items list
                discountedItems.add(productPriceList.get(i));
                discountedItems.add(productPriceList.get(i + 1));
                // Skip the next item as it's already paired
                i++;
            }
        }

        System.out.println("Discounted Items = " + discountedItems);
        System.out.println("Payable Items = " + payableItems);
    }

    /**
     * Offer Rule 2: Customers can buy one product and get another product for free as long as the
     * price of the product is less than the price of the corresponding product in pairs.
     * Example 1 :
     * Input:
     * Product Price List = [ 10,20,30,40,40,50,60,60 ]
     * Output:
     * Discounted Items = [50,40,30,10]
     * Payable Items = [60,60,40, 20]
     *
     * Example 2:
     * Input:
     * Product Price List = [ 10,20,30,40,50,50,50,60 ]
     * Output:
     * Discounted Items = [50,40,30,10]
     * Payable Items = [60,50,50,,20]
     */
    public static void bogoAssignmentRule2(){
        ArrayList<Integer> productPriceList1 = new ArrayList<Integer>(
                Arrays.asList(10, 20, 30, 40, 50, 60));
        ArrayList<Integer> productPriceList2 = new ArrayList<Integer>(
                Arrays.asList(10, 20, 30, 40, 50, 60));
        System.out.println("Example 1:");
        calculateDiscountedAndPayableItems2(productPriceList1);
        System.out.println("\nExample 2:");
        calculateDiscountedAndPayableItems2(productPriceList2);
    }

    public static void calculateDiscountedAndPayableItems2(List<Integer> productPriceList) {
        List<Integer> discountedItems = new ArrayList<>();
        List<Integer> payableItems = new ArrayList<>();

        // Sort the product price list in descending order
        Collections.sort(productPriceList, Collections.reverseOrder());

        for (int i = 0; i < productPriceList.size(); i += 2) {
            if (i + 1 < productPriceList.size() && productPriceList.get(i) > productPriceList.get(i + 1)) {
                discountedItems.add(productPriceList.get(i));
                discountedItems.add(productPriceList.get(i + 1));
            } else {
                payableItems.add(productPriceList.get(i));
                if (i + 1 < productPriceList.size()) {
                    payableItems.add(productPriceList.get(i + 1));
                }
            }
        }

        System.out.println("Discounted Items = " + discountedItems);
        System.out.println("Payable Items = " + payableItems);
    }


    /**
     *
     Offer Rule 3: Customers can buy two products and get two products for free as long as the
     price of the product is less than the price of the first product.
     Example1:
     Input:
     Product Price List = [ 10,20,30,40,40,50,60,60 ]
     Output:
     Discounted Items = [50,40,30,10]
     Payable Items = [60,60,40, 20]
     Example1:
     Input:
     Product Price List = [ 5,5,10,20,30,40,50,50,50,60 ]
     Output:
     Discounted Items = [50,40,30,10]
     Payable Items = [60,50,50,,20,5,5]

     */

    public static void bogoAssignmentRule3(){
        ArrayList<Integer> productPriceList1 = new ArrayList<Integer>(
                Arrays.asList(10, 20, 30, 40, 50, 60));
        ArrayList<Integer> productPriceList2 = new ArrayList<Integer>(
                Arrays.asList(10, 20, 30, 40, 50, 60));

        System.out.println("Example 1:");
        calculateDiscountedAndPayableItems3(productPriceList1);
        System.out.println("\nExample 2:");
        calculateDiscountedAndPayableItems3(productPriceList2);

    }

    public static void calculateDiscountedAndPayableItems3(List<Integer> productPriceList) {
        List<Integer> discountedItems = new ArrayList<>();
        List<Integer> payableItems = new ArrayList<>();

        // Sort the product price list in descending order
        Collections.sort(productPriceList, Collections.reverseOrder());

        for (int i = 0; i < productPriceList.size(); i += 4) {
            for (int j = i; j < i + 4 && j < productPriceList.size(); j++) {
                if (j > i && productPriceList.get(j) < productPriceList.get(i)) {
                    discountedItems.add(productPriceList.get(j));
                } else {
                    payableItems.add(productPriceList.get(j));
                }
            }
        }

        System.out.println("Discounted Items = " + discountedItems);
        System.out.println("Payable Items = " + payableItems);
    }

}
