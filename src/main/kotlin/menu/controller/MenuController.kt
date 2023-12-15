package menu.menu.controller

import menu.menu.model.Coach
import menu.model.menu.Menus
import menu.menu.view.InputView
import menu.menu.view.OutputView

class MenuController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {

    private fun inputCoachNames(): List<Coach> = inputUntilValid {
        return printInputCoachName()
    }

    private fun inputMenus(coach: Coach): List<Menus> = inputUntilValid {
        return printInputImpossibleMenus(coach = coach)
    }

    private inline fun <T> inputUntilValid(block: InputView.() -> T): T {
        while (true) {
            try {
                return inputView.block()
            } catch (e: IllegalArgumentException) {
                println(e.localizedMessage)
            }
        }
    }

    fun run() {
        inputView.printInputStartRecommendLaunch()
        val coaches = inputCoachNames()
        val coachAndMenus = coaches.map { coach ->
            coach to inputMenus(coach)
        }
        outputView.printRecommendCategory()
        outputView.printRecommendResults(coachAndMenus)
    }

}