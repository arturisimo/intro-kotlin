package edu.app.blog.entities

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
class UserBlog(
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY) var id: Long? = null,
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String? = null)


