package com.amaysim;

public class Main {

	public static void main(String[] args) {
		scenario1();
		scenario2();
		scenario3();
		scenario4();
	}
	
	public static void scenario1()
	{
		System.out.println("Scenario 1");
		Cart cart = new Cart(new OpeningPricingRule());
		cart.add(ProductCode.ULT_SMALL);
		cart.add(ProductCode.ULT_SMALL);
		cart.add(ProductCode.ULT_SMALL);	
		cart.add(ProductCode.ULT_LARGE);
		System.out.println("Total is " + cart.getTotal());
		cart.printItems();
		System.out.println("===========================================================");
		System.out.println();
	}
	
	public static void scenario2()
	{
		System.out.println("Scenario 2");
		Cart cart = new Cart(new OpeningPricingRule());

		cart.add(ProductCode.ULT_SMALL);
		cart.add(ProductCode.ULT_SMALL);
		
		cart.add(ProductCode.ULT_LARGE);		
		cart.add(ProductCode.ULT_LARGE);
		cart.add(ProductCode.ULT_LARGE);
		cart.add(ProductCode.ULT_LARGE);
		System.out.println("Total is " + cart.getTotal());
		cart.printItems();
		System.out.println("===========================================================");
		System.out.println();
	}
	
	public static void scenario3()
	{
		System.out.println("Scenario 3");
		Cart cart = new Cart(new OpeningPricingRule());

		cart.add(ProductCode.ULT_SMALL);
		cart.add(ProductCode.ULT_MEDIUM);
		cart.add(ProductCode.ULT_MEDIUM);		
		System.out.println("Total is " + cart.getTotal());
		cart.printItems();
		System.out.println("===========================================================");
		System.out.println();
		
	}

	public static void scenario4()
	{
		System.out.println("Scenario 4");
		Cart cart = new Cart(new OpeningPricingRule());

		cart.add(ProductCode.ULT_SMALL);
		cart.add(ProductCode.DP_1GB,
				OpeningPricingRule.PROMO_CODE_I_HEART_AMAYSIM);	
		System.out.println("Total is " + cart.getTotal());
		cart.printItems();
		System.out.println("===========================================================");
		System.out.println();		
	}

}
