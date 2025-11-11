package lecture3.homework3.decorator

import lecture3.homework3.AbstractTaco

abstract class TacoDecorator(protected open val taco: AbstractTaco): AbstractTaco() {
}