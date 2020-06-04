package machine
import java.util.*


enum class Estados {
    MENU_PRINCIPAL,
    MENU_CAFE,
    RECARGA,
    RECARGA_CAFE,
    RECARGA_MILK,
    RECARGA_CUPS,


}


class Machine() {
    var water: Int = 400
    var milk: Int = 540
    var coffee: Int = 120
    var cups: Int = 9
    var money: Int = 550
    var estado: Estados = Estados.MENU_PRINCIPAL
    var inputs: String = ""


    fun input(a: String) {

        inputs = a

        if (estado == Estados.MENU_PRINCIPAL) {
            if (a == "remaining") remaining()
            if (a == "buy") elegirTipoCafe()
            if (a == "take") sacarDinero()
        }

        if (estado == Estados.MENU_CAFE) {
            if (a == "2") hacerCafeLatte()
            if (a == "1") hacerCafeEspresso()
            if (a == "3") hacerCafeCappuccino()
            if (a == "back") {
                println("Write action (buy, fill, take, remaining, exit):")
                estado = Estados.MENU_PRINCIPAL
            }
        }


        if (estado == Estados.RECARGA) {
            rellenarAgua()
        } else if (estado == Estados.RECARGA_CAFE) {
            rellenarCafe()
        } else if (estado == Estados.RECARGA_MILK) {
            rellenarMilk()
        } else if (estado == Estados.RECARGA_CUPS) {
            rellenarCups()
        }

        if (a == "fill" && estado == Estados.MENU_PRINCIPAL) {
            println("Write how many ml of water do you want to add:")
            println()
            estado = Estados.RECARGA
        }

    }

    fun remaining() {
        println()
        println("The coffee machine has:")
        println("$water of water")
        println("$milk of milk")
        println("$coffee of coffee beans")
        println("$cups of disposable cups")
        println("$money of money")
        println("Write action (buy, fill, take, remaining, exit):")
        println()
    }

    fun elegirTipoCafe() {
        println()
        println("What do do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        estado = Estados.MENU_CAFE
        println()
    }

    fun hacerCafeCappuccino() {
        println()
        if (water >= 200 && coffee >= 12 && cups >= 1 && milk >= 100) {
        println("I have enough resources, making you a coffee!")
        water -= 200
        milk -= 100
        coffee -= 12
        cups -= 1
        money += 6
        println()
        } else println("Sorry, not enough water!")
        estado = Estados.MENU_PRINCIPAL
        println("Write action (buy, fill, take, remaining, exit):")
        println()
    }

    fun hacerCafeEspresso() {
        println()
        if (water >= 250 && coffee >= 16 && cups >= 1) {
        println("I have enough resources, making you a coffee!")
        water -= 250
        coffee -= 16
        cups -= 1
        money += 4
        println()
        } else println("Sorry, not enough water!")
        estado = Estados.MENU_PRINCIPAL
        println("Write action (buy, fill, take, remaining, exit):")
        println()
    }

    fun hacerCafeLatte() {
        println()
        if (water >= 350 && coffee >= 20 && cups >= 1 && milk >= 75) {
        println("I have enough resources, making you a coffee!")
        water -= 350
        milk -= 75
        coffee -= 20
        cups -= 1
        money += 7
        println()
        } else println("Sorry, not enough water!")
        estado = Estados.MENU_PRINCIPAL
        println("Write action (buy, fill, take, remaining, exit):")
        println()
    }

    fun rellenarAgua() {
        println()
        water = water + inputs.toInt()
        estado = Estados.RECARGA_CAFE
        println("Write how many ml of coffee do you want to add:")
        println()
    }

    fun rellenarCafe() {
        println()
        coffee = coffee + inputs.toInt()
        estado = Estados.RECARGA_MILK
        println("Write how many ml of milk do you want to add:")
        println()
    }

    fun rellenarMilk() {
        println()
        milk = milk + inputs.toInt()
        estado = Estados.RECARGA_CUPS
        println("Write how many ml of cups do you want to add:")
        println()
    }

    fun rellenarCups() {
        println()
        cups = cups + inputs.toInt()
        estado = Estados.MENU_PRINCIPAL
        println("Write action (buy, fill, take, remaining, exit):")
        println()
    }

    fun sacarDinero() {
        println("I gave you $money")
        money = money - money
        estado = Estados.MENU_PRINCIPAL
        println()
        println("Write action (buy, fill, take, remaining, exit):")
        println()
    }


}




fun main() {
    val scanner = Scanner(System.`in`)
    println("Write action (buy, fill, take, remaining, exit):")
    println()

    val maquina = Machine()

    do {
        val elecciones = scanner.next().toString()
        maquina.input(elecciones)


    } while (elecciones.toString() != "exit")
}
