package com.gfxgamerlab.shizukuplus.ui.screen

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.os.Build
import android.widget.ImageView
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.gfxgamerlab.shizukuplus.R
import com.gfxgamerlab.shizukuplus.manage.GameBoosterManager
import com.gfxgamerlab.shizukuplus.ui.component.FeaturePlateIcon
import com.gfxgamerlab.shizukuplus.ui.component.ScrollToTopButton
import com.gfxgamerlab.shizukuplus.ui.component.SegmentedCard
import com.gfxgamerlab.shizukuplus.ui.component.SegmentedListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

data class AppItem(
    val name: String,
    val packageName: String,
    val icon: Drawable?
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameBoosterScreen(bottomPadding: Dp) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        GameBoosterManager.init(context)
    }

    val isGamingModeActive = GameBoosterManager.isGamingModeActive
    val currentFps = GameBoosterManager.currentFps
    val fpsHistory = GameBoosterManager.fpsHistory
    val selectedGame = GameBoosterManager.selectedGame
    val performanceModeEnabled = GameBoosterManager.performanceModeEnabled
    val ramCleanerEnabled = GameBoosterManager.ramCleanerEnabled
    val smartDnsEnabled = GameBoosterManager.smartDnsEnabled
    val notifBlockerEnabled = GameBoosterManager.notifBlockerEnabled
    val gpuMsaaEnabled = GameBoosterManager.gpuMsaaEnabled
    val thermalGuardEnabled = GameBoosterManager.thermalGuardEnabled
    val deviceTemperature = GameBoosterManager.deviceTemperature
    val isThermalThrottlingWarning = GameBoosterManager.isThermalThrottlingWarning
    val bestDnsServer = GameBoosterManager.bestDnsServer

    var showAppPickerDialog by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(stringResource(R.string.tab_game_booster)) },
            windowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            val listState = rememberLazyListState()
            LazyColumn(
                state = listState,
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = bottomPadding
                ),
                verticalArrangement = Arrangement.spacedBy(13.dp)
            ) {
                // 1. Banner & Status Card
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.5.dp, Color(0xFFE50914), RoundedCornerShape(18.dp)),
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Black)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.gfx_gaming_banner),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.verticalGradient(
                                            colors = listOf(Color.Black.copy(alpha = 0.2f), Color.Black.copy(alpha = 0.85f))
                                        )
                                    )
                            )

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(14.dp),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(10.dp)
                                                .background(
                                                    if (isGamingModeActive) Color(0xFF34C759) else Color(0xFFE50914),
                                                    CircleShape
                                                )
                                        )
                                        Text(
                                            text = if (isGamingModeActive) "GAMING MODE ACTIVE" else "READY TO BOOST",
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 11.sp
                                        )
                                    }
                                    if (selectedGame != null) {
                                        Surface(
                                            shape = RoundedCornerShape(6.dp),
                                            color = Color(0xFFE50914).copy(alpha = 0.4f)
                                        ) {
                                            Row(
                                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                                            ) {
                                                if (selectedGame.icon != null) {
                                                    AndroidView(
                                                        factory = { ctx ->
                                                            ImageView(ctx).apply {
                                                                scaleType = ImageView.ScaleType.FIT_CENTER
                                                            }
                                                        },
                                                        update = { view ->
                                                            view.setImageDrawable(selectedGame.icon)
                                                        },
                                                        modifier = Modifier.size(14.dp)
                                                    )
                                                }
                                                Text(
                                                    text = selectedGame.name,
                                                    color = Color.White,
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Medium
                                                )
                                            }
                                        }
                                    }
                                }

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "GFX Game Booster Pro",
                                        color = Color.White,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Button(
                                        onClick = { GameBoosterManager.toggleGamingMode(context) },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = if (isGamingModeActive) Color(0xFFD32F2F) else Color(0xFFE50914)
                                        ),
                                        shape = RoundedCornerShape(10.dp),
                                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                                    ) {
                                        Icon(
                                            imageVector = if (isGamingModeActive) Icons.Outlined.Stop else Icons.Outlined.PlayArrow,
                                            contentDescription = null,
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text(
                                            text = if (isGamingModeActive) "Stop" else "Start",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 13.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                // 2. Live FPS & Temperature Telemetry Display & Waveform Graph
                item {
                    SegmentedCard {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                FeaturePlateIcon(Icons.Outlined.Speed)
                                Column {
                                    Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                        Text(
                                            text = if (isGamingModeActive) "$currentFps" else "0",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 24.sp,
                                            color = Color.White
                                        )
                                        Text(
                                            text = "FPS",
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 12.sp,
                                            color = if (isGamingModeActive) Color(0xFFE50914) else Color.Gray,
                                            modifier = Modifier.padding(bottom = 3.dp)
                                        )
                                        if (deviceTemperature > 0f) {
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(
                                                text = "· %.1f°C".format(deviceTemperature),
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 14.sp,
                                                color = when {
                                                    deviceTemperature >= 43.0f -> Color(0xFFFF3B30)
                                                    deviceTemperature >= 40.0f -> Color(0xFFFF9500)
                                                    else -> Color(0xFF34C759)
                                                },
                                                modifier = Modifier.padding(bottom = 3.dp)
                                            )
                                        }
                                    }
                                    Text(
                                        text = when {
                                            isThermalThrottlingWarning -> "⚠️ Thermal Guard Active (${"%.1f".format(deviceTemperature)}°C)"
                                            isGamingModeActive -> "Live Telemetry"
                                            else -> "Telemetry OFF"
                                        },
                                        style = MaterialTheme.typography.bodySmall,
                                        color = if (isThermalThrottlingWarning) Color(0xFFFF3B30) else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .width(130.dp)
                                    .height(44.dp)
                                    .background(Color(0xFF0A0A0A), RoundedCornerShape(8.dp))
                                    .border(1.dp, Color(0xFF330000), RoundedCornerShape(8.dp))
                                    .padding(4.dp)
                            ) {
                                Canvas(modifier = Modifier.fillMaxSize()) {
                                    val points = if (isGamingModeActive) fpsHistory.toList() else List(10) { 0f }
                                    if (points.isEmpty()) return@Canvas
                                    val maxFps = 120f
                                    val widthStep = size.width / (if (points.size > 1) points.size - 1 else 1)

                                    val path = Path().apply {
                                        points.forEachIndexed { index, fps ->
                                            val x = index * widthStep
                                            val y = size.height - (fps / maxFps) * size.height
                                            if (index == 0) moveTo(x, y) else lineTo(x, y)
                                        }
                                    }

                                    drawPath(
                                        path = path,
                                        color = if (isGamingModeActive) Color(0xFFE50914) else Color.DarkGray,
                                        style = Stroke(width = 2.5f)
                                    )
                                }
                            }
                        }
                    }
                }

                // 3. Target Game Selector ("Add Game") with App Icon Display
                item {
                    SegmentedCard {
                        SegmentedListItem(
                            modifier = Modifier.clickable { showAppPickerDialog = true },
                            centerSlots = true,
                            leadingContent = {
                                if (selectedGame?.icon != null) {
                                    AndroidView(
                                        factory = { ctx ->
                                            ImageView(ctx).apply {
                                                scaleType = ImageView.ScaleType.FIT_CENTER
                                            }
                                        },
                                        update = { view ->
                                            view.setImageDrawable(selectedGame.icon)
                                        },
                                        modifier = Modifier.size(36.dp)
                                    )
                                } else {
                                    FeaturePlateIcon(Icons.Outlined.SportsEsports)
                                }
                            },
                            headlineContent = { Text(selectedGame?.name ?: "Add Target Game") },
                            supportingContent = {
                                Text(
                                    if (selectedGame != null)
                                        "${selectedGame.packageName} · Tap to change"
                                    else
                                        "Tap to select target game from installed apps"
                                )
                            },
                            trailingContent = {
                                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
                            }
                        )
                    }
                }

                // Dedicated "Boost & Launch" Action Button
                item {
                    Button(
                        onClick = {
                            GameBoosterManager.executeBoostAndLaunch(context)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE50914)),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                    ) {
                        Icon(Icons.Outlined.RocketLaunch, contentDescription = null, modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (selectedGame != null) "Boost & Launch ${selectedGame.name}" else "Boost & Launch Game",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                }

                // 4. Optimization Toggles
                item {
                    SegmentedCard {
                        SegmentedListItem(
                            centerSlots = true,
                            leadingContent = { FeaturePlateIcon(Icons.Outlined.Speed) },
                            headlineContent = { Text("Performance Mode & 0.5x Anim") },
                            supportingContent = { Text("CPU & GPU frequency boost preference + 0.5x scale") },
                            trailingContent = {
                                Switch(
                                    checked = performanceModeEnabled,
                                    onCheckedChange = { GameBoosterManager.setPerformanceMode(context, it) }
                                )
                            }
                        )
                    }
                }
                item {
                    SegmentedCard {
                        SegmentedListItem(
                            centerSlots = true,
                            leadingContent = { FeaturePlateIcon(Icons.Outlined.Memory) },
                            headlineContent = { Text("RAM Cleaner & Cache Trim") },
                            supportingContent = { Text("Background cache & memory compaction preference") },
                            trailingContent = {
                                Switch(
                                    checked = ramCleanerEnabled,
                                    onCheckedChange = { GameBoosterManager.setRamCleaner(context, it) }
                                )
                            }
                        )
                    }
                }
                item {
                    SegmentedCard {
                        SegmentedListItem(
                            centerSlots = true,
                            leadingContent = { FeaturePlateIcon(Icons.Outlined.NetworkCheck) },
                            headlineContent = { Text("Smart DNS Accelerator") },
                            supportingContent = { Text("Best: $bestDnsServer") },
                            trailingContent = {
                                Switch(
                                    checked = smartDnsEnabled,
                                    onCheckedChange = { GameBoosterManager.setSmartDns(context, it) }
                                )
                            }
                        )
                    }
                }
                item {
                    SegmentedCard {
                        SegmentedListItem(
                            centerSlots = true,
                            leadingContent = { FeaturePlateIcon(Icons.Outlined.DoNotDisturbOn) },
                            headlineContent = { Text("Game Do Not Disturb (DND)") },
                            supportingContent = { Text("Block floating pop-ups & notifications while gaming") },
                            trailingContent = {
                                Switch(
                                    checked = notifBlockerEnabled,
                                    onCheckedChange = { GameBoosterManager.setNotifBlocker(context, it) }
                                )
                            }
                        )
                    }
                }
                item {
                    SegmentedCard {
                        SegmentedListItem(
                            centerSlots = true,
                            leadingContent = { FeaturePlateIcon(Icons.Outlined.GraphicEq) },
                            headlineContent = { Text("Force GPU 4x MSAA Anti-Aliasing") },
                            supportingContent = { Text("Sharpen textures & smooth polygon edges") },
                            trailingContent = {
                                Switch(
                                    checked = gpuMsaaEnabled,
                                    onCheckedChange = { GameBoosterManager.setGpuMsaa(context, it) }
                                )
                            }
                        )
                    }
                }
                item {
                    SegmentedCard {
                        SegmentedListItem(
                            centerSlots = true,
                            leadingContent = { FeaturePlateIcon(Icons.Outlined.Thermostat) },
                            headlineContent = { Text("Thermal Guard & Temp Monitor") },
                            supportingContent = { Text("Live temp monitoring & overheat protection") },
                            trailingContent = {
                                Switch(
                                    checked = thermalGuardEnabled,
                                    onCheckedChange = { GameBoosterManager.setThermalGuard(context, it) }
                                )
                            }
                        )
                    }
                }
            }

            ScrollToTopButton(
                listState = listState,
                bottomPadding = bottomPadding,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
    }

    if (showAppPickerDialog) {
        AppPickerDialog(
            onDismiss = { showAppPickerDialog = false },
            onSelect = { app ->
                GameBoosterManager.setSelectedGame(context, app)
                showAppPickerDialog = false
            }
        )
    }
}

@Composable
private fun AppPickerDialog(onDismiss: () -> Unit, onSelect: (AppItem) -> Unit) {
    val context = LocalContext.current
    var apps by remember { mutableStateOf<List<AppItem>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var searchQuery by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        apps = withContext(Dispatchers.IO) {
            val pm = context.packageManager
            val installedApps = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                pm.getInstalledApplications(PackageManager.ApplicationInfoFlags.of(PackageManager.GET_META_DATA.toLong()))
            } else {
                @Suppress("DEPRECATION")
                pm.getInstalledApplications(PackageManager.GET_META_DATA)
            }

            installedApps
                .filter { appInfo ->
                    val isSystem = (appInfo.flags and ApplicationInfo.FLAG_SYSTEM) != 0
                    val isUpdatedSystem = (appInfo.flags and ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0
                    val isGame = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        appInfo.category == ApplicationInfo.CATEGORY_GAME
                    } else false

                    !isSystem || isUpdatedSystem || isGame
                }
                .map { appInfo ->
                    val name = pm.getApplicationLabel(appInfo).toString()
                    val pkg = appInfo.packageName
                    val icon = runCatching { pm.getApplicationIcon(appInfo) }.getOrNull()
                    AppItem(name, pkg, icon)
                }
                .sortedBy { it.name.lowercase() }
        }
        isLoading = false
    }

    val filteredApps = remember(apps, searchQuery) {
        val query = searchQuery.trim()
        if (query.isEmpty()) {
            apps
        } else {
            apps.filter {
                it.name.contains(query, ignoreCase = true) ||
                it.packageName.contains(query, ignoreCase = true)
            }
        }
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Select Target Game") },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Search installed games & apps...") },
                    leadingIcon = { Icon(Icons.Outlined.Search, contentDescription = null) },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { searchQuery = "" }) {
                                Icon(Icons.Outlined.Clear, contentDescription = "Clear search")
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp)
                )

                Box(
                    modifier = Modifier
                        .height(320.dp)
                        .fillMaxWidth()
                ) {
                    if (isLoading) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator(color = Color(0xFFE50914))
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "Loading installed apps...",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    } else if (filteredApps.isEmpty()) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.SearchOff,
                                contentDescription = null,
                                modifier = Modifier.size(40.dp),
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "No matching games or apps found",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    } else {
                        LazyColumn(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            items(filteredApps, key = { it.packageName }) { app ->
                                Surface(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { onSelect(app) },
                                    shape = RoundedCornerShape(10.dp),
                                    color = MaterialTheme.colorScheme.surfaceVariant
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .padding(10.dp)
                                            .fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                                    ) {
                                        if (app.icon != null) {
                                            AndroidView(
                                                factory = { ctx ->
                                                    ImageView(ctx).apply {
                                                        scaleType = ImageView.ScaleType.FIT_CENTER
                                                    }
                                                },
                                                update = { view ->
                                                    view.setImageDrawable(app.icon)
                                                },
                                                modifier = Modifier.size(40.dp)
                                            )
                                        } else {
                                            Box(
                                                modifier = Modifier
                                                    .size(40.dp)
                                                    .background(
                                                        MaterialTheme.colorScheme.outlineVariant,
                                                        RoundedCornerShape(8.dp)
                                                    ),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Icon(
                                                    imageVector = Icons.Outlined.SportsEsports,
                                                    contentDescription = null,
                                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                                )
                                            }
                                        }
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = app.name,
                                                style = MaterialTheme.typography.bodyMedium,
                                                fontWeight = FontWeight.Bold,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                            Text(
                                                text = app.packageName,
                                                style = MaterialTheme.typography.bodySmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                                fontSize = 11.sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
