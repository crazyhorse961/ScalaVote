package com.crazyhoorse961.scalavote.utils

import java.util.UUID

import org.bukkit.Bukkit

/**
  * Created by nini7 on 27.05.2017.
  */
class UUIDUtils {

  def getUuid(name : String): UUID = {
    return Bukkit.getOfflinePlayer(name).getUniqueId
  }
  def getName(uuid : UUID): String = {
    return Bukkit.getOfflinePlayer(uuid).getName
  }
}
