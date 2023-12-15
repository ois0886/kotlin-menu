package menu.menu.view

import menu.menu.util.Messages
import camp.nextstep.edu.missionutils.Console
import menu.menu.model.Coach
import menu.model.menu.Menus
import menu.menu.util.toMenuCreateOrThrow

class InputView {

    fun printInputStartRecommendLaunch() {
        println(Messages.START_RECOMMENDING_LUNCH_MENU)
        println()
    }

    fun printInputCoachName(): List<Coach> {
        println(Messages.INPUT_COACH_NAMES)
        val input = Console.readLine()
        val coaches = input.split(COMMA)
        println()

        return coaches.map { coach ->
            Coach.createOrThrow(coach)
        }
    }

    fun printInputImpossibleMenus(coach: Coach): List<Menus> {
        println("${coach.name}${Messages.INPUT_IMPOSSIBLE_MENU}")
        val input = Console.readLine()
        if (input.isBlank()) return emptyList()

        val menus = input.split(COMMA)
        require(menus.size <= 2) { Messages.ERROR_TWO_MENUS_OVER }
        println()
        return menus.map { menu ->
            return@map menu.toMenuCreateOrThrow()
        }
    }

    companion object {
        const val COMMA = ","
    }

}