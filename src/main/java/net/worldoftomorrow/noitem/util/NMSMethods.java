package net.worldoftomorrow.noitem.util;

import org.bukkit.craftbukkit.v1_4_R1.inventory.CraftItemStack;

import net.minecraft.server.v1_4_R1.Item;
import net.minecraft.server.v1_4_R1.PotionBrewer;
import net.minecraft.server.v1_4_R1.ItemStack;

public class NMSMethods {
	
	public static int getPotionResult(int origdata, org.bukkit.inventory.ItemStack ingredient) {
		return getPotionResult(origdata, CraftItemStack.asNMSCopy(ingredient));
	}
	
	private static int getPotionResult(int origdata, ItemStack ingredient) {
		
		int newdata = getBrewResult(origdata, ingredient);
		
		if((origdata <= 0 || origdata != newdata)) {
			return origdata != newdata ? newdata : origdata;
		} else {
			return origdata;
		}
	}
	
	private static int getBrewResult(int i, ItemStack itemstack) {
        return itemstack == null ? i : (Item.byId[itemstack.id].v() ? PotionBrewer.a(i, Item.byId[itemstack.id].u()) : i);
    }
}
