package me.yevgnenll.stock.entity

import me.yevgnenll.stock.extension.convertKstToUtc
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(
    name = "stock", indexes = [
        Index(
            unique = true, name = "unique_name_timestamp", columnList = "name, timestamp"
        )]
)
@EntityListeners(value = [AuditingEntityListener::class])
data class Stock(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var name: String? = null,

    val timestamp: LocalDate,

    var low: Int,
    var high: Int,
    val close: Int,
    val open: Int,
    var volume: Int,

    @Column(name = "created_at", updatable = false)
    var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null
) {
    constructor(
        timestamp: LocalDate,
        name: String,
        low: Double, high: Double, close: Double, open: Double, volume: Double
    ) : this(
        timestamp = timestamp,
        name = name,
        low = low.toInt(),
        high = high.toInt(),
        close = close.toInt(),
        open = open.toInt(),
        volume = volume.toInt(),
    )

    @PrePersist
    private fun prePersist() {
        val now = LocalDateTime.now().convertKstToUtc()
        createdAt = now
        updatedAt = now
    }

    @PreUpdate
    private fun preUpdate() {
        updatedAt = LocalDateTime.now().convertKstToUtc()
    }

    fun placeStockName(name: String) {
        this.name = name
    }
}