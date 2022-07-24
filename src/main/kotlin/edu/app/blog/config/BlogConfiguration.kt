package edu.app.blog.config

import edu.app.blog.entities.UserBlog
import edu.app.blog.entities.Article
import edu.app.blog.repository.ArticleRepository
import edu.app.blog.repository.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(userRepository: UserRepository,
                            articleRepository: ArticleRepository
    ) = ApplicationRunner {
        articleRepository.deleteAll()
        userRepository.deleteAll()
        val smaldini = userRepository.save(UserBlog(login="smaldini", firstname = "Stéphane", lastname = "Maldini"))
            articleRepository.save(
                Article(
                title = "Reactor Bismuth is out",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
            )
        )
        articleRepository.save(Article(
            title = "Reactor Aluminium has landed",
            headline = "Lorem ipsum",
            content = "dolor sit amet",
            author = smaldini
        ))
    }
}
