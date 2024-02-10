fun main() {
    val chatService = ChatService()

    val chat1 = chatService.createChat("Artem")
    chat1.addMessage("Artem", "Hello!")
    chat1.addMessage("July", "Hello, how are you?")
    chat1.addMessage("Artem", "I'm fine, thanks!")

    val chat2 = chatService.createChat("Alexey")
    chat2.addMessage("Alexey", "Hi, how is your training?")
    chat2.addMessage("Roman", "Hi, it so good, now i'm creating my own chat")
    chat2.addMessage("Alexey", "Wow, it will be interesting")

    println("Amount unread chats: ${chatService.getUnreadChatsCount()}")

    val chats = chatService.getChats()
    for (chat in chats) {
        println("Chat ${chat.idChat} with user ${chat.participant}:")
        println("last message: ${chat.getLastMessage()}")
    }

    val messages = chat1.getMessages(2)
    for (message in messages) {
        println("Message from ${message.sender}: ${message.text}")
    }

    chat1.deleteMessage(2)

    val messagesAfterDeletion = chat1.getMessages(2)
    for (message in messagesAfterDeletion) {
        println("Message from ${message.sender}: ${message.text}")
    }

    chatService.deleteChat(1)

    println("Amount unread chats: ${chatService.getUnreadChatsCount()}")
}