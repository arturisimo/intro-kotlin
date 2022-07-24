package edu.app.blog.entities

import javax.persistence.Entity
import javax.persistence.Id
import edu.app.blog.extensions.toSlug
import java.time.LocalDateTime
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.ManyToOne

@Entity
class Article(
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    var id: Long? = null,
    val title: String,
    val headline: String,
    val content: String,
    @ManyToOne
    val author: UserBlog,
    val slug: String = title.toSlug(),
    val addedAt: LocalDateTime = LocalDateTime.now()) {

}
