class Chat(
    val idChat: Int,
    val participant: String,
) {
    private val messages = mutableListOf<Message>()

    fun addMessage(sender: String, text: String) {
        val message = Message(messages.size + 1, sender, text)
        messages.add(message)
    }

    fun deleteMessage(idMessage: Int) {
        val message = messages.find { it.idMessage == idMessage }
        messages.remove(message)
    }
    fun getMessages(count: Int): List<Message> {
        val unreadMessages = messages.filter { !it.isRead }
        val selectedMessages = if (unreadMessages.isNotEmpty()) {
            unreadMessages.take(count)
        } else {
            messages.takeLast(count)
        }
        selectedMessages.forEach { it.isRead = true }
        return selectedMessages
    }
    fun getLastMessage():String {
        return messages.lastOrNull()?.text ?: "Нет сообщений"
    }
}