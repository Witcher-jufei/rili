package com.yitools.rili.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.yitools.rili.helpers.OTHER_EVENT

@Entity(tableName = "event_types", indices = [(Index(value = ["id"], unique = true))])
data class EventType(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "color") var color: Int,
    @ColumnInfo(name = "caldav_calendar_id") var caldavCalendarId: Int = 0,
    @ColumnInfo(name = "caldav_display_name") var caldavDisplayName: String = "",
    @ColumnInfo(name = "caldav_email") var caldavEmail: String = "",
    @ColumnInfo(name = "type") var type: Int = OTHER_EVENT
) {
    fun getDisplayTitle() = if (caldavCalendarId == 0) title else "$caldavDisplayName ($caldavEmail)"

    fun isSyncedEventType() = caldavCalendarId != 0
}
