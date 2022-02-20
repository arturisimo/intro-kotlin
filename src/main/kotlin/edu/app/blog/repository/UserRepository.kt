package edu.app.blog.repository

import edu.app.blog.entities.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(login: String): User?
}