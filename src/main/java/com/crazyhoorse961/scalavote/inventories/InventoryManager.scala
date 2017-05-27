package com.crazyhoorse961.scalavote.inventories

import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory

/**
  * Created by nini7 on 27.05.2017.
  */
class InventoryManager {

  var mainInventory : Inventory = null

  def getMainInventory = mainInventory

  def initializeInventories(): Unit ={
    /*
     * Loads the first inventory
     */
    mainInventory = Bukkit.createInventory(null, 9)

  }
}
