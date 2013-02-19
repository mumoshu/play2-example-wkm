package controllers

import play.api._
import play.api.mvc._
import org.apache.commons.httpclient._
import org.apache.commons.httpclient.methods._
import org.apache.commons.httpclient.auth._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def prettyCat = Action {
    Ok("https://dl.dropbox.com/u/6581286/vvakame/neco-box.gif")
  }

  def gerrit = Action {
    var httpState = new HttpState()
    val scope = new AuthScope("xxxx.com", 8989)
    val credentials = new UsernamePasswordCredentials("xxxxxx", "xxxxxx")
    httpState.setCredentials(scope, credentials)

    val config = new HostConfiguration()
    val method = new GetMethod("https://xxxxxx.com/a/projects/?format=JSON&d")
    val client = new HttpClient()
    client.executeMethod(config, method, httpState)

    val response = method.getResponseBody()
    System.out.println(new String(response))

    Ok("https://dl.dropbox.com/u/6581286/vvakame/neco-box.gif")
  }
}
