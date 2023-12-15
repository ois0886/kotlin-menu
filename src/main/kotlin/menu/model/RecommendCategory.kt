package menu.model

import camp.nextstep.edu.missionutils.Randoms

class RecommendCategory {

    fun getRecommendCategories(): List<Int> {
        val selectedCategories = mutableListOf<Int>()
        val checkCategories = IntArray(CATEGORY_COUNT + 1)
        repeat(CATEGORY_COUNT) {
            val randomNumber = findValidRandomNumber(checkCategories)
            selectedCategories.add(randomNumber)
            checkCategories[randomNumber]++
        }
        return selectedCategories
    }

    private fun findValidRandomNumber(checkCategories: IntArray): Int {
        var randomNumber: Int = Randoms.pickNumberInRange(START_CATEGORY_NUMBER, END_CATEGORY_NUMBER)
        while (true) {
            if (checkCategories[randomNumber] > REDUNDANCY_TWO) {
                randomNumber = Randoms.pickNumberInRange(START_CATEGORY_NUMBER, END_CATEGORY_NUMBER)
            } else break
        }
        return randomNumber
    }

    companion object {
        const val CATEGORY_COUNT = 5
        const val REDUNDANCY_TWO = 2
        const val START_CATEGORY_NUMBER = 1
        const val END_CATEGORY_NUMBER = 5
    }

}