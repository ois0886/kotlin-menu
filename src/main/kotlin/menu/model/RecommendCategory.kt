package menu.model

import camp.nextstep.edu.missionutils.Randoms

class RecommendCategory {

    fun getRecommendCategories(): List<Int> {
        val selectedCategories = mutableListOf<Int>()
        repeat(CATEGORY_COUNT) {
            val randomNumber = findValidRandomNumber(selectedCategories)
            selectedCategories.add(randomNumber)
        }
        return selectedCategories
    }

    private fun findValidRandomNumber(selectedCategories: MutableList<Int>): Int {
        while (true) {
            val randomNumber: Int = Randoms.pickNumberInRange(START_CATEGORY_NUMBER, END_CATEGORY_NUMBER)
            if (selectedCategories.count { it == randomNumber } <= REDUNDANCY_TWO) {
                return randomNumber
            }
        }
    }

    companion object {
        const val CATEGORY_COUNT = 5
        const val REDUNDANCY_TWO = 2
        const val START_CATEGORY_NUMBER = 1
        const val END_CATEGORY_NUMBER = 5
    }

}