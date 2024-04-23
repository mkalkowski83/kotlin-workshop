import kotlin.test.Test
import kotlin.test.assertEquals

class User(
    val id: Int,
    val email: String,
) {
    override fun toString(): String {
        return "${this.javaClass.name}(id=$id, email='$email')"
    }
}

class UserTest {
    @Test
    fun `should return the id and email`() {
        val user = User(1, "test@example.com")
        assertEquals(1, user.id)
        assertEquals("test@example.com", user.email)
    }

    @Test
    fun `should displays the name of the class and each property`() {
        val user = User(1, "test@example.com")
        assertEquals("User(id=1, email='test@example.com')", user.toString())
    }
}
