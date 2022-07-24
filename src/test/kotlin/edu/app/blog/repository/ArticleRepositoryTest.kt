package edu.app.blog.repository

import edu.app.blog.entities.UserBlog
import edu.app.blog.entities.Article
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.junit4.SpringRunner

@DataJpaTest
@AutoConfigureTestDatabase
class ArticleRepositoryTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val articleRepository: ArticleRepository) {

    @Test
    fun `When findByIdOrNull then return Article`() {

        val juergen = UserBlog(login = "springjuergen", firstname = "Juergen", lastname = "Hoeller")
        entityManager.persist(juergen)

        val article = Article(title="Spring Framework 5.0 goes GA", headline = "Dear Spring community ...", content = "Lorem ipsum", author = juergen)
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepository.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }


}
