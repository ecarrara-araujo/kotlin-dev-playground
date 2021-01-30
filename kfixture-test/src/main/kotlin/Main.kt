import com.flextrade.kfixture.KFixture
import com.flextrade.kfixture.customisation.IgnoreDefaultArgsConstructorCustomisation

enum class Number { ONE, TWO, THREE }

fun main() {
    val fixture = KFixture {
        add(IgnoreDefaultArgsConstructorCustomisation())
    }
    val number = fixture<Number>()
    print(number)
}