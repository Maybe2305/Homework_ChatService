import org.junit.Assert.*
import org.junit.Test

class ChatTest {


    @Test
    fun testAddMessage() {
        val chat = Chat(1,"User1")
        chat.addMessage("User1", "Hello")
        chat.addMessage("User2", "Hello, how are you?")

        val messages = chat.getMessages(2)
        assertEquals(2, messages.size)
        assertEquals("Hello", messages[0].text)
        assertEquals("Hello, how are you?", messages[1].text)
    }

    @Test

    fun testDeleteMessage() {
        val chat = Chat(1,"User1")
        chat.addMessage("User1", "Hello")
        chat.addMessage("User2", "Hello, how are you?")

        chat.deleteMessage(1)
        val messages = chat.getMessages(2)
        assertEquals(1,messages.size)
        assertEquals("Hello, how are you?", messages[0].text)
    }

    @Test
    fun testGetMessages() {
        val chat = Chat(1,"User1")
        chat.addMessage("User1", "Hello")
        chat.addMessage("User2", "Hello, how are you?")

        val messages = chat.getMessages(2)
        assertEquals(2, messages.size)
        assertEquals("Hello", messages[0].text)
        assertEquals("Hello, how are you?", messages[1].text)
        assertEquals(true, messages[0].isRead)
        assertEquals(true, messages[1].isRead)
    }

    @Test
    fun testGetLastMessage() {
        val chat = Chat(1,"User1")
        chat.addMessage("User1", "Hello")
        chat.addMessage("User2", "Hello, how are you?")

        val lastMessage = chat.getLastMessage()
        assertEquals("Hello, how are you?", lastMessage)
    }

    @Test
    fun testGetIdChat() {
        val chat = Chat(1,"User1")
        chat.addMessage("User1", "Hello")
        chat.addMessage("User2", "Hello, how are you?")

        val idChat = chat.idChat
        assertEquals(1,idChat)
    }

    @Test
    fun testGetParticipant() {
        val chat = Chat(1,"User1")
        chat.addMessage("User1", "Hello")
        chat.addMessage("User2", "Hello, how are you?")

        val participant = chat.participant
        assertEquals("User1", participant)
    }
}