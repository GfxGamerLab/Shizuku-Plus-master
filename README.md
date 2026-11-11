# Shizuku Plus (GFX Gamer Lab Edition)

---

## 🚀 Overview

**Shizuku Plus (GFX Gamer Lab Edition)** is a high-performance, precision-engineered Android utility designed for mobile gamers, power users, and developers. Built on top of the open Shizuku ecosystem, it introduces self-healing neural watchdog mechanics, dynamic TCP tunneling, zero-latency gaming tweaks, and intelligent performance optimization—all wrapped in a sleek 3D glassmorphism dark-red UI.

---

## ✨ Key Features & Architecture

### 1. 🛡️ Auto-Heal Neural Watchdog & Zero-Click TCP Tunnel

* **Continuous Monitoring:** Periodically pings the Shizuku server binder state (`Shizuku.pingBinder()`).
* **Self-Healing Recovery:** If network shifts (Wi-Fi drop or switching to mobile data) cause a disconnect, the background tunnel automatically re-binds local sockets within milliseconds **without requiring manual re-pairing**.
* **Smart Exponential Backoff:** Prevents battery and CPU drain by implementing intelligent retry limits if the service terminates permanently.

### 2. ⚡ Smart Local TCP Bridge

* **Dynamic Port Scanning:** Automatically scans local loopback (`127.0.0.1`) ports when Android Wireless Debugging dynamically shifts ports (e.g., changing from `5555` to a randomized port).
* **Seamless Re-binding:** Keeps active shell sessions alive without breaking your workflow or gaming session.

### 3. 🎮 Advanced Gaming Mode & Performance Engine

* **Performance Governor Locks:** Enforces high-frequency CPU/GPU preferences on demand.
* **Smart Animation Scaling:** Automatically forces UI window/transition scales to **0.5x** during gaming for snappy navigation and explicitly restores **0.5x** upon exit to ensure device UI remains fast.
* **Game Do Not Disturb (DND):** Suppresses floating notifications and pop-ups so competitive matches remain uninterrupted.
* **Force GPU Rendering & 4x MSAA:** Sharpens textures and smooths out polygon edges globally.
* **Thermal Guard & Temp Monitor:** Real-time battery/CPU temperature tracking with safety throttles to prevent device overheating.

### 4. 🌐 Smart DNS Accelerator

* Live-pings top gaming DNS providers (Cloudflare `1.1.1.1`, Google `8.8.8.8`, Quad9) to automatically route traffic through the lowest latency option.

---

## 📸 Screenshots Preview

| Dashboard & Status | Wireless Debugging & Advanced | Gaming Mode & Toolkit |
| --- | --- | --- |
| *(Add screenshot)* | *(Add screenshot)* | *(Add screenshot)* |

---

## 📥 Installation & Setup

1. **Install Shizuku:** Download and install the official [Shizuku App](https://shizuku.rikka.app).
2. **Start Wireless Debugging:** Enable **Developer Options** and **Wireless Debugging** on your Android device. Pair Shizuku using a pairing code or wireless debugging notification.
3. **Install Shizuku Plus:** Download the latest release APK from the Releases Page.
4. **Configure Advanced Settings:** Open **`Settings > Wireless debugging`**, toggle on **Auto-Heal Neural Watchdog** or **Smart Local TCP Bridge** inside the Advanced box for absolute stability.

---

## 💻 Developer Integration Guide

Want to build custom Shizuku-supported modules or integrate rootless shell execution into your own apps? Follow this engineering guide:

### Step 1: Add Dependencies

Add the official Shizuku API and provider dependencies to your app's `build.gradle.kts`:

```kotlin
dependencies {
    implementation("dev.rikka.shizuku:api:13.1.5")
    implementation("dev.rikka.shizuku:provider:13.1.5")
}
```

### Step 2: Check & Request Permissions

Shizuku operations require runtime authorization. Check for permission before executing any privileged shell commands:

```kotlin
import rikka.shizuku.Shizuku

fun checkAndRequestShizukuPermission() {
    if (Shizuku.isPreV11() || Shizuku.getVersion() < 11) {
        return
    }

    if (Shizuku.checkSelfPermission() == android.content.pm.PackageManager.PERMISSION_GRANTED) {
        // Permission already granted!
    } else if (Shizuku.shouldShowRequestPermissionRationale()) {
        // Explain to the user why permission is required
    } else {
        // Request permission
        Shizuku.requestPermission(REQUEST_CODE_PERMISSION)
    }
}
```

### Step 3: Execute Rootless Shell Processes

Use `Shizuku.newProcess()` to execute commands with shell (`uid 2000`) privileges without needing root access:

```kotlin
fun executeShellCommand(command: String): String {
    try {
        val process = Shizuku.newProcess(arrayOf("sh", "-c", command), null, null)
        val output = process.inputStream.bufferedReader().use { it.readText() }
        process.waitFor()
        return output
    } catch (e: Exception) {
        e.printStackTrace()
        return "Error: ${e.message}"
    }
}
```

### Important Developer Best Practices:

* **Lifecycle Awareness:** Always listen to binder lifecycle listeners (`Shizuku.OnBinderReceivedListener` and `OnBinderDeadListener`) to handle service drops gracefully.
* **Non-Blocking Threads:** Never execute shell commands on the main UI thread; always use Kotlin Coroutines (`Dispatchers.IO`).
* **OEM Compatibility:** Wrap custom system commands in `try-catch` blocks to ensure silent failure on heavily customized OEM ROMs.

---

## 🌐 Connect & Follow GFX Gamer Lab

Stay updated with new tool releases, source drops, and gaming optimizations:

* **YouTube:** [GFX Gamer Lab](https://www.google.com/search?q=https://youtube.com/%40GfxGamerLab)
* **Telegram Community:** [Join our Channel](https://t.me/GfxGamerLab)

---

## 📜 License & Acknowledgments

* Distributed under the **MIT License**.
* Built on top of the open-source [Shizuku framework by RikkaApps](https://github.com/rikkaapps/shizuku) and inspired by community advancements.
