package model

import com.novus.salat._
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import play.api.Play
import play.api.Play.current

package object customContext {
  implicit val context = {
    val context = new Context {
      val name = "custom"
      override val typeHintStrategy = StringTypeHintStrategy(when = TypeHintFrequency.Always,
        typeHint = "_typeHint")
    }
    context.registerGlobalKeyOverride(remapThis = "id", toThisInstead = "_id")
    context.registerClassLoader(cl = Play.classloader)
    context
  }
}
