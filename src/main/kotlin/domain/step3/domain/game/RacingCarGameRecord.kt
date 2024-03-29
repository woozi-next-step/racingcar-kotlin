package domain.step3.domain.game

import domain.step3.domain.racingcar.RacingCars

@JvmInline
value class RacingCarGameRecord(private val _racingCarGameRecord: List<RacingCars>) {
    val racingCarGameRecord: List<RacingCars>
        get() = _racingCarGameRecord.toList()

    fun add(racingCars: RacingCars): RacingCarGameRecord {
        val mutableRecord = _racingCarGameRecord.toMutableList()
        mutableRecord.add(racingCars)
        return RacingCarGameRecord(mutableRecord)
    }

    companion object {
        fun initialize() = RacingCarGameRecord(listOf())
    }
}
