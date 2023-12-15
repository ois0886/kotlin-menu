package menu.model

import camp.nextstep.edu.missionutils.Randoms


class RecommendSystem(
    private val coachAndMenus: List<Pair<Coach, List<String>>>, private val recommendCategories: List<Int>
) {

    fun getRecommendResult(): List<RecommendResult> {
        return coachAndMenus.map { pair ->
            val coach = pair.first
            val impossibleMenus = pair.second
            val selectedMenus = calculateRecommendMenus(impossibleMenus)
            RecommendResult(coach.name, selectedMenus)
        }
    }

    private fun calculateRecommendMenus(impossibleMenus: List<String>): List<String> {
        val selectedMenus = mutableListOf<String>()
        recommendCategories.forEach { category ->
            when (category) {
                1 -> selectedMenus.add(
                    Randoms.shuffle(Menus.JapaneseMenus.menus.filter { !impossibleMenus.contains(it) })[0]
                )

                2 -> selectedMenus.add(
                    Randoms.shuffle(Menus.KoreanMenus.menus.filter { !impossibleMenus.contains(it) })[0]
                )

                3 -> selectedMenus.add(
                    Randoms.shuffle(Menus.ChineseMenus.menus.filter { !impossibleMenus.contains(it) })[0]
                )

                4 -> selectedMenus.add(
                    Randoms.shuffle(Menus.AsianMenus.menus.filter { !impossibleMenus.contains(it) })[0]
                )

                5 -> selectedMenus.add(
                    Randoms.shuffle(Menus.WesternMenus.menus.filter { !impossibleMenus.contains(it) })[0]
                )
            }
        }
        return selectedMenus
    }

}