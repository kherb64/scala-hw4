case class MyApp(id: Option[String])

case object request {
  val app: Option[MyApp] = Some(MyApp(Some("")))
}

case object Constants {
  val AppId: String = "AppId"
}

def hasAppId(myApp: MyApp): Boolean = true

val appId: (String, Option[String]) = request.app match {
  case Some(app) if hasAppId(app) => (Constants.AppId, app.id)
  case None => (Constants.AppId, None)
}
