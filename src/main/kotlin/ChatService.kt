class ChatService {
    private val chats = mutableListOf<Chat>()

    fun createChat(paricipant: String):Chat {
        val chat = Chat(chats.size + 1, paricipant)
        chats.add(chat)
        return chat
    }
    fun deleteChat(chatId: Int) {
        val chat = chats.find { it.idChat == chatId }
        chats.remove(chat)
    }
    fun getChats(): List<Chat> {
        return chats.toList()
    }
    fun getUnreadChatsCount():Int {
        return chats.count { chat -> chat.getMessages(1).isNotEmpty() }
    }
}