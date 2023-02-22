package me.yevgnenll.stock.entity

import me.yevgnenll.stock.dto.embed.Quote
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

    val name: String,
    val timestamp: LocalDate,

    // TODO: Int -> Long
    var low: Int,
    var high: Int,
    var close: Int,
    val open: Int,
    var volume: Int,

    @Column(name = "created_at", updatable = false)
    var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null
): Comparable<LocalDate> {

    constructor(timestamp: List<LocalDateTime>, name: String, quote: Quote, index: Int): this(
        timestamp = timestamp[index].toLocalDate(),
        name = name,
        high = quote.high[index].toInt(),
        low = quote.low[index].toInt(),
        open = quote.open[index].toInt(),
        close = quote.close[index].toInt(),
        volume = quote.volume[index].toInt(),
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

    fun update(stock: Stock) {
        high = stock.high
        low = stock.low
        volume = stock.volume
        close = stock.close
    }

    override fun compareTo(other: LocalDate): Int {
        return timestamp.compareTo(other)
    }
}