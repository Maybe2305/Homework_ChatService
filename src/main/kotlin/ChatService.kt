class ChatService {
    private val chats = mutableListOf<Chat>()

    fun createChat(participant: String):Chat {
        val chat = Chat(chats.size + 1, participant)
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