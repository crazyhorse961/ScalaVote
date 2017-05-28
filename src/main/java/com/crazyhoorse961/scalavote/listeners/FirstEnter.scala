package com.crazyhoorse961.scalavote.listeners

import java.util.UUID

import com.crazyhoorse961.scalavote.ScalaVote
import com.vexsoftware.votifier.model.{Vote, VotifierEvent}
import org.bukkit.Bukkit
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.{EventHandler, Listener}

/**
  * Created by nini7 on 27.05.2017.
  */
class FirstEnter extends Listener
{

  @EventHandler
  def onJoin(e : PlayerJoinEvent): Unit = {
    val main : ScalaVote = new ScalaVote
    if(!e.getPlayer.hasPlayedBefore){
      main.sqlite.query("INSERT INTO scalavote VALUES (" + e.getPlayer.getUniqueId + ", 0, "  + System.currentTimeMillis() + ")")
      return
    }
    if(main.waitingList.contains(e.getPlayer.getUniqueId)){
      val uuid : UUID = e.getPlayer.getUniqueId
      for(numbers : String <- main.getConfig.getStringList("waiting-numbers")){
        if(numbers.startsWith(uuid.toString)){
          val votes : Int = Integer.valueOf(numbers.split(";")(1))
          1 to votes foreach( _  => {
            val ev : VotifierEvent = new VotifierEvent(new Vote(numbers.split(";")(2), main.uuidUtils.getName(uuid), numbers.split(";")(4), numbers.split(";")(3)))
            Bukkit.getPluginManager.callEvent(ev)
          })
        }
      }
    }
  }
}
