package menu.view

import menu.util.Messages
import camp.nextstep.edu.missionutils.Console
import menu.model.Coach
import menu.model.Menus

class InputView {

    private val allMenus: List<String> = Menus.WesternMenus.menus +
            Menus.AsianMenus.menus +
            Menus.ChineseMenus.menus +
            Menus.KoreanMenus.menus +
            Menus.JapaneseMenus.menus

    fun printInputStartRecommendLaunch() {
        println(Messages.START_RECOMMENDING_LUNCH_MENU)
        println()
    }

    fun printInputCoachName(): List<Coach> {
        println(Messages.INPUT_COACH_NAMES)
        val input = Console.readLine()
        val coaches = input.split(COMMA)
        require(coaches.size in 2..5) { Messages.ERROR_COACH_NUMBER_SHOULD_BE_AT_LEAST_2_MOST_5 }
        println()

        return coaches.map { coach ->
            Coach.createOrThrow(coach)
        }
    }

    fun printInputImpossibleMenus(coach: Coach): List<String> {
        println("${coach.name}${Messages.INPUT_IMPOSSIBLE_MENU}")
        val input = Console.readLine()
        if (input.isBlank()) return emptyList()

        val menus = input.split(COMMA)
        require(menus.size <= 2) { Messages.ERROR_TWO_MENUS_OVER }
        println()
        return menus.map { menu ->
            require(allMenus.any { menu == it }) { Messages.ERROR_DIFFERENT_FROM_THE_SET_MENU }
            return@map menu
        }
    }

    companion object {
        const val COMMA = ","
    }

}