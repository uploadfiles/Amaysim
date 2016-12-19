package com.amaysim;

import java.util.Map;

public interface PricingRule {	
	public void applyRule(ProductCode code, Map<ProductCode, ItemGroup> subTotalList);	
	public double applyPromo(String promoCode, double origTotal);
}
