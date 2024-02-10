data class Message(
    val idMessage: Int,
    val sender: String,
    val text: String,
    var isRead: Boolean = false,
)  {
}