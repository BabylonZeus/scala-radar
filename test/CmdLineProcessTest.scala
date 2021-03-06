import java.io.File
import org.scalatest.{Matchers, FunSuite}

class CmdLineProcessTest extends FunSuite with Matchers {

    //file:////Users/ugobourdon/Documents/SCALA/scaladocs/scala-docs-2.10.1/index.html#scala.sys.process.package

    ignore("test ls cmd") {
        import scala.sys.process._

        // This uses ! to get the exit code
        val ls_cmd_withExitCode = Seq("ls") !

        // This uses !! to get the whole result as a string
        //val cd_cmd = "cd /Users/ugobourdon/" !!
        //val ls_cmd = "ls" !!

        val lsAfterCd_cmd = "cd /Users/ugobourdon/ && ls" !!

        //val bash = "/Users/ugobourdon/test.sh"

        //println(ls_cmd_withExitCode)
        //println(ls_cmd)
        //println(lsAfterCd_cmd)
        //println(bash)
    }

    ignore("git clone cmd + play test") {
        import scala.sys.process._

        // bloquant
        "rm -rf /Users/ugobourdon/test/scala-radar" !!

        // bloquant
        val result = "git clone git@github.com:SimplyScala/scala-radar.git /Users/ugobourdon/test/scala-radar" !!

        val play_cmd = "/Users/ugobourdon/Dev/apps/play-2.2.1/play"
        val result_2 = Process(Seq(play_cmd, "test"), Option(new File("/Users/ugobourdon/test/scala-radar"))).lines

        result_2.foreach(println)
    }

    ignore("scala check style") {
        import scala.sys.process._

        val scalastyleDir = "/Users/ugobourdon/Dev/apps/scalastyle-batch_2.10-0.3.2"
        val scalastyleJar = s"$scalastyleDir/scalastyle-batch_2.10.jar"
        val scalastyleConfig = s"$scalastyleDir/scalastyle_config.xml"

        val resultDir = "/Users/ugobourdon/test/scala-radar_style.xml"

        val appUnderTest = "/Users/ugobourdon/Dev/Projects/ScalaQuality/scala-radar/app"
        //val appUnderTest = "/Users/ugobourdon/test/scala-radar-1391359829433/app"

        val result = s"java -jar $scalastyleJar --xmlOutput $resultDir --config $scalastyleConfig $appUnderTest" !!
    }
}