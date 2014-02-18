package controllers

import play.api._
import play.api.mvc._
import model._
import se.radley.plugin.salat.Binders.ObjectId
import com.mongodb.casbah.commons.MongoDBObject

object Application extends Controller {

  def index = Action {
    /*
    Post.remove(MongoDBObject())
    Content.remove(MongoDBObject())

    val contentA: Content = Content(new ObjectId(), "ContentA")
    val contentB: Content = Content(new ObjectId(), "ContentB")
    Content.insert(contentA)
    Content.insert(contentB)
    Post.insert(Post(new ObjectId(), "title", List(contentA.id, contentB.id), category = Some("category")))

    val post: Option[Post] = Post.findOne(MongoDBObject())
    post.foreach {
      p =>
        println("Post")
        println(p)
        println("Contents")
        p.content.foreach {
          c =>
            val cc = Content.findOne(MongoDBObject("_id" -> c))
            cc.foreach {
              c =>
                println(c.content)
            }
        }
    }
    */

    Log.remove(MongoDBObject())
    //ErrorLog.remove(MongoDBObject())
    //EventLog.remove(MongoDBObject())

    ErrorLog.insert(ErrorLog(title = "error log1", content = "content1"))
    ErrorLog.insert(ErrorLog(title = "error log2", content = "content2"))
    ErrorLog.insert(ErrorLog(title = "error log3", content = "content3"))
    EventLog.insert(EventLog(title = "event log1", content = "content1"))
    EventLog.insert(EventLog(title = "event log2", content = "content2"))

    ErrorLog.findErrorLog().foreach {
      el => println(el)
    }

    /*
    Log.find(MongoDBObject()).filter {
      case l@ErrorLog(_, _, _, _) => true
      case _ => false
    }.foreach {
      l => println(l)
    }
    */

    Ok(views.html.index("Your new application is ready."))
  }

}