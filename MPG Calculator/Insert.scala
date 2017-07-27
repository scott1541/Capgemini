import com.mongodb.casbah.Imports._
import Common._

object Insert extends App {

  def getMPG(): Double = {
    println("\n___ all items ___")
    val fetch = MongoFactory.collection.find
    //fetch.foreach(item => println(item))
    //println(fetch.getAs[Double]("miles").get)
    val stock = convertDbObjectToStock(fetch.get)

  return 1
  }


  def saveMPG(milespg: MilesPG) {
    val mongoObj = buildMongoDbObject(milespg)
    MongoFactory.collection.save(mongoObj)
  }

  def convertDbObjectToStock(obj: MongoDBObject): Stock = {
    val symbol = obj.getAs[String]("symbol").get
    val price = obj.getAs[Double]("price").get
    Stock(symbol, price)
  }

}