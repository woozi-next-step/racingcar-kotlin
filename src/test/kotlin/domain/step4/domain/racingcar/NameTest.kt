package domain.step4.domain.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NameTest {

    @ParameterizedTest(name = "이름 : {0}")
    @ValueSource(strings = ["a", "ab", "abc", "abcd", "abcde"])
    fun `길이가 5이하인 이름이 들어오면 생성 가능하다`(nameString: String) {
        val name = Name(nameString)

        assertAll(
            { assertThat(name).isNotNull },
            { assertThat(name).isExactlyInstanceOf(Name::class.java) },
        )
    }

    @ParameterizedTest(name = "이름 : {0}")
    @ValueSource(strings = ["abcdef", "abcdefghijkmnlopqrstuvwxyz"])
    fun `길이가 5 초과인 이름인 들어오면 생성 불가능하다`(nameString: String) {
        assertThatThrownBy { Name(nameString) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(String.format("이름의 길이는 5를 초과한 %s가 입력되었습니다.", nameString.length))
    }

    // "이름 문자열은 비어있서는 안됩니다."
    @ParameterizedTest(name = "이름 : {0}")
    @ValueSource(strings = ["", " ", "   ", "     ", "          "])
    fun `공백만 있는 이름은 생성이 불가능하다`(nameString: String) {
        assertThatThrownBy { Name(nameString) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 비어있서는 안 됩니다.")
    }

    @ParameterizedTest(name = "이름 : {0}")
    @ValueSource(strings = ["a", "ab", "abc", "abcd", "abcde"])
    fun `자신의 이름을 반환할 수 있다`(nameString: String) {
        val name = Name(nameString)

        assertAll(
            { assertThat(name.name).isNotNull },
            { assertThat(name.name).isEqualTo(nameString) }
        )
    }
}
