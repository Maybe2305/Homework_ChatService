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
       messages.removeIf { it.idMessage == idMessage }
    }
    fun getMessages(count: Int): List<Message> {
        val selectedMessages = if (messages.none { !it.isRead }) messages.takeLast(count)
        else {
            messages.asSequence()
                .filter { !it.isRead }
                .take(count)
                .onEach { it.isRead = true }
                .toList()
        }
        return selectedMessages
    }
    fun getLastMessage():String {
        return messages.lastOrNull()?.text ?: "Нет сообщений"
    }
}