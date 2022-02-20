package edu.app.blog.entities

import javax.persistence.Entity
import javax.persistence.Id
import edu.app.blog.extensions.toSlug
import java.time.LocalDateTime
import javax.persistence.GeneratedValue
import javax.persistence.ManyToOne

@Entity
class Article(
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var author: User,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue var id: Long? = null)