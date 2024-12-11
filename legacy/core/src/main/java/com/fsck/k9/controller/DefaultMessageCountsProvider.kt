package com.fsck.k9.controller

import app.k9mail.legacy.account.Account
import app.k9mail.legacy.account.AccountManager
import app.k9mail.legacy.mailstore.MessageStoreManager
import app.k9mail.legacy.message.controller.MessageCounts
import app.k9mail.legacy.message.controller.MessageCountsProvider
import app.k9mail.legacy.search.ConditionsTreeNode
import app.k9mail.legacy.search.LocalSearch
import app.k9mail.legacy.search.SearchAccount
import com.fsck.k9.search.excludeSpecialFolders
import com.fsck.k9.search.getAccounts
import com.fsck.k9.search.limitToDisplayableFolders
import timber.log.Timber

internal class DefaultMessageCountsProvider(
    private val accountManager: AccountManager,
    private val messageStoreManager: MessageStoreManager,
) : MessageCountsProvider {
    override fun getMessageCounts(account: Account): MessageCounts {
        val search = LocalSearch().apply {
            excludeSpecialFolders(account)
            limitToDisplayableFolders()
        }

        return getMessageCounts(account, search.conditions)
    }

    override fun getMessageCounts(searchAccount: SearchAccount): MessageCounts {
        return getMessageCounts(searchAccount.relatedSearch)
    }

    override fun getMessageCounts(search: LocalSearch): MessageCounts {
        val accounts = search.getAccounts(accountManager)

        var unreadCount = 0
        var starredCount = 0
        for (account in accounts) {
            val accountMessageCount = getMessageCounts(account, search.conditions)
            unreadCount += accountMessageCount.unread
            starredCount += accountMessageCount.starred
        }

        return MessageCounts(unreadCount, starredCount)
    }

    @Suppress("TooGenericExceptionCaught")
    override fun getUnreadMessageCount(account: Account, folderId: Long): Int {
        return try {
            val messageStore = messageStoreManager.getMessageStore(account)
            return if (folderId == account.outboxFolderId) {
                messageStore.getMessageCount(folderId)
            } else {
                messageStore.getUnreadMessageCount(folderId)
            }
        } catch (e: Exception) {
            Timber.e(e, "Unable to getUnreadMessageCount for account: %s, folder: %d", account, folderId)
            0
        }
    }

    @Suppress("TooGenericExceptionCaught")
    private fun getMessageCounts(account: Account, conditions: ConditionsTreeNode?): MessageCounts {
        return try {
            val messageStore = messageStoreManager.getMessageStore(account)
            return MessageCounts(
                unread = messageStore.getUnreadMessageCount(conditions),
                starred = messageStore.getStarredMessageCount(conditions),
            )
        } catch (e: Exception) {
            Timber.e(e, "Unable to getMessageCounts for account: %s", account)
            MessageCounts(unread = 0, starred = 0)
        }
    }
}
