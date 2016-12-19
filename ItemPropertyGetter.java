package com.amaysim;

public class ItemPropertyGetter {

	// The ff properties ideally should come from an xml file for example, or a database
	public static final String[] PRODUCT_CODE_STR = {
		"ult_small",
		"ult_medium",
		"ult_large",
		"1gb"
	};
	
	public static final String[] PRODUCT_NAMES = {
		"Unlimited 1GB",
		"Unlimited 2GB",
		"Unlimited 5GB",
		"1GB Data-pack"
	};
	
	public static final double[] PRODUCT_PRICES = {
			24.9,
			29.9,
			44.9,
			9.9
		};
		
	public static double getPrice(ProductCode code)
	{
		return PRODUCT_PRICES[code.ordinal()];
	}
	
	public static String getName(ProductCode code)
	{
		return PRODUCT_NAMES[code.ordinal()];
	}
	
	public static String getCodeStr(ProductCode code)
	{
		return PRODUCT_CODE_STR[code.ordinal()];
	}
}
