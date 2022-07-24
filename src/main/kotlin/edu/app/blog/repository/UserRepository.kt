package edu.app.blog.repository

import edu.app.blog.entities.UserBlog
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserBlog, Long> {
    fun findByLogin(login: String): UserBlog?
}
