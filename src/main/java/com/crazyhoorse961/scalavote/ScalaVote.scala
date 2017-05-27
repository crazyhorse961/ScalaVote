package com.crazyhoorse961.scalavote

import java.util.logging.Level

import com.crazyhoorse961.scalavote.inventories.ItemUtils
import com.crazyhoorse961.scalavote.utils.UUIDUtils
import lib.PatPeter.SQLibrary.SQLite
import org.bukkit.plugin.java.JavaPlugin



/**
  * Created by nini7 on 27.05.2017.
  */
class ScalaVote extends JavaPlugin {

  var sqlite : SQLite = null
  var itemUtils : ItemUtils = new ItemUtils
  var uuidUtils : UUIDUtils = new UUIDUtils

  override def onEnable(): Unit = {
    saveDefaultConfig
    openSql
  }

  override def onDisable(): Unit = {
    saveConfig
    sqlite.close()
  }

  def getSQLite = sqlite
  def getItemUtils = itemUtils
  def getUUIDUtils = uuidUtils

  def openSql(): Unit ={
    sqlite = new SQLite(getLogger, "ScalaVote", "sql", getDataFolder.getAbsolutePath)
    sqlite.open()
    getLogger.log(Level.INFO, "Opened SQLite Connection")
    if(!sqlite.checkTable("scalavote")){
      sqlite.query("CREATE TABLE scalavote (uuid VARCHAR(40), votesCount INT, registerMillis SIGNED BIGINT")
      sqlite.query("CREATE TABLE votes (uuid VARCHAR(40), id INT, timestamp SIGNED BIGINT")
      getLogger.log(Level.INFO, "Created SQLite Tables")
      return
    }
  }
}
