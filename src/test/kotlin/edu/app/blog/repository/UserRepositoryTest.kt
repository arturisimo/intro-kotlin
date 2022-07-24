package edu.app.blog.repository

import edu.app.blog.entities.UserBlog
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(
    SpringExtension::class)
@DataJpaTest
@AutoConfigureTestDatabase
class UserRepositoryTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserRepository) {

    @Test
    fun `When findByLogin then return User`() {
        val juergen = UserBlog(login="springjuergen", lastname = "Juergen", firstname = "Hoeller")
        entityManager.persist(juergen)
        entityManager.flush()
        val user = userRepository.findByLogin(juergen.login)
        assertThat(user).isEqualTo(juergen)
    }
}
