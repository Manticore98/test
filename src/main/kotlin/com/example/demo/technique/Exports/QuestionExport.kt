import com.example.demo.technique.Entities.Question
import com.example.demo.technique.Repository.QuestionRepo
import com.opencsv.CSVWriter
import org.apache.commons.csv.CSVFormat
import java.io.*
import java.util.*


fun writeDataLineByLine(filePath: String?, question: Question) {

   // first create file object for file placed at location
   // specified by filepath
   /*val file = File(filePath)

   var mList = bdd.findAll()
   var question:Question

   try {
      // create FileWriter object with file as parameter
      val outputfile = FileWriter(file)

      // create CSVWriter object filewriter object as parameter
      val writer = CSVWriter(outputfile)

      // adding header to csv
      val header = arrayOf("title", "promoted", "createdat","updatedat")
      writer.writeNext(header)
      val sc = Scanner(System.`in`)
      val data: List<Question> = ArrayList()
      for (item in mList){
         data.indexOf(item).
         writer.writeNext(data)
      }
      // add data to csv
      val data1 = arrayOf("Aman", "10", "620")
      writer.writeNext(data1)
      val data2 = arrayOf("Suraj", "10", "630")
      writer.writeNext(data2)

      // closing writer connection
      writer.close()
   } catch (e: IOException) {
      // TODO Auto-generated catch block
      e.printStackTrace()
   }*/
   /*fun Writer.writeCsv(question: List<Question>) {
      CSVFormat.DEFAULT.print(this).apply {
         printRecord("qid", "title", "promoted", "status", "created_at","updated_at")
         question.forEach { (qid, title, promoted, status, created_at,updated_at) -> printRecord(qid, title, promoted, status, created_at,updated_at) }
      }
   }*/
   inline fun <reified T> writeCsvFile(data: Collection<T>, fileName: String) {
      FileWriter(fileName).use { writer ->
         csvMapper.writer(csvMapper.schemaFor(T::class.java).withHeader())
            .writeValues(writer)
            .writeAll(data)
            .close()
      }
}