import scala.concurrent.{ ExecutionContext, Future }

import reactivemongo.api.{ DefaultDB, MongoConnection, MongoDriver }
import reactivemongo.bson.{
BSONDocumentWriter, BSONDocumentReader, Macros, document
}

object MongoController {
  // My settings (see available connection options)
  val mongoUri = "mongodb://localhost:27017/mydb?authMode=scram-sha1"

  import ExecutionContext.Implicits.global // use any appropriate context

  // Connect to the database: Must be done only once per application
  val driver = MongoDriver()
  val parsedUri = MongoConnection.parseURI(mongoUri)
  val connection = parsedUri.map(driver.connection(_))

  // Database and collections: Get references
  val futureConnection = Future.fromTry(connection)
  def db1: Future[DefaultDB] = futureConnection.flatMap(_.database("mpgdb"))
  def db2: Future[DefaultDB] = futureConnection.flatMap(_.database("mpgdb2"))
  def mpgCollection = db1.map(_.collection("mpg"))

  // Write Documents: insert or update

  implicit def mpgWriter: BSONDocumentWriter[MilesPG] = Macros.writer[MilesPG]
  // or provide a custom one

  def createRecord(miles: MilesPG): Future[Unit] =
    mpgCollection.flatMap(_.insert(miles).map(_ => {})) 

  def updateRecord(miles: MilesPG): Future[Int] = {
    val selector = document(
      "miles" -> miles.miles,
      "fuel" -> miles.fuel
    )

    // Update the matching rec
    mpgCollection.flatMap(_.update(selector, miles).map(_.n))
  }

  implicit def personReader: BSONDocumentReader[MilesPG] = Macros.reader[MilesPG]
  // or provide a custom one

  def findMPG(): Future[List[MilesPG]] =
    mpgCollection.flatMap(_.find() 
      cursor[MilesPG]().collect[List]()) 
 

  // Custom persistent types
  case class MilesPG(miles: Double, fuel: Double)
}