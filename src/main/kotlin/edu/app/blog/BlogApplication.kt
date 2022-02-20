package edu.app.blog

import edu.app.blog.config.BlogProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(BlogProperties::class)
@SpringBootApplication
class BlogApplication

fun main(args: Array<String>) {
    runApplication<BlogApplication>(*args)
}
