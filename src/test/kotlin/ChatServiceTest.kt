import org.junit.Test

import org.junit.Assert.*

class ChatServiceTest {

    @Test
    fun testCreateChat() {
        val chatService = ChatService()
        val chat = chatService.createChat("User1")

        assertEquals(1, chat.idChat)
        assertEquals("User1", chat.participant)
        assertEquals(1, chatService.getChats().size)
        assertTrue(chatService.getChats().contains(chat))
    }

    @Test
    fun deleteChat() {
        val chatService = ChatService()
        val chat1 = chatService.createChat("User1")
        val chat2 = chatService.createChat("User2")

        chatService.deleteChat(chat1.idChat)

        assertEquals(1, chatService.getChats().size)
        assertTrue(chatService.getChats().contains(chat2))
    }

    @Test
    fun getChats() {
        val chatService = ChatService()
        val chat1 = chatService.createChat("User1")
        val chat2 = chatService.createChat("User2")

        val getChats = chatService.getChats()
        assertEquals(2,getChats.size)
    }

    @Test
    fun getUnreadChatsCount() {
        val chatService = ChatService()
        val chat1 = chatService.createChat("User1")
        val chat2 = chatService.createChat("User2")

        chat1.addMessage("User1", "Hello")
        chat2.addMessage("User2", "How are you?")

        val unreadChatsCount = chatService.getUnreadChatsCount()
        assertEquals(2,unreadChatsCount)
    }
}