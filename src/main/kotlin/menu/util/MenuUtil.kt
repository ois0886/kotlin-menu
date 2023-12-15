package menu.util

import menu.model.menus.*

private val allMenus: List<Menus> = JapaneseMenus.values().toList() +
        KoreanMenus.values().toList() +
        ChineseMenus.values().toList() +
        WesternMenus.values().toList() +
        AsianMenus.values().toList()

fun String.toMenuCreateOrThrow(): Menus {
    require(allMenus.any { it.koreanName == this }) { Messages.ERROR_DIFFERENT_FROM_THE_SET_MENU }
    return allMenus.first { menu -> menu.koreanName == this }
}