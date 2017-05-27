package com.crazyhoorse961.scalavote.inventories

import java.util

import net.md_5.bungee.api.ChatColor
import org.bukkit.Material
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

/**
  * Created by nini7 on 27.05.2017.
  */
class ItemUtils {

  def fromConfig(section : ConfigurationSection): ItemStack = {
    val toReturn : ItemStack = new ItemStack(Material.valueOf(section.getString("material").toUpperCase), 1, java.lang.Short.valueOf(section.getString("data")))
    val is : ItemMeta = toReturn.getItemMeta
    is.setDisplayName(ChatColor.translateAlternateColorCodes('&', section.getString("name")))
    is.setLore(util.Arrays.asList(ChatColor.translateAlternateColorCodes('&', section.getString("lore"))))
    toReturn.setItemMeta(is)
    return toReturn
  }
}
