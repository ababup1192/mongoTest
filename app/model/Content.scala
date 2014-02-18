package model

import com.mongodb.casbah.Imports._
import java.util.Date
import com.novus.salat._
import com.novus.salat.dao._
import play.api.Play.current
import se.radley.plugin.salat._

import customContext._

case class Content(
                    id: ObjectId = new ObjectId,
                    content: String
                    )

trait ContentDAO extends ModelCompanion[Content, ObjectId] {
  def collection = mongoCollection("contents")

  val dao = new SalatDAO[Content, ObjectId](collection) {}
}

object Content extends ContentDAO
