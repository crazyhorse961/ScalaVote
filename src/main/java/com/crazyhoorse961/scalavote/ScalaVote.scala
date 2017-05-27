package com.crazyhoorse961.scalavote

import java.io.File
import java.util.logging.Level

import lib.PatPeter.SQLibrary.SQLite
import org.bukkit.plugin.java.JavaPlugin



/**
  * Created by nini7 on 27.05.2017.
  */
class ScalaVote extends JavaPlugin {

  var sqlite : SQLite = null

  override def onEnable(): Unit = {
    saveDefaultConfig
    openSql
  }

  override def onDisable(): Unit = {
    saveConfig
    sqlite.close()
  }


  def openSql(): Unit ={
    sqlite = new SQLite(getLogger, "ScalaVote", "sql", getDataFolder.getAbsolutePath)
    sqlite.open()
    getLogger.log(Level.INFO, "Opened SQLite Connection")
    if(!sqlite.checkTable("scalavote")){
      sqlite.query("CREATE TABLE scalavote (uuid VARCHAR(40), votes INT, registerMillis INT")
      getLogger.log(Level.INFO, "Created SQLite Tables")
      return
    }
  }
}
