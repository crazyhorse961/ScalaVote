package com.crazyhoorse961.scalavote

import java.util
import java.util.logging.Level

import com.crazyhoorse961.scalavote.inventories.ItemUtils
import com.crazyhoorse961.scalavote.utils.UUIDUtils
import lib.patp.sql.SQLite
import org.bukkit.plugin.java.JavaPlugin



/**
  * Created by nini7 on 27.05.2017.
  */
class ScalaVote extends JavaPlugin {

  var sqlite : SQLite = null
  var itemUtils : ItemUtils = new ItemUtils
  var uuidUtils : UUIDUtils = new UUIDUtils
  var waitingList : util.List[String] = new util.ArrayList[String]()

  override def onEnable(): Unit = {
    saveDefaultConfig
    openSql
    waitingList.addAll(getConfig.getStringList("waiting-list"))

  }

  override def onDisable(): Unit = {
    saveConfig
    sqlite.close()
  }

  def getSQLite = sqlite
  def getItemUtils = itemUtils
  def getUUIDUtils = uuidUtils
  def getWaitingList = waitingList

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
