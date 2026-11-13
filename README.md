<div align="center">

<img src="screenshots/banner.png" alt="GFX Gamer Lab - Shizuku Plus Banner" width="100%">

# ⚡ Shizuku Plus — GFX Gamer Lab Edition

### Rootless Android Gaming Optimizer • Self-Healing Shizuku • Built-in Data Explorer
#### 100% Standalone • Installs Next to Official Shizuku • Developer-Ready API

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
![Min SDK](https://img.shields.io/badge/Android-8.0%2B%20(API%2026)-3DDC84?logo=android&logoColor=white)
![Target SDK](https://img.shields.io/badge/Target-Android%2016%20(API%2036)-3DDC84?logo=android&logoColor=white)
![Standalone](https://img.shields.io/badge/Package-com.gfxgamerlab.shizukuplus-d32f2f)
![No Conflict](https://img.shields.io/badge/Official%20Shizuku-No%20Conflict-success)
![Language](https://img.shields.io/badge/Kotlin%20%7C%20Java-7F52FF?logo=kotlin&logoColor=white)
![License](https://img.shields.io/badge/License-Apache--2.0-blue)
![Based on](https://img.shields.io/badge/Based%20on-Shizuku-7c4dff)
![Stars](https://img.shields.io/github/stars/GfxGamerLab/Shizuku-Plus-master?style=flat&logo=github)
![Downloads](https://img.shields.io/github/downloads/GfxGamerLab/Shizuku-Plus-master/total?color=d32f2f)

</div>

---

## 📖 Table of Contents

- [What is Shizuku Plus?](#-what-is-shizuku-plus)
- [Video Tutorial](#-video-tutorial)
- [Why Shizuku Plus?](#-why-shizuku-plus)
- [100% Standalone — No Install Conflicts](#-100-standalone--no-install-conflicts)
- [Key Features](#-key-features)
- [Screenshots](#-screenshots)
- [Download & Installation](#-download--installation)
- [Compatibility](#-compatibility)
- [Tech Stack & Architecture](#-tech-stack--architecture)
- [Developer Integration Guide](#-developer-integration-guide)
- [Build From Source](#-build-from-source)
- [Troubleshooting](#-troubleshooting)
- [FAQ](#-faq)
- [Community & Social Media](#-community--social-media)
- [Contributing](#-contributing)
- [License, Credits & Disclaimer](#-license-credits--disclaimer)

---

## 🔥 What is Shizuku Plus?

**Shizuku Plus (GFX Gamer Lab Edition)** is a high-performance, rootless Android optimization and utility suite — a custom fork of the open-source [Shizuku](https://github.com/RikkaApps/Shizuku) ecosystem built for **mobile gamers, power users, and developers**.

It lets you run shell commands, apply gaming performance tweaks, manage high-privilege tasks, and explore protected system folders **without rooting your device**, using Shizuku's binder IPC with shell (`uid 2000`) privileges over **Wireless Debugging**.

**Shizuku Plus** is a 100% independent, standalone variant of Shizuku designed to run smoothly **alongside official Shizuku builds** without any installation conflicts (`INSTALL_FAILED_DUPLICATE_PERMISSION` or `CONFLICTING_PROVIDER`). It provides secure access to system APIs using non-root optimization strategies via ADB shell commands and Shizuku API integrations.

> 💡 **No root. No PC needed after setup. Just Wireless Debugging + Shizuku Plus.**

---

## 📺 Video Tutorial

Want to see how it works and how to set it up easily? Watch the full guide on YouTube:

👉 **[I Built an Android Game Booster That Needs NO ROOT! 🔥 (Shizuku Plus)](https://youtu.be/Fic_5dvVhLo)**

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

## 🧩 100% Standalone — No Install Conflicts

Shizuku Plus ships under its own identity, so it can live on the same phone as the official Shizuku app (or any other fork).

| Item | Official Shizuku | Shizuku Plus |
| --- | --- | --- |
| **Package name** | `moe.shizuku.privileged.api` | `com.gfxgamerlab.shizukuplus` |
| **Manager permission** | `moe.shizuku.manager.permission.MANAGER` | `com.gfxgamerlab.shizukuplus.permission.MANAGER` |
| **API permission** | `moe.shizuku.manager.permission.API_V23` | `com.gfxgamerlab.shizukuplus.permission.API_V23` |
| **Permission group** | `moe.shizuku.manager.permission-group.API` | `com.gfxgamerlab.shizukuplus.permission-group.API` |
| **Content provider authority** | `moe.shizuku.privileged.api.shizuku` | `com.gfxgamerlab.shizukuplus.shizuku` |
| **Files / FileProvider** | — | `com.gfxgamerlab.shizukuplus.files` / `.fileprovider` |

**No Conflict Guarantee** — scoped permission groups, unique content-provider authorities and independent intent actions mean Android never sees a clash, so `INSTALL_FAILED_DUPLICATE_PERMISSION` and `INSTALL_FAILED_CONFLICTING_PROVIDER` cannot be caused by the official app.

> ℹ️ Only one copy of *Shizuku Plus itself* can be installed at a time. If you have an older build signed with a different key, uninstall it first.

---

## ✨ Key Features

### 🧬 Standalone & Modern
- **100% Standalone Package (`com.gfxgamerlab.shizukuplus`)** — safely installs on devices where the official Shizuku app is already present.
- **Modern Android Support** — targets Android 16 (API 36) while staying backward compatible down to Android 8 (API 26).
- **Non-Root Optimization** — leverages ADB and Shizuku binder mechanisms for high-performance mobile gaming and system tuning.
- **Developer-Ready** — other apps can request access through the standard Shizuku API (see the [Developer Integration Guide](#-developer-integration-guide)).

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

> ✅ Android 8.0+ to install • ✅ Wireless Debugging start needs Android 11+ • ❌ No root required

1. **Download Shizuku Plus** — grab the latest APK (`Shizuku_Plus_<version>.apk`) from the **[Releases page](https://github.com/GfxGamerLab/Shizuku-Plus-master/releases)**.
2. **Install the APK** on your Android device (allow *Install unknown apps* for your browser/file manager if asked). The official Shizuku app is **not required** — and if it is installed, there is no conflict.
3. **Enable Wireless Debugging** — go to **Developer Options → Wireless Debugging**, then pair Shizuku Plus using the pairing code or notification.
4. **Start Shizuku Plus** via Wireless Debugging.
5. **Turn on stability features** — **Settings → Wireless debugging → Advanced** → enable **Auto-Heal Neural Watchdog** and/or **Smart Local TCP Bridge**.
6. **Grant apps access** — open any Shizuku-compatible app and approve its request (or use the **Apps** tab).

> 🎥 Prefer a visual guide? Follow the **[YouTube tutorial](https://youtu.be/Fic_5dvVhLo)**.

[![Download Latest Release](https://img.shields.io/badge/⬇_Download_Latest_Release-d32f2f?style=for-the-badge)](https://github.com/GfxGamerLab/Shizuku-Plus-master/releases)

---

## 📊 Compatibility

| Android version | Install | Start via Wireless Debugging | Notes |
| --- | :---: | :---: | --- |
| **8.0 – 10** (API 26–29) | ✅ | ❌ | Start with a PC using the ADB command shown in-app. |
| **11 – 16** (API 30–36) | ✅ | ✅ | Fully supported. |
| **Rooted devices** | ✅ | — | Root start is optional, never required. |

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

Want your own app to use Shizuku Plus — run privileged commands, call hidden system APIs, or read protected folders **without root**? Shizuku Plus speaks the standard [Shizuku API](https://github.com/RikkaApps/Shizuku-API), so the usual integration works. There is **one extra line** your manifest needs (Step 2).

### How access works

```text
Your app ──(Shizuku API / Binder)──► Shizuku Plus server (shell uid 2000) ──► Android system
        ▲                                    │
        └──── user approves permission ◄─────┘
```

1. The user starts Shizuku Plus (Wireless Debugging / ADB / root).
2. Your app asks for permission → the user approves it once.
3. Your app gets a Binder and can run code at **shell (2000)** privilege.

### Step 1 — Add dependencies

```kotlin
// build.gradle.kts (app)
dependencies {
    implementation("dev.rikka.shizuku:api:13.1.5")
    implementation("dev.rikka.shizuku:provider:13.1.5")
}
```

> `minSdk 23` apps need [core library desugaring](https://developer.android.com/studio/write/java8-support#library-desugaring) since Shizuku API 13.1.0.

### Step 2 — Declare the provider **and the Shizuku Plus permission**

```xml
<!-- AndroidManifest.xml -->

<!-- ✅ Required for Shizuku Plus: it recognises apps by this permission -->
<uses-permission android:name="com.gfxgamerlab.shizukuplus.permission.API_V23" />

<!-- Optional: lets your app also see the Shizuku Plus package on Android 11+ -->
<queries>
    <package android:name="com.gfxgamerlab.shizukuplus" />
</queries>

<application>
    <provider
        android:name="rikka.shizuku.ShizukuProvider"
        android:authorities="${applicationId}.shizuku"
        android:multiprocess="false"
        android:enabled="true"
        android:exported="true"
        android:permission="android.permission.INTERACT_ACROSS_USERS_FULL" />
</application>
```

> 🔑 Shizuku Plus checks the **`com.gfxgamerlab.shizukuplus.permission.API_V23`** permission in your manifest (the official `moe.shizuku.manager.permission.API_V23` is not enough on its own). Declare **both** if you want the same build to work with official Shizuku too.

### Step 3 — Check & request permission

```kotlin
import android.content.pm.PackageManager
import rikka.shizuku.Shizuku

private const val REQUEST_CODE_PERMISSION = 1001

private val permissionListener =
    Shizuku.OnRequestPermissionResultListener { requestCode, grantResult ->
        if (requestCode == REQUEST_CODE_PERMISSION &&
            grantResult == PackageManager.PERMISSION_GRANTED) {
            // ✅ Granted — safe to use Shizuku now
        }
    }

fun checkAndRequestShizukuPermission() {
    if (!Shizuku.pingBinder()) return                       // service not running
    if (Shizuku.isPreV11() || Shizuku.getVersion() < 11) return

    when {
        Shizuku.checkSelfPermission() == PackageManager.PERMISSION_GRANTED -> {
            // Permission already granted
        }
        Shizuku.shouldShowRequestPermissionRationale() -> {
            // User chose "Deny and don't ask again" — explain why it is needed
        }
        else -> Shizuku.requestPermission(REQUEST_CODE_PERMISSION)
    }
}

// Register in onCreate(), remove in onDestroy():
// Shizuku.addRequestPermissionResultListener(permissionListener)
// Shizuku.removeRequestPermissionResultListener(permissionListener)
```

### Step 4 — Run privileged code with a `UserService` (recommended)

A `UserService` runs **your own code in a separate process** at shell (or root) privilege. It is the supported, future-proof way to do privileged work.

**`IMyService.aidl`**

```aidl
package com.example.app;

interface IMyService {
    void destroy() = 16777114;            // required by Shizuku — clean up and exit
    String runCommand(String command) = 1;
}
```

**`MyUserService.kt`**

```kotlin
class MyUserService() : IMyService.Stub() {

    constructor(context: Context) : this()    // Shizuku 13+ tries this one first

    override fun destroy() = exitProcess(0)

    override fun runCommand(command: String): String =
        Runtime.getRuntime().exec(arrayOf("sh", "-c", command))
            .inputStream.bufferedReader().use { it.readText() }
}
```

**Bind it**

```kotlin
private val args = Shizuku.UserServiceArgs(
    ComponentName(BuildConfig.APPLICATION_ID, MyUserService::class.java.name)
)
    .daemon(false)
    .processNameSuffix("service")
    .debuggable(BuildConfig.DEBUG)
    .version(1)                               // bump to restart with new code

private val connection = object : ServiceConnection {
    override fun onServiceConnected(name: ComponentName, binder: IBinder) {
        val service = IMyService.Stub.asInterface(binder)
        println(service.runCommand("id"))     // uid=2000(shell) ...
    }
    override fun onServiceDisconnected(name: ComponentName) {}
}

Shizuku.bindUserService(args, connection)
// later: Shizuku.unbindUserService(args, connection, true)
```

### Legacy — one-off shell commands

The quick `Shizuku.newProcess(...)` approach still appears in many tutorials. It is **kept here for reference**, but the upstream API has marked it for removal — prefer the `UserService` above for new code.

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

### Bonus — Shell-level file access (`IPrivilegedFiles`)

Shizuku Plus's own file explorer is built on a small AIDL service that runs as shell and hands back real file descriptors — the pattern to copy if your app must reach `Android/data`, `Android/obb`, `/proc` or `/system`:

```aidl
interface IPrivilegedFiles {
    ParcelFileDescriptor open(String path, int mode);
    String exec(String command);
    boolean exists(String path);
    boolean mkdir(String path);
    boolean rename(String from, String to);
    boolean delete(String path, boolean recursive);
}
```

See [`IPrivilegedFiles.aidl`](manager/src/main/aidl/com/gfxgamerlab/shizukuplus/files/IPrivilegedFiles.aidl) for the full definition.

### ✅ Best practices

- **Lifecycle awareness** — use `Shizuku.addBinderReceivedListenerSticky()` and `Shizuku.addBinderDeadListener()`; call Shizuku only while the binder is alive.
- **Stay off the main thread** — run commands on `Dispatchers.IO`.
- **OEM compatibility** — wrap custom system commands in `try/catch` for heavily customized ROMs.
- **R8 / ProGuard** — set a fixed `.tag("my-service")` in `UserServiceArgs` so the service identity survives class renaming.
- **Least privilege** — request only what you need and explain to the user why.
- **Multi-process apps** — call `ShizukuProvider.enableMultiProcessSupport()` in every process that uses the API.

### 🧪 Quick self-test

```bash
adb shell pm list packages | grep shizukuplus    # package present
adb shell dumpsys package com.gfxgamerlab.shizukuplus | grep permission
```

---

## 🏗️ Build From Source

```bash
git clone --recurse-submodules https://github.com/GfxGamerLab/Shizuku-Plus-master.git
cd Shizuku-Plus-master
./gradlew :manager:assembleRelease      # APK → out/apk/
```

- Requires **JDK 21**, Android SDK **36** / Build-Tools **37.0.0** and NDK **29.0.14206865**.
- The `api/` folder is a **git submodule** — if it is empty run `git submodule update --init --recursive`.
- Without a `signing.properties` file the build is signed with the **debug key**. For a release, create `signing.properties` (`KEYSTORE_FILE`, `KEYSTORE_PASSWORD`, `KEYSTORE_ALIAS`, `KEYSTORE_ALIAS_PASSWORD`) and keep using the **same key** for every update.
- Run the API-level lint gate with `./gradlew :manager:lintDebug`.

---

## 🩺 Troubleshooting

| Symptom | Cause | Fix |
| --- | --- | --- |
| **App not installed** / `INSTALL_FAILED_DUPLICATE_PERMISSION` / `CONFLICTING_PROVIDER` | An older build using the stock `moe.shizuku.*` names, or another fork, is installed | Uninstall the old/duplicate build, then install the latest release. |
| **Update fails ("signatures do not match")** | New APK signed with a different key | Uninstall the old copy once, or always sign with the same key. |
| **Install blocked on Android 12+** | *Install unknown apps* is off | Settings → Apps → your browser/file manager → allow installs. |
| **Service stops after Wi-Fi change/reboot** | Wireless Debugging was turned off by Android | Enable the **Auto-Heal Watchdog** and **Smart TCP Bridge**, then re-enable Wireless Debugging. |
| **My app never gets a Binder** | Missing `com.gfxgamerlab.shizukuplus.permission.API_V23` or provider in your manifest | Follow [Step 2](#step-2--declare-the-provider-and-the-shizuku-plus-permission). |
| **`IllegalStateException: binder haven't been received`** | Shizuku API called before the service is running | Check `Shizuku.pingBinder()` / use the binder-received listener. |
| **Cannot see `Android/data`** | Service not started | Start Shizuku Plus, then open the Data Explorer. |

Still stuck? Run `adb install -r <apk>` and [open an issue](https://github.com/GfxGamerLab/Shizuku-Plus-master/issues) with the exact `INSTALL_FAILED_...` line.

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
<summary><b>Can I install it together with official Shizuku?</b></summary>
Yes. Shizuku Plus uses its own package name, permissions and provider authorities (<code>com.gfxgamerlab.shizukuplus.*</code>), so it installs next to the official app without <code>INSTALL_FAILED_DUPLICATE_PERMISSION</code> or <code>CONFLICTING_PROVIDER</code>. Run only one of them as the active service at a time.
</details>

<details>
<summary><b>Can my own app use Shizuku Plus?</b></summary>
Yes — use the standard Shizuku API and add the <code>com.gfxgamerlab.shizukuplus.permission.API_V23</code> permission to your manifest. See the <a href="#-developer-integration-guide">Developer Integration Guide</a>.
</details>

<details>
<summary><b>Which Android versions are supported?</b></summary>
Install on Android 8.0+ (API 26) up to Android 16 (API 36). Starting through Wireless Debugging needs Android 11+; older versions start with a PC via ADB.
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
- Package identity: `com.gfxgamerlab.shizukuplus` — independent of the official Shizuku package.
- **Disclaimer:** This is an independent community fork and is not affiliated with or endorsed by RikkaApps. Use performance tweaks at your own risk.

---

## 🔎 Keywords

`shizuku` `shizuku-plus` `shizuku-fork` `android-gaming` `game-booster` `fps-booster` `lag-reducer` `rootless` `no-root` `adb` `wireless-debugging` `android-data-access` `android-obb` `data-explorer` `gaming-optimizer` `android-tweaks` `performance-tweaks` `bgmi` `free-fire` `pubg` `gfx-tool` `kotlin` `jetpack-compose` `material-design` `shizuku-api` `shizuku-userservice` `shizuku-developer` `android-adb` `shell-access` `privileged-api` `no-install-conflict` `standalone-shizuku` `rish` `android-16` `game-tuner` `rootless-android-tools`

---

<div align="center">

### ⭐ If Shizuku Plus helped you, please star the repo and share it with fellow gamers!

**Made with ❤️ by [GFX Gamer Lab](https://t.me/gfxgamerlab)**

</div>
