package menu.model

import camp.nextstep.edu.missionutils.Randoms
import menu.model.menus.*


class RecommendSystem(
    private val coachAndMenus: List<Pair<Coach, List<Menus>>>,
    private val recommendCategories: List<Int>
) {

    fun getRecommendResult(): List<RecommendResult> {
        return coachAndMenus.map { pair ->
            val coach = pair.first
            val impossibleMenus = pair.second
            val selectedMenus = calculateRecommendMenus(impossibleMenus)
            RecommendResult(coach.name, selectedMenus.map { it.koreanName })
        }
    }

    private fun calculateRecommendMenus(impossibleMenus: List<Menus>): List<Menus> {
        val selectedMenus = mutableListOf<Menus>()
        recommendCategories.forEach { category ->
            when (category) {
                1 -> selectedMenus.add(
                    Randoms.shuffle(
                        JapaneseMenus.values().filter { !impossibleMenus.contains(it) })[0]
                )

                2 -> selectedMenus.add(
                    Randoms.shuffle(
                        KoreanMenus.values().filter { !impossibleMenus.contains(it) })[0]
                )

                3 -> selectedMenus.add(
                    Randoms.shuffle(
                        ChineseMenus.values().filter { !impossibleMenus.contains(it) })[0]
                )

                4 -> selectedMenus.add(Randoms.shuffle(AsianMenus.values().filter { !impossibleMenus.contains(it) })[0])
                5 -> selectedMenus.add(
                    Randoms.shuffle(
                        WesternMenus.values().filter { !impossibleMenus.contains(it) })[0]
                )
            }
        }
        return selectedMenus
    }

}