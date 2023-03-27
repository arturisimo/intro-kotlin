package edu.app.blog.model

import edu.app.blog.entities.UserBlog

data class RenderedArticle(
    val slug: String,
    val title: String,
    val headline: String,
    val content: String,
    val author: UserBlog,
    val addedAt: String)
