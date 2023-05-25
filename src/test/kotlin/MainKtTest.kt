import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun feeOfVisaMirBranchIf() {
        val amount = 10000
        val minFee = 35

        val result = feeOfVisaMir(amount, minFee)

        assertEquals(65,result)
    }

    @Test
    fun feeOfVisaMirBranchElse() {
        val amount = 100
        val minFee = 35

        val result = feeOfVisaMir(amount, minFee)

        assertEquals(25,result)
    }

    @Test
    fun feeOfMaestroMasterCardBranchIf() {
        val amount = 100000
        val amountOfPreviousTransfers = 0

        val result = feeOfMaestroMasterCard(amount, amountOfPreviousTransfers)

        assertEquals(1,result)
    }

    @Test
    fun feeOfMaestroMasterCardBranchElse() {
        val amount = 1000
        val amountOfPreviousTransfers = 0

        val result = feeOfMaestroMasterCard(amount, amountOfPreviousTransfers)

        assertEquals(46,result)
    }

    @Test
    fun feeOfVKPayIf() {
        val cardType = "VKPay"
        val amount = 1000
        val amountOfPreviousTransfers = 0

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(1, result)
    }

    @Test
    fun feeOfVKPayBranchElse() {
        val cardType = "VKPay"
        val amount = 1000
        val amountOfPreviousTransfers = 100_000

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun feeOfVKPayBranchElse_2() {
        val cardType = "VKPay"
        val amount = 20_000
        val amountOfPreviousTransfers = 0

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun feeOfVKPayBranchElse_3() {
        val cardType = "VKPay"
        val amount = 20_000
        val amountOfPreviousTransfers = 100_000

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun feeVisaBranchIf() {
        val cardType = "Visa"
        val amount = 1000
        val amountOfPreviousTransfers = 0

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(85, result)
    }

    @Test
    fun feeVisaBranchElse() {
        val cardType = "Visa"
        val amount = 160_000
        val amountOfPreviousTransfers = 1_000_000

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun feeVisaBranchElse_2() {
        val cardType = "Visa"
        val amount = 160_000
        val amountOfPreviousTransfers = 0

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun feeVisaBranchElse_3() {
        val cardType = "Visa"
        val amount = 16_000
        val amountOfPreviousTransfers = 1_000_000

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun feeMirBranchIf() {
        val cardType = "Mir"
        val amount = 1000
        val amountOfPreviousTransfers = 0

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(95, result)
    }

    @Test
    fun feeMirBranchElse() {
        val cardType = "Mir"
        val amount = 160_000
        val amountOfPreviousTransfers = 1_000_000

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun feeMirBranchElse_2() {
        val cardType = "Mir"
        val amount = 160_000
        val amountOfPreviousTransfers = 0

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun feeMirBranchElse_3() {
        val cardType = "Mir"
        val amount = 16_000
        val amountOfPreviousTransfers = 1_000_000

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun feeMaestroBranchIf() {
        val cardType = "Maestro"
        val amount = 1000
        val amountOfPreviousTransfers = 0

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(46, result)
    }

    @Test
    fun feeMaestroBranchElse() {
        val cardType = "Maestro"
        val amount = 1000
        val amountOfPreviousTransfers = 1_000_000

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun feeMaestroBranchElse_2() {
        val cardType = "Maestro"
        val amount = 160_000
        val amountOfPreviousTransfers = 0

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun feeMaestroBranchElse_3() {
        val cardType = "Maestro"
        val amount = 160_000
        val amountOfPreviousTransfers = 1_000_000

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun feeMasterCardBranchIf() {
        val cardType = "MasterCard"
        val amount = 1000
        val amountOfPreviousTransfers = 0

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(76, result)
    }

    @Test
    fun feeMasterCardBranchElse() {
        val cardType = "MasterCard"
        val amount = 1000
        val amountOfPreviousTransfers = 1_000_000

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(-2, result)
    }

    @Test
    fun feeElse() {
        val cardType = "Unknown"
        val amount = 1000
        val amountOfPreviousTransfers = 1_000_000

        val result = fee(cardType, amountOfPreviousTransfers, amount)

        assertEquals(-2, result)
    }
}