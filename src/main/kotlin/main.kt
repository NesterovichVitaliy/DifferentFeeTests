fun main() {
    val cardType = "Visa"
    val amountOfPreviousTransfers = 0
    val amount = 1000
    val feeAmount = fee(cardType, amountOfPreviousTransfers, amount)
    if (feeAmount == -1) println("Превышен лимит") else println("Комиссия составила: $feeAmount рублей")
}

fun fee(cardType: String, amountOfPreviousTransfers: Int, amount: Int): Int {
    return when (cardType) {
        "Maestro", "MasterCard" -> if (amountOfPreviousTransfers in 0..600_000 && amount in 0..150_000)
            feeOfMaestroMasterCard(amount, amountOfPreviousTransfers)
        else -1

        "Visa", "Mir" -> if (amountOfPreviousTransfers in 0..600_000 && amount in 0..150_000)
            feeOfVisaMir(amount, minFee)
        else -1

        "VKPay" -> if (amountOfPreviousTransfers in 0..40_000 && amount in 0..15_000) 0 else -1
        else -> -1
    }
}


fun feeOfMaestroMasterCard (amount: Int, amountOfPreviousTransfers: Int) =
    if (amount + amountOfPreviousTransfers > 75_000) 0
    else (amount * 0.006 + 20).toInt()

val minFee = 35
fun feeOfVisaMir (amount: Int, minFee: Int) =
    if ((amount * 0.0075) > minFee)
        (amount * 0.0075).toInt()
    else minFee