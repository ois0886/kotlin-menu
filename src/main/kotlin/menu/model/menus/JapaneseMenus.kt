package menu.model.menu

enum class JapaneseMenus(override val koreanName: String) : Menus {
    GYUDON("규동"),
    UDON("우동"),
    MISOSHIRU("미소시루"),
    SUSHI("스시"),
    KATSUDON("가츠동"),
    ONIGIRI("오니기리"),
    HAYARICE("하이라이스"),
    RAMEN("라멘"),
    OKONOMIYAKI("오코노미야끼");
}