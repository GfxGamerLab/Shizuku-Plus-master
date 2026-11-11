<div align="center">

# ⚡ Shizuku Plus
### GFX Gamer Lab Edition

**Self-healing Shizuku. Zero-latency gaming tweaks. No root required.**

[![Download](https://img.shields.io/badge/Download-Latest%20Release-d32f2f?style=for-the-badge&logo=android&logoColor=white)](https://github.com/GfxGamerLab/Shizuku-Plus-master/releases)
[![Telegram](https://img.shields.io/badge/Telegram-Join%20Channel-229ED9?style=for-the-badge&logo=telegram&logoColor=white)](https://t.me/GfxGamerLab)
[![YouTube](https://img.shields.io/badge/YouTube-GFX%20Gamer%20Lab-FF0000?style=for-the-badge&logo=youtube&logoColor=white)](https://youtube.com/@GfxGamerLab)

![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?logo=android&logoColor=white)
![Root](https://img.shields.io/badge/Root-Not%20Required-success)
![License](https://img.shields.io/badge/License-Apache--2.0-blue)
![Based on](https://img.shields.io/badge/Based%20on-Shizuku-7c4dff)

</div>

---

## 📖 Table of Contents

- [Overview](#-overview)
- [Key Features](#-key-features)
- [Screenshots](#-screenshots)
- [Installation](#-installation)
- [Developer Guide](#-developer-integration-guide)
- [Community](#-community)
- [License & Credits](#-license--credits)

---

## 🚀 Overview

**Shizuku Plus (GFX Gamer Lab Edition)** is a high-performance Android utility built for mobile gamers, power users, and developers. It extends the open [Shizuku](https://github.com/rikkaapps/shizuku) ecosystem with:

- 🛡️ a **self-healing watchdog** that keeps the Shizuku service alive,
- 🔌 a **dynamic local TCP bridge** that survives Wireless Debugging port changes,
- 🎮 a **gaming performance engine**, and
- 🌐 a **smart DNS accelerator**

— all in a dark-red 3D glassmorphism UI.

> **No root needed.** Everything runs through Shizuku with shell (`uid 2000`) privileges over Wireless Debugging.

---

## ✨ Key Features

### 🛡️ Auto-Heal Neural Watchdog & Zero-Click TCP Tunnel

| Feature | What it does |
| --- | --- |
| **Continuous monitoring** | Periodically pings the Shizuku binder state via `Shizuku.pingBinder()`. |
| **Self-healing recovery** | If Wi-Fi drops or you switch to mobile data, the tunnel re-binds local sockets within milliseconds — **no manual re-pairing**. |
| **Smart exponential backoff** | Limits retries if the service terminates permanently, so battery and CPU aren't drained. |

### ⚡ Smart Local TCP Bridge

| Feature | What it does |
| --- | --- |
| **Dynamic port scanning** | Scans loopback (`127.0.0.1`) when Wireless Debugging shifts ports (e.g. `5555` → a random port). |
| **Seamless re-binding** | Keeps active shell sessions alive, so your game or workflow isn't interrupted. |

### 🎮 Advanced Gaming Mode & Performance Engine

| Feature | What it does |
| --- | --- |
| **Performance governor locks** | Enforces high-frequency CPU/GPU preferences on demand. |
| **Smart animation scaling** | Forces window/transition scales to **0.5x** while gaming and restores them on exit. |
| **Game Do Not Disturb** | Suppresses floating notifications and pop-ups during matches. |
| **Force GPU rendering & 4x MSAA** | Sharper textures and smoother polygon edges, globally. |
| **Thermal guard & temp monitor** | Real-time battery/CPU temperature tracking with safety throttles. |

### 🌐 Smart DNS Accelerator

Live-pings top gaming DNS providers — **Cloudflare** `1.1.1.1`, **Google** `8.8.8.8`, **Quad9** — and routes traffic through the lowest-latency option.

---

## 📸 Screenshots

<table>
  <tr>
    <td align="center"><b>Dashboard & Status</b></td>
    <td align="center"><b>App Management</b></td>
    <td align="center"><b>Shizuku Modules</b></td>
  </tr>
  <tr>
    <td><img src="screenshots/dashboard.jpg.jfif" alt="Dashboard" width="260"></td>
    <td><img src="screenshots/apps.jpg.jfif" alt="App Management" width="260"></td>
    <td><img src="screenshots/modules.jpg.jfif" alt="Modules" width="260"></td>
  </tr>
  <tr>
    <td align="center"><b>Game Booster & Telemetry</b></td>
    <td align="center"><b>Labs Toolkit</b></td>
    <td align="center"><b>Settings & Branding</b></td>
  </tr>
  <tr>
    <td><img src="screenshots/gamebooster.jpg.jfif" alt="Game Booster" width="260"></td>
    <td><img src="screenshots/labs.jpg.jfif" alt="Labs Toolkit" width="260"></td>
    <td><img src="screenshots/settings.jpg.jfif" alt="Settings" width="260"></td>
  </tr>
  <tr>
    <td align="center" colspan="3"><b>Wireless Debugging & Advanced Watchdog</b></td>
  </tr>
  <tr>
    <td align="center" colspan="3"><img src="screenshots/wireless.jpg.jfif" alt="Wireless Debugging" width="260"></td>
  </tr>
</table>

---

## 📥 Installation

1. **Install Shizuku** — get the official [Shizuku app](https://shizuku.rikka.app).
2. **Enable Wireless Debugging** — turn on **Developer Options → Wireless Debugging**, then pair Shizuku using the pairing code or the notification.
3. **Install Shizuku Plus** — download the latest APK from the [Releases page](https://github.com/GfxGamerLab/Shizuku-Plus-master/releases).
4. **Turn on stability features** — go to **Settings → Wireless debugging → Advanced** and enable **Auto-Heal Neural Watchdog** and/or **Smart Local TCP Bridge**.

---

## 💻 Developer Integration Guide

Want to build Shizuku-powered modules or run rootless shell commands in your own app?

### Step 1 — Add dependencies

```kotlin
// build.gradle.kts
dependencies {
    implementation("dev.rikka.shizuku:api:13.1.5")
    implementation("dev.rikka.shizuku:provider:13.1.5")
}
```

### Step 2 — Check & request permission

Shizuku operations need runtime authorization. Always check before running privileged commands:

```kotlin
import rikka.shizuku.Shizuku

fun checkAndRequestShizukuPermission() {
    if (Shizuku.isPreV11() || Shizuku.getVersion() < 11) return

    when {
        Shizuku.checkSelfPermission() == PackageManager.PERMISSION_GRANTED -> {
            // Permission already granted
        }
        Shizuku.shouldShowRequestPermissionRationale() -> {
            // Explain to the user why permission is required
        }
        else -> Shizuku.requestPermission(REQUEST_CODE_PERMISSION)
    }
}
```

### Step 3 — Run rootless shell commands

`Shizuku.newProcess()` runs commands with shell (`uid 2000`) privileges, no root:

```kotlin
fun executeShellCommand(command: String): String {
    return try {
        val process = Shizuku.newProcess(arrayOf("sh", "-c", command), null, null)
        val output = process.inputStream.bufferedReader().use { it.readText() }
        process.waitFor()
        output
    } catch (e: Exception) {
        e.printStackTrace()
        "Error: ${e.message}"
    }
}
```

### ✅ Best practices

- **Lifecycle awareness** — listen to `Shizuku.OnBinderReceivedListener` and `OnBinderDeadListener` to handle service drops gracefully.
- **Stay off the main thread** — run shell commands with Kotlin Coroutines on `Dispatchers.IO`.
- **OEM compatibility** — wrap custom system commands in `try/catch` so they fail silently on heavily customized ROMs.

---

## 🌐 Community

New tool releases, source drops, and gaming optimizations:

- ▶️ **YouTube:** [GFX Gamer Lab](https://youtube.com/@GfxGamerLab)
- 💬 **Telegram:** [Join our channel](https://t.me/GfxGamerLab)

---

## 📜 License & Credits

- Developed and maintained by **Nisar Ahmad** under **GFX Gamer Lab**.
- Distributed under the **Apache-2.0 License** — see [LICENSE](LICENSE).
- Built on the open-source [Shizuku framework by RikkaApps](https://github.com/rikkaapps/shizuku) and inspired by community work.

<div align="center">

**⭐ If this helped you, star the repo!**

</div>
