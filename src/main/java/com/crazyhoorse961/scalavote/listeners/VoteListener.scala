package com.crazyhoorse961.scalavote.listeners

import com.crazyhoorse961.scalavote.ScalaVote
import com.vexsoftware.votifier.model.{Vote, VotifierEvent}
import org.bukkit.{Bukkit, ChatColor}
import org.bukkit.event.{EventHandler, Listener}

/**
  * Created by nini7 on 27.05.2017.
  */
class VoteListener extends Listener
{

  @EventHandler
  def onVote(ev : VotifierEvent): Unit = {
    val main : ScalaVote = new ScalaVote
    val vote : Vote = ev.getVote
    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig.getString("vote-message").replace("%player%", vote.getUsername).replace("%service%", vote.getServiceName)))

  }
}
