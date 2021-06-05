import scala.annotation._

object FPScala1 extends App{

  def youGaveMe(x:Any):String = x match {
    case s:String => s"u gave me string $s"
    case i:Int => s"u gave me int $i"
    case _ =>s" Don't know what the fuck is this"
  }

  def fib(n:Int):BigInt = {
    @tailrec
    def fibbo(n: Int,acc1: BigInt,acc2:BigInt): BigInt = n match {
      case 0  => acc1
      case 1 => acc2
      case _ => {
        println("Acc2 "+acc2)
        println("Acc1 "+acc1)
        println("N-1 "+(n-1))
        fibbo(n-1,acc2,acc1+acc2)}
    }
    fibbo(n,0,1)
  }

  //println(fib(300000))
  def sum(list: List[Int]):Int ={
    @tailrec
    def sumWithAccum(list:List[Int],accum:Int):Int= list match {
      case Nil => accum
      case x::xs =>{
        println("Accum "+accum)
        println("Head "+x)
        println("Tail "+xs)
        sumWithAccum(xs,x+accum)
      }
    }
    sumWithAccum(list,0)
  }

  // println(sum(List.range(1, 10)))

  assert(sum(List.range(1,10)) == 45)
  //assert(fib(3) == 5)
  println(fib(10))


}