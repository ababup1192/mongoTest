package model

import com.mongodb.casbah.Imports._
import java.util.Date
import com.novus.salat._
import com.novus.salat.dao._
import play.api.Play.current
import se.radley.plugin.salat._

import customContext._

case class Post(
                 id: ObjectId = new ObjectId,
                 title: String,
                 content: List[ObjectId] = List[ObjectId](),
                 category: Option[String] = None,
                 createdAt: Date = new Date()
                 )

trait PostDAO extends ModelCompanion[Post, ObjectId] {
  def collection = mongoCollection("posts")

  val dao = new SalatDAO[Post, ObjectId](collection) {}

  def findByCategory(category: String): SalatMongoCursor[Post] =
    dao.find(MongoDBObject("category" -> category))
}

object Post extends PostDAO
