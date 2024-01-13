package projectname

import spinal.core._
import spinal.core.parameter._

// Hardware definition
case class testParam(width: Parameter = Parameter("width", 8)) extends Component {
  val io = new Bundle {
    val cond = in Bool()
    val a = in(SIntP(width))
    val b = in(SIntP(width))
    val c = out(SIntP(width + width))
  }

  val o = Reg(SIntP(width + width))

  when(io.cond) {
    o := io.a * io.b
  }

  io.c := o

}

object testParamVerilog extends App {
  Config.spinal.generateVerilog(testParam())
}
