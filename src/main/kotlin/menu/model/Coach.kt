package menu.model

import menu.util.Messages

class Coach private constructor(val name: String) {

    companion object {
        fun createOrThrow(input: String): Coach {
            val name = input.trim()
            require(name.length >= 2) { Messages.ERROR_COACH_NAME_SHOULD_BE_AT_LEAST_2_CHARACTERS }
            require(name.length <= 4) { Messages.ERROR_COACH_NAME_SHOULD_BE_AT_MOST_4_CHARACTERS }
            require(name.isNotBlank()) { Messages.ERROR_COACH_NAME_CANNOT_HAVE_WHITESPACE }
            require(!name.any { it.isDigit() }) { Messages.ERROR_COACH_NAME_CANNOT_CONTAIN_DIGITS }

            return Coach(name = name)
        }
    }

}