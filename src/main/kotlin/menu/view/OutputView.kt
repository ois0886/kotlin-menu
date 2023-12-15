package menu.view

import menu.model.Coach
import menu.model.RecommendCategory
import menu.model.RecommendResult
import menu.model.RecommendSystem
import menu.model.Menus
import menu.util.Messages

class OutputView(
    private val recommendCategories: List<Int> = RecommendCategory().getRecommendCategories()
) {

    fun printRecommendCategory() {
        println(Messages.PRINT_RESULT_COMMENT)
        println(recommendCategories.toCategory())
    }

    fun printRecommendResults(coachAndMenus: List<Pair<Coach, List<String>>>) {
        val recommendSystem = RecommendSystem(coachAndMenus = coachAndMenus, recommendCategories = recommendCategories)
        val results = recommendSystem.getRecommendResult()
        results.forEach { result ->
            getResultString(result)
        }
        println()
        println(Messages.PRINT_COMPLETE_RECOMMEND)
    }

    private fun getResultString(result: RecommendResult) {
        println("[ ${result.coachName} | ${result.recommendMenus.joinToString(" | ")} ]")
    }

    private fun List<Int>.toCategory(): String {
        var str = "[ 카테고리 "
        this.forEachIndexed { index, category ->
            when (category) {
                1 -> str += "| 일식"
                2 -> str += "| 한식"
                3 -> str += "| 중식"
                4 -> str += "| 아시안"
                5 -> str += "| 양식"
            }

            str += if (index < this.size - 1) {
                " "
            } else {
                " ]"
            }
        }

        return str
    }

}