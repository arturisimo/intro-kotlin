package edu.app.blog.jdbc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class ArticleJdbcRepository(@Autowired val db: JdbcTemplate) {

    fun findTitles(): List<String> = db.query("select * from articles") {
        rs, _ -> rs.getString("title")
    }

    /*
    fun findTitlesById(id: Long): String = db.query("select * from articles where id=?", id) {
        rs, _ -> rs.getString("title")
    }*/

}
