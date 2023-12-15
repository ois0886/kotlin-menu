package menu.menu.model

import menu.menu.util.Messages

class Coach private constructor(val name: String) {

    companion object {
        fun createOrThrow(input: String): Coach {
            val name = input.trim()
            require(name.length >= 2) { Messages.ERROR_COACH_NAME_SHOULD_BE_AT_LEAST_2_CHARACTERS }
            require(name.length <= 5) { Messages.ERROR_COACH_NAME_SHOULD_BE_AT_MOST_5_CHARACTERS }
            require(name.isNotBlank()) { Messages.ERROR_COACH_NAME_CANNOT_HAVE_WHITESPACE }
            require(!name.any { it.isDigit() }) { Messages.ERROR_COACH_NAME_CANNOT_CONTAIN_DIGITS }

            return Coach(name = name)
        }
    }

}