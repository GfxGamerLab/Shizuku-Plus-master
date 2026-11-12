<div align="center">

<img src="screenshots/banner.png" alt="GFX Gamer Lab - Shizuku Plus Banner" width="100%">

# ⚡ Shizuku Plus — GFX Gamer Lab Edition

### Rootless Android Gaming Optimizer • Self-Healing Shizuku • Built-in Data Explorer

**Run ADB-level commands, boost FPS, reduce lag, and browse `Android/data` & `Android/obb` — all without root.**

[![Download](https://img.shields.io/badge/⬇_Download-Latest%20APK-d32f2f?style=for-the-badge&logo=android&logoColor=white)](https://github.com/GfxGamerLab/Shizuku-Plus-master/releases)
[![Telegram](https://img.shields.io/badge/Telegram-Join%20Channel-229ED9?style=for-the-badge&logo=telegram&logoColor=white)](https://t.me/gfxgamerlab)
[![WhatsApp](https://img.shields.io/badge/WhatsApp-Follow%20Channel-25D366?style=for-the-badge&logo=whatsapp&logoColor=white)](https://whatsapp.com/channel/0029VbB1E5VFsn0o8MNoAp2l/633)

[![YouTube](https://img.shields.io/badge/YouTube-GFX%20Gamer%20Lab-FF0000?style=for-the-badge&logo=youtube&logoColor=white)](https://www.youtube.com/@GfxGamerLab_1)
[![Facebook](https://img.shields.io/badge/Facebook-Follow-1877F2?style=for-the-badge&logo=facebook&logoColor=white)](https://www.facebook.com/share/1MdEAMBYKA/)
[![TikTok](https://img.shields.io/badge/TikTok-@gfxgamerlab-000000?style=for-the-badge&logo=tiktok&logoColor=white)](https://www.tiktok.com/@gfxgamerlab?_r=1&_t=ZS-99if0dzAB3F)
[![Instagram](https://img.shields.io/badge/Instagram-@gfxgamerlab-E4405F?style=for-the-badge&logo=instagram&logoColor=white)](https://www.instagram.com/gfxgamerlab?rpxt=dXI0bGx6MnVnbzdm)

![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?logo=android&logoColor=white)
![Root](https://img.shields.io/badge/Root-Not%20Required-success)
![Language](https://img.shields.io/badge/Kotlin%20%7C%20Java-7F52FF?logo=kotlin&logoColor=white)
![License](https://img.shields.io/badge/License-Apache--2.0-blue)
![Based on](https://img.shields.io/badge/Based%20on-Shizuku-7c4dff)
![Stars](https://img.shields.io/github/stars/GfxGamerLab/Shizuku-Plus-master?style=flat&logo=github)
![Downloads](https://img.shields.io/github/downloads/GfxGamerLab/Shizuku-Plus-master/total?color=d32f2f)

</div>

---

## 📖 Table of Contents

- [What is Shizuku Plus?](#-what-is-shizuku-plus)
- [Why Shizuku Plus?](#-why-shizuku-plus)
- [Key Features](#-key-features)
- [Screenshots](#-screenshots)
- [Download & Installation](#-download--installation)
- [Tech Stack & Architecture](#-tech-stack--architecture)
- [Developer Integration Guide](#-developer-integration-guide)
- [FAQ](#-faq)
- [Community & Social Media](#-community--social-media)
- [Contributing](#-contributing)
- [License, Credits & Disclaimer](#-license-credits--disclaimer)

---

## 🔥 What is Shizuku Plus?

**Shizuku Plus (GFX Gamer Lab Edition)** is a high-performance, rootless Android optimization and utility suite — a custom fork of the open-source [Shizuku](https://github.com/RikkaApps/Shizuku) ecosystem built for **mobile gamers, power users, and developers**.

It lets you run shell commands, apply gaming performance tweaks, manage high-privilege tasks, and explore protected system folders **without rooting your device**, using Shizuku's binder IPC with shell (`uid 2000`) privileges over **Wireless Debugging**.

> 💡 **No root. No PC needed after setup. Just Wireless Debugging + Shizuku Plus.**

---

## 🎯 Why Shizuku Plus?

| Problem with stock Shizuku | Shizuku Plus solution |
| --- | --- |
| Service stops after Wi-Fi change or reboot | 🛡️ **Auto-Heal Neural Watchdog** restarts and re-binds automatically |
| Wireless Debugging port keeps changing | 🔌 **Smart Local TCP Bridge** scans and reconnects dynamically |
| Can't open `Android/data` & `Android/obb` on Android 11+ | 📂 **Built-in GFX Data Explorer** with shell-level access |
| No gaming-focused tools | 🎮 **Game Booster & Performance Engine** included |
| Basic, plain UI | 🎨 **Dark-Red 3D Glassmorphism UI** |

---

## ✨ Key Features

### 📂 Built-in GFX Data Explorer
No external file manager required. Browse, copy, move, and organize protected game files inside `/Android/data/` and `/Android/obb/` using native shell (`uid 2000`) privileges, powered by a custom AIDL privileged file service (`IPrivilegedFiles.aidl`).

### 🛡️ Auto-Heal Neural Watchdog & Zero-Click TCP Tunnel

| Feature | What it does |
| --- | --- |
| **Continuous monitoring** | Periodically checks the Shizuku binder state via `Shizuku.pingBinder()`. |
| **Self-healing recovery** | If Wi-Fi drops or you switch to mobile data, the tunnel re-binds local sockets within milliseconds — **no manual re-pairing**. |
| **Smart exponential backoff** | Limits retries when the service terminates permanently, saving battery and CPU. |

### ⚡ Smart Local TCP Bridge

| Feature | What it does |
| --- | --- |
| **Dynamic port scanning** | Scans loopback (`127.0.0.1`) when Wireless Debugging shifts ports (e.g. `5555` → a random port). |
| **Seamless re-binding** | Keeps active shell sessions alive so your game or workflow isn't interrupted. |

### 🎮 Advanced Gaming Mode & Performance Engine

| Feature | What it does |
| --- | --- |
| **Performance governor locks** | Enforces high-frequency CPU/GPU preferences on demand. |
| **Smart animation scaling** | Sets window/transition scales to **0.5x** while gaming and restores them on exit. |
| **Game Do Not Disturb** | Suppresses floating notifications and pop-ups during matches. |
| **Force GPU rendering & 4x MSAA** | Sharper textures and smoother polygon edges, globally. |
| **Thermal guard & temp monitor** | Real-time battery/CPU temperature tracking with safety throttles. |
| **Game booster compatibility** | Optimized execution hooks for lag reducers and custom frame-rate tools. |

### 🌐 Smart DNS Accelerator
Live-pings top gaming DNS providers — **Cloudflare** `1.1.1.1`, **Google** `8.8.8.8`, **Quad9** — and routes traffic through the lowest-latency option.

### 🛡️ Non-Root Shell Execution
Run ADB commands, system boosters, and performance tweaks securely via Shizuku's binder IPC — no root, no Magisk.

### 🎨 Dark-Red Glassmorphism UI
A clean, custom-designed gaming aesthetic made for performance creators and gamers.

### 📦 Custom Package Identity
Structured under the namespace `com.gfxgamerlab.shizukuplus` for clean app identity and management.

---

## 📸 Screenshots

<table>
  <tr>
    <td align="center"><b>Dashboard & Status</b></td>
    <td align="center"><b>App Management</b></td>
    <td align="center"><b>Shizuku Modules</b></td>
  </tr>
  <tr>
    <td><img src="screenshots/dashboard.jpg.jfif" alt="Shizuku Plus Dashboard" width="260"></td>
    <td><img src="screenshots/apps.jpg.jfif" alt="Shizuku Plus App Management" width="260"></td>
    <td><img src="screenshots/modules.jpg.jfif" alt="Shizuku Plus Modules" width="260"></td>
  </tr>
  <tr>
    <td align="center"><b>Game Booster & Telemetry</b></td>
    <td align="center"><b>Labs Toolkit</b></td>
    <td align="center"><b>Settings & Branding</b></td>
  </tr>
  <tr>
    <td><img src="screenshots/gamebooster.jpg.jfif" alt="Shizuku Plus Game Booster" width="260"></td>
    <td><img src="screenshots/labs.jpg.jfif" alt="Shizuku Plus Labs Toolkit" width="260"></td>
    <td><img src="screenshots/settings.jpg.jfif" alt="Shizuku Plus Settings" width="260"></td>
  </tr>
  <tr>
    <td align="center" colspan="3"><b>Wireless Debugging & Advanced Watchdog</b></td>
  </tr>
  <tr>
    <td align="center" colspan="3"><img src="screenshots/wireless.jpg.jfif" alt="Shizuku Plus Wireless Debugging" width="260"></td>
  </tr>
</table>

---

## 📥 Download & Installation

> ✅ Requires Android 11+ (Wireless Debugging) • ❌ No root required

1. **Install Shizuku** — get the official [Shizuku app](https://shizuku.rikka.app).
2. **Enable Wireless Debugging** — go to **Developer Options → Wireless Debugging**, then pair Shizuku using the pairing code or notification.
3. **Download Shizuku Plus** — grab the latest APK (`shizuku-v1.0.0-release.apk`) from the **[Releases page](https://github.com/GfxGamerLab/Shizuku-Plus-master/releases)**.
4. **Install the APK** on your Android device.
5. **Start Shizuku** via Wireless Debugging.
6. **Turn on stability features** — **Settings → Wireless debugging → Advanced** → enable **Auto-Heal Neural Watchdog** and/or **Smart Local TCP Bridge**.

[![Download Latest Release](https://img.shields.io/badge/⬇_Download_Latest_Release-d32f2f?style=for-the-badge)](https://github.com/GfxGamerLab/Shizuku-Plus-master/releases)

---

## 🛠️ Tech Stack & Architecture

| Layer | Technology |
| --- | --- |
| **Language** | Kotlin & Java |
| **UI Framework** | Android Jetpack, Compose & Material Design |
| **IPC Bridge** | Shizuku Binder API (`rikka.shizuku`) |
| **Privileged File Service** | Custom AIDL (`IPrivilegedFiles.aidl`) running under shell UID 2000 |
| **Privileges** | Shell (`uid 2000`) via Wireless Debugging — no root |

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

- **Lifecycle awareness** — use `Shizuku.OnBinderReceivedListener` and `OnBinderDeadListener`.
- **Stay off the main thread** — run commands on `Dispatchers.IO`.
- **OEM compatibility** — wrap custom system commands in `try/catch` for heavily customized ROMs.

---

## ❓ FAQ

<details>
<summary><b>Do I need root to use Shizuku Plus?</b></summary>
No. Everything runs through Shizuku with shell (<code>uid 2000</code>) privileges over Wireless Debugging.
</details>

<details>
<summary><b>Can I access Android/data and Android/obb folders?</b></summary>
Yes. The built-in GFX Data Explorer uses a privileged file service to browse and manage these folders without an external file manager.
</details>

<details>
<summary><b>Does it work after reboot or Wi-Fi change?</b></summary>
Shizuku Plus includes an Auto-Heal Watchdog and Smart TCP Bridge to help recover the service and reconnect when Wireless Debugging ports change. Android may still require Wireless Debugging to be re-enabled on some devices after a reboot.
</details>

<details>
<summary><b>Will it improve my game FPS?</b></summary>
It applies performance-oriented tweaks (animation scaling, GPU rendering preferences, DND, thermal monitoring). Results vary by device, ROM, and game.
</details>

<details>
<summary><b>Is it safe?</b></summary>
The project is open source under Apache-2.0, so you can review the code. Only grant Shizuku permission to apps you trust.
</details>

---

## 🌐 Community & Social Media

Get new tool releases, source drops, tutorials, and gaming optimizations first:

| Platform | Link |
| --- | --- |
| ▶️ **YouTube** | [GFX Gamer Lab](https://www.youtube.com/@GfxGamerLab_1) |
| 💬 **Telegram** | [t.me/gfxgamerlab](https://t.me/gfxgamerlab) |
| 🟢 **WhatsApp Channel** | [Follow the channel](https://whatsapp.com/channel/0029VbB1E5VFsn0o8MNoAp2l/633) |
| 📘 **Facebook** | [GFX Gamer Lab](https://www.facebook.com/share/1MdEAMBYKA/) |
| 🎵 **TikTok** | [@gfxgamerlab](https://www.tiktok.com/@gfxgamerlab?_r=1&_t=ZS-99if0dzAB3F) |
| 📸 **Instagram** | [@gfxgamerlab](https://www.instagram.com/gfxgamerlab?rpxt=dXI0bGx6MnVnbzdm) |

---

## 🤝 Contributing

Contributions, bug reports, and feature requests are welcome!

1. Fork the repository
2. Create your branch: `git checkout -b feature/amazing-feature`
3. Commit your changes: `git commit -m "Add amazing feature"`
4. Push the branch: `git push origin feature/amazing-feature`
5. Open a Pull Request

Found a bug? [Open an issue](https://github.com/GfxGamerLab/Shizuku-Plus-master/issues).

---

## 📜 License, Credits & Disclaimer

- Developed and maintained by **Nisar Ahmad** under **GFX Gamer Lab**.
- Distributed under the **Apache-2.0 License** — see [LICENSE](LICENSE).
- Built on the open-source [Shizuku framework by RikkaApps](https://github.com/RikkaApps/Shizuku) and inspired by community work.
- **Disclaimer:** This is an independent community fork and is not affiliated with or endorsed by RikkaApps. Use performance tweaks at your own risk.

---

## 🔎 Keywords

`shizuku` `shizuku-plus` `shizuku-fork` `android-gaming` `game-booster` `fps-booster` `lag-reducer` `rootless` `no-root` `adb` `wireless-debugging` `android-data-access` `android-obb` `data-explorer` `gaming-optimizer` `android-tweaks` `performance-tweaks` `bgmi` `free-fire` `pubg` `gfx-tool` `kotlin` `jetpack-compose` `material-design`

---

<div align="center">

### ⭐ If Shizuku Plus helped you, please star the repo and share it with fellow gamers!

**Made with ❤️ by [GFX Gamer Lab](https://t.me/gfxgamerlab)**

</div>
