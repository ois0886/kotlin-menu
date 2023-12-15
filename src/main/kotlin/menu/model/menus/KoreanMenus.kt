package menu.model.menus

enum class KoreanMenus(override val koreanName: String) : Menus {
    GIMBAP("김밥"),
    KIMCHI_JJIGAE("김치찌개"),
    SSAM_BAP("쌈밥"),
    DOENJANG_JJIGAE("된장찌개"),
    BIBIMBAP("비빔밥"),
    KALGUKSU("칼국수"),
    BULGOGI("불고기"),
    TTEOKBOKKI("떡볶이"),
    JAEYUK_BOKKEUM("제육볶음");
}