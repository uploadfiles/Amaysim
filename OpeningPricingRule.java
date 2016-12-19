package com.amaysim;

import java.util.Map;

public class OpeningPricingRule implements PricingRule {	
	
	public static final double ULT_LARGE_MORETHAN3_PRICE = 39.9;	
	public static final String PROMO_CODE_I_HEART_AMAYSIM = "I<3AMAYSIM";
	public static final double PROMO_DISCOUNT_I_HEART_AMAYSIM = .10;
	
	@Override
	public void applyRule(ProductCode code, Map<ProductCode, ItemGroup> subTotalList)
	{	
		int count = subTotalList.get(code).getCount() + 1;
		subTotalList.get(code).setCount(count);

		if (code == ProductCode.ULT_SMALL)
		{
			if (count % 3 != 0)
			{
				addOrigPrice(code, subTotalList);
			}
		}
		if (code == ProductCode.ULT_LARGE)
		{
			if (count > 3)
			{
				subTotalList.get(code).setSubtotal(count * ULT_LARGE_MORETHAN3_PRICE);
			}
				else
			{
				addOrigPrice(code, subTotalList);
			}
		}
		if (code == ProductCode.ULT_MEDIUM)
		{
			addOrigPrice(code, subTotalList);
			if (!subTotalList.containsKey(ProductCode.DP_1GB))
			{
				subTotalList.put(ProductCode.DP_1GB, new ItemGroup());
			}
			subTotalList.get(ProductCode.DP_1GB).setCount(count++);;
		}
		if (code == ProductCode.DP_1GB)
		{
			addOrigPrice(code, subTotalList);
		}
	}
	
	@Override
	public double applyPromo(String promoCode, double origTotal) {
		double total = 0.0;
		if (promoCode == PROMO_CODE_I_HEART_AMAYSIM)
		{
			total = origTotal * (1 - PROMO_DISCOUNT_I_HEART_AMAYSIM);
		}
		return total;
	}
	
	private void addOrigPrice(ProductCode code, Map<ProductCode, ItemGroup> subTotalList)
	{
		subTotalList.get(code).setSubtotal(subTotalList.get(code).getSubtotal() + 
				ItemPropertyGetter.getPrice(code));
	}	
}
