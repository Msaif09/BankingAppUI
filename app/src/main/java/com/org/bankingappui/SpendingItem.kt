package com.org.bankingappui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class SpendingItem(
    val name: String,
    val amount: Float,
    val color: Color,
    val icon: ImageVector
)
