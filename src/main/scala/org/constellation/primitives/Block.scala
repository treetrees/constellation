package org.constellation.primitives

import akka.actor.ActorRef

case class Block(parentHash: String,
                 height: Long,
                 signature: String = "",
                 clusterParticipants: Set[ActorRef] = Set(),
                 round: Long = 0L,
                 transactions: Seq[Transaction] = Seq())
// TODO: temp
case class BlockSerialized(parentHash: String,
                 height: Long,
                 signature: String = "",
                 clusterParticipants: Set[String] = Set(),
                 round: Long = 0L,
                 transactions: Seq[Transaction] = Seq())

//  def hash(block: Block): String = (Seq(block.height, block.parentHash) ++ block.transactions.map((t) => Transaction.hash(t)))