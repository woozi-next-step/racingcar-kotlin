package domain.step2.strategy.calculate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MultiplyCalculateStrategyStrategyTest {

    @DisplayName("MultiplyCalculableStrategy 인스턴스 생성 여부 테스트")
    @Test
    fun constructor_test() {
        // given and when
        val calculable = MultiplyCalculateStrategyStrategy()

        // then
        assertAll(
            { assertThat(calculable).isNotNull },
            { assertThat(calculable).isExactlyInstanceOf(MultiplyCalculateStrategyStrategy::class.java) },
        )
    }

    @DisplayName("MultiplyCalculableStrategy 인스턴스 calculate() 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = ["1:1:1", "-2:2:-4", "-1:-1:1"], delimiter = ':')
    fun calculate_test(x: Int, y: Int, expected: Int) {
        // given
        val calculable = MultiplyCalculateStrategyStrategy()

        // when
        val actual = calculable.calculate(x, y)

        // then
        assertThat(actual).isEqualTo(expected)
    }
}
