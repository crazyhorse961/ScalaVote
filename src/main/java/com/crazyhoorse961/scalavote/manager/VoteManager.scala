package com.crazyhoorse961.scalavote.manager

import java.util.UUID

import com.crazyhoorse961.scalavote.ScalaVote

/**
  * Created by nini7 on 27.05.2017.
  */
class VoteManager
{

  def vote(username : String): Unit = {
    val main : ScalaVote = new ScalaVote
    var id : UUID = main.getUUIDUtils.getUuid(username)
  }
}
