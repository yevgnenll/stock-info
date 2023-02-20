package me.yevgnenll.stock.dto


data class Meta(
    var currency: String? = null,
    var symbol: String? = null,
    var exchangeName: String? = null,
    var instrumentType: String? = null,
    var firstTradeDate: Int? = null,
    var regularMarketTime: Int? = null,
    var gmtoffset: Int? = null,
    var timezone: String? = null,
    var exchangeTimezoneName: String? = null,
    var regularMarketPrice: Int? = null,
    var chartPreviousClose: Int? = null,
    var priceHint: Int? = null,
    var currentTradingPeriod: CurrentTradingPeriod? = CurrentTradingPeriod(),
    var dataGranularity: String? = null,
    var range: String? = null,
    var validRanges: ArrayList<String> = arrayListOf()
)