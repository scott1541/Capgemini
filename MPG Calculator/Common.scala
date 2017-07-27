import com.mongodb.casbah.Imports._

case class MilesPG (miles: Double, litres: Double)

object Common {

  def buildMongoDbObject(milespg: MilesPG): MongoDBObject = {
    val builder = MongoDBObject.newBuilder
    builder += "miles" -> milespg.miles
    builder += "litres" -> milespg.litres
    builder.result
  }
}
