package com.amaysim;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class Cart {
	
	private PricingRule pricingRule;	
	private Map<ProductCode, ItemGroup> subTotalList = new Hashtable<ProductCode, ItemGroup>();	
	private String promoCode = "";

	
	public Cart()
	{
		
	}
	
	public Cart(PricingRule pricingRule)
	{
		this.pricingRule = pricingRule;
	}
		
	public void add(ProductCode code)
	{
		if (!subTotalList.containsKey(code))
		{
			subTotalList.put(code, new ItemGroup());
		}		
		pricingRule.applyRule(code,subTotalList);
	}

	
	public void add(ProductCode code, String promoCode)
	{
		add(code);
		this.promoCode = promoCode;
	}
	
	public double getTotal()
	{		
		double total = 0.0;		
		Iterator<ItemGroup> it = subTotalList.values().iterator();
		
		while (it.hasNext())
		{
			total += it.next().getSubtotal();
		}		
		if (promoCode != "")
			total = pricingRule.applyPromo(promoCode, total);		
		return total;
	}
	
	public void printItems()
	{
		Iterator<ProductCode> it = subTotalList.keySet().iterator();
		
		while (it.hasNext())
		{
			ProductCode code = it.next();
			ItemGroup sub = subTotalList.get(code);
			System.out.println(sub.getCount() + " x " + ItemPropertyGetter.getName(code));
		}
		
	}
};