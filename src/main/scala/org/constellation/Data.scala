package org.constellation

import com.typesafe.scalalogging.Logger
import org.constellation.primitives._

class Data extends MetricsExt
  with BundleDataExt
  with Reputation
  with PeerInfo
  with NodeData
  with Ledger
  with TransactionExt
  with Genesis {

  val logger = Logger(s"Data")

  var confirmWindow : Int = 20

  def restartNode(): Unit = {
 //   restartDB()
    genesisBundle = None
    downloadMode = true
    validLedger.clear()
    memPoolLedger.clear()
    syncPendingTXHashes = Set()
    syncPendingBundleHashes = Set()
    signedPeerLookup.clear()
    memPool = Set()
    activeDAGManager.activeSheafs = Seq()
    activeDAGManager.cellKeyToCell.clear()
    maxBundleMetaData = null
    txHashToTX.clear()
    bundleToSheaf.clear()
    last10000ValidTXHash = Seq()
    last100ValidBundleMetaData = Seq()
    resetMetrics()
    peersAwaitingAuthenticationToNumAttempts.clear()
    signedPeerLookup.clear()
    txSyncRequestTime.clear()
    txInMaxBundleNotInValidation = Set()
    last100SelfSentTransactions = Seq()
    peerSync.clear()

  }


}
