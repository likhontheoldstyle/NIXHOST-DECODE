# NixHost clean reconstruction — rename map

Clean rewrite of the jadx-decompiled `com.nix.host` v0.0.2 sources with meaningful
names restored. Behaviour, string literals, endpoints, ports, preference keys and
logic order are unchanged; only names and formatting differ from the decompiled
output. Classes that were already meaningfully named kept their names.

## App classes (package `com.nix.host`, names unchanged)

| Class | What it does |
|---|---|
| `MainActivity` | The whole UI: login, home/instance list, terminal screen, file browser, file viewer, code editor, group chat host, update and locked screens — all built in code, switched by a `screen` state string. |
| `HostService` | Foreground service running the local web server (raw `ServerSocket`) that serves the user's project folder on the configured port, with wake/wifi locks and a persistent notification. |
| `BootReceiver` | Restarts `HostService` after boot or app update when a user is logged in. |
| `NotifyReceiver` | Handles chat notification actions (Reply via RemoteInput, 👍 Like) in the background. |
| `VideoProvider` | ContentProvider that exposes cached chat videos (`cache/chat/v_*`) to player apps. |
| `R` | Generated resource ids, copied as-is. |

### MainActivity member renames

Fields: `A→termInput`, `B→termInputRow`, `C→termBusyRow`, `D→termPrompt`,
`E→termPathLabel`, `F→termClockLabel`, `G→termKeysPanel`, `H→termScrim`,
`I→termBusy`, `J→uiTicker`, `K→uiScale`, `L→notifDialog`, `M→fontLazy`,
`N→rootView`, `O→online`, `P→wifiLostAt`, `Q→uploadTargetDir`,
`f781a→matchParent`, `f782b→wrapContent`, `f783c→mainHandler`, `f784d→screen`,
`f785e→username`, `f786f→lastRefreshAt`, `f787g→statusBarHeight`,
`f788h→bottomInset`, `f789i→expiryWarned`, `f790j→stoppedAt`,
`f791k→emojiToggle`, `f792l→storageGranted`, `f793m→chatScreen`,
`f794n→currentDir`, `f795o→homeDir`, `f796r→outputCursor`, `f797s→termOutput`,
`f798t→popupMenu`, `f799u→popupScrim`, `f800v→editorSession`, `p→termKey`,
`q→termTitle`, `w→termColor`, `x→termBold`, `y→termNeedsNewline`, `z→termScroll`.

Methods: `A→focusAndShowKeyboard` (static), `B→openWhatsApp`,
`C→flushTerminalOutput`, `D→setAction` (static), `E→showInputDialog`,
`F→refreshTerminalChrome`, `G→appendStyled` (static), `H→setRootContent`,
`I→roundedBg`, `J→shouldKeepScreenOn`, `K→showEditor`, `L→showFiles`,
`M→showChat`, `N→showHome`, `O→showLocked`, `P→showLogin`, `Q→makeInput`
(static), `R→showUpdate`, `S→showFileView`, `T→toast`, `U→makeText`,
`V→column`, `W→whatsAppButton`, `X→isWifiConnected`, `a→showPopupMenu`,
`b→animateEmojiPanelClose` (static), `c→addSheetItem` (static), `d→ansiColor`
(static), `e→applyBarColors`, `f→buttonRow`, `g→showDialog` (static),
`h→clearScreenRefs`, `i→hidePopupMenu`, `j→hideTermKeys`, `k→showCommitSheet`,
`l→makeEditorField` (static), `m→makeButton`, `n→dp`,
`o→onAccountStateChanged`, `p→resetAnimationScale` (static), `q→monoFont`,
`r→row`, `s→hideKeyboard`, `t→makeIcon`, `u→logout`, `v→layoutParams` (static),
`w→maybeShowExpiryWarning`, `x→isOnline`, `y→openTerminal`, `z→addKeyButton`
(static).

### HostService member renames

`f775f→server`, `f776a→wakeLock`, `f777b→wifiLock`, `f778c→currentPort`,
`f779d→mainHandler`, `f780e→tick`, `a→postNotification`, `b→acquireWifiLock`,
`c→stopServer`.

## Helper classes (package `a`)

| Old | New | What it does |
|---|---|---|
| `AbstractC0008c` | `AppState` | Global app state (session/profile JSON, preferences, theme) plus account helpers; also hosts kotlin-stdlib helpers merged into it by R8 (those kept their letter names: `a`=closeFinally, `b`=coerceFloat, `c`=coerceInt, `d`=compare, `e`=copyTo, `h`=charEqualsIgnoreCase, `p`=singletonList, `r`=collection capacity, `u`=readBytes, `v`=readText, `A`=file-root split, `B`=range, `f/g/j/k/n/o/w/x`=zip/varint helpers, `y`=setOf). App members: `f438a→meJson`, `f439b→appVersion`, `f440c→prefs`, `f441d→chatForeground`, `f442e→darkTheme`, `i→accountFor`, `l→subTextColor`, `m→mainTextColor`, `q→isLockedOrExpired`, `s→isUpdateAvailable`, `t→putPref`, `z→refreshAccount`. |
| `C0004b` | `ApiClient` | HTTP client for the backend Worker (`f409a→INSTANCE`, `f410b→baseUrl`; `a→request`, `b→requestWithDefaults`, `c→markSeen`, `d→sendChatMessage`, `e→downloadChatSound`, `f→syncChat`, `g→downloadBytes`, `h→loadBaseUrl`). |
| `C0000a` | `ApiResponse` | HTTP result wrapper (`f400a→code`, `f401b→body`; `a→errorMessage`, `b→isSuccess`, `c→json`). Its stray int constructor was an R8-merged zip artefact and was dropped. |
| `B2` | `Workspace` | Home-folder resolution (internal vs external `NixHost/<user>`), storage-access check, the built-in `gclone` GitHub downloader and unzip (`a→gclone`, `b→homeDir`, `c→hasStorageAccess`, `d→unzip`; `f46a→namePattern`, `f47b→pathPattern`, `f48c→folderPattern`). |
| `G2` | `HttpServer` | Static-file HTTP server state and response writer (`f111a→rootDir`, `f112b→serverSocket`, `f113c→executor`, `f114d→running`, `f115e→mimeTypes`; `a→sendResponse`). |
| `L2` | `TerminalManager` | Registry of terminal sessions and service keep-alive sync (`f198a→INSTANCE`, `f199b→sessions`, `f200c→appContext`, `f201d→keepAlive`; `a→anyBusy`, `b→hasBusySession`, `c→syncServiceState`, `d→getOrCreateSession`, `e→closeAllSessions`, `f→logFileFor`). |
| `K2` | `TerminalSession` | One sandboxed shell session: process, output buffer with ANSI cleanup, built-in commands (cd/ls/pkg/gclone/setup/diag/help/kill/clear), package installs. Fields `f167a→homeDir`, `f168b→envHomeDir`, `f169c→logFile`, `f170d→output`, `f171e→outputFlushed`, `f172f→currentDir`, `f173g→pendingCommand`, `f174h→restartCount`, `f175i→busy`, `f176j→prompt`, `f177k→process`, `f178l→shellPid`, `f179m→installing`, `f180n→installCancelled`, `f181o→generation`, `p→cloning`, `q→killed`, `f182r→npmInstallPattern`, `f183s→ansiEscapePattern`, `f184t→controlCharsPattern`, `f185u→trailingEscapePattern`. Methods `a→echo`, `b→progressBar`, `c→cleanOutput`, `d→cwdFile`, `e→runShellCommand`, `f→finishRun`, `g→installPackages`, `h→interrupt`, `i→killProcessTree`, `j→collectProcessTree`, `k→persistOutput`, `l→cwdLabel`, `m→resolvePath`, `n→start`, `o→runFile`, `p→launchCommand`, `q→setCurrentDir`, `r→runCommand`, `s→tryFile`, `t→deleteLogFiles`. |
| `C0006b1` | `ChatScreen` | The whole group-chat screen: message list, composer, voice recording/playback, media picker, reactions, group info/settings, sync and outbox. Key fields: `f414a→activity`, `f415b→username`, `f416c→toaster`, `f417d→onSessionExpired`, `f418e→handler`, `f419f→lightBars`, `f422i→bgColor`, `A→shell`, `B→headerBar`, `y→topInset`, `z→activityRef`, `G→active`, `C1→groupId`, `D→messages`, `E→reactions`, `F→members`, `J0→seenIds`, `t0→displayNames`, `l0→memberPics`, `m0→lastSeen`, `u0→groupName`, `v0→groupPic`, `w0→groupPicView`, `I→hasMore`, `L→cacheLoaded`, `L0→localIdBase`, `M0→localIdCounter`, `N0→outboxLoaded`, `O0→outbox`, `g0→emojiPanel`, `U0→recordState`, `T0→cameraUri`, `S0→galleryPending`, `e1→micPermPending`, `z1→avatarPickPending`, `h0→messageInput`, `W→messageList`, `V→stickToBottom`, `U→replyTargetId`, `T→replyTarget`, `m1→previewMessageId`, `j1→playButtons`, `j0→messageAdapter`, `H0→lastSyncAt`, `I0→syncing`, `D1→lastQuickReactionAt`, `y1→quickReactionRefresher`, `F0→pollRunnable`, `P0→sendExecutor`, `o1→prefetchExecutor`, `B1→nameChangeCooldownMs`. Key methods: `k0→messageFromJson`, `t→destroy`, `j→buildChatView`, `n→buildPanel`, `w0→refreshMessages`, `x0→applyScroll`, `y0→startSync`, `h1→updateSendButton`, `B0→saveCache`, `g1→unregisterNetworkCallback`, `X0→stopPlayback`, `q→cancelRecording`, `F0→sendMedia`, `G0→sendVideo`, `I0→setAvatarFromUri`, `W0→startRecording`, `f0→showMediaPicker`, `d1→queueRetry`, `z0→markFailed`, `b→addMessages`, `E→errorText`, `L→isDarkBg`, `K0→setConnectionState`, `U→refreshMembers`, `e0→isOffline`, `d0→saveNameChangedAt`, `Z→savedNameChangedAt`, `i1→refreshHeader`, `m0→sendTextMessage`, `h0→showTransientText`, `U0→mediaLayoutParams`, `f1→makeText`, `k1→columnLayout`, `P→rowLayout`, `c1→addAlignedText`, `n0→setClickAction`, `T0→showDialogThemed`, `N0→roundedDrawable`, `o0→nameText`, `c→scrollToReplyTarget`, `e1→toggleVoicePlayback`, `A0→waveformPeaks`, `G→formatDuration`, `w→formatDaysLeft`, `M0→settingsRow`, `O0→menuRow`. |
| `C0018e1` | `ChatNotifier` | Background chat polling (every 12 s) and message notifications with Reply/Like actions (`f459a→INSTANCE`, `f460b→polling`, `f461c→pollThread`, `f462d→pendingLines`, `f463e→displayNames`, `f464f→memberPics`, `f465g→avatarBitmaps`, `f466h→membersFetchedAt`, `f467i→soundPlayer`, `f468j→mainHandler`; `a→avatarFor`, `b→clearChatNotifications`, `c→refreshMembers`, `d→makeInitialAvatar`, `e→pollOnce`, `f→showNotification`, `g→showOwnMessageNotification`, `h→startPolling`, `i→stopPolling`, `j→stopSound`). |
| `K0` | `ChatMessage` | Chat message model (`f150a→id`, `f151b→sender`, `f152c→type`, `f153d→text`, `f154e→media`, `f155f→wave`, `f156g→duration`, `f157h→replyTo`, `f158i→timestamp`, `f159j→flag`, `f160k→u`, `f161l→t`, `f162m→x`, `f163n→deleted`, `f164o→status`, `p→reactions`). |
| `M0` | `OutboxEntry` | Queued outgoing message (`f207a→id`, `f208b→body`, `f209c→timestamp`, `f210d→u`, `f211e→t`, `f212f→x`, `f213g→deleted`). |
| `z2` | `ChatMedia` | Chat media cache: download, decode and LRU-caching of images, videos and avatars (`f758a→cacheDir`, `f759b→bitmapCache`, `f760c→executor`, `f761d→mainHandler`, `f762e→avatarCache`, `f763f→aspectRatios`; `a→decodeSampled`, `b→fetchMediaFile`, `c→mediaFile`, `d→cacheDir`, `e→loadInto`, `f→loadAvatar`, `g→videoFile`). |
| `A2` | `AvatarView` | Circular-clipped avatar image view (`f15a→bmp`, `f16b→paint`, `f17c→clipPath`). |
| `A1` | `BitmapLruCache` | LRU bitmap cache keyed by string (`f14a→mode`). |
| `s2` | `DragSheetLayout` | Bottom-sheet container with drag-to-dismiss physics (`f654a→startY`, `f655b→dragging`, `f656c→velocityTracker`, `f657d→threshold`, `f658e→onDragRef`, `f659f→onReleaseRef`). |
| `C0038j1` | `CodeEditorView` | Code editor view with line-number gutter and syntax repaint scheduling (`f549a→textScalePx`, `f550b→fileName`, `f551c→gutterPaint`, `f552d→gutterBgPaint`, `f553e→lineStarts`, `f554f→lineCount`, `f555g→gutterDigits`, `f556h→gutterWidth`, `f557i→handler`, `f558j→changeCounter`, `f559k→repaintTask`; `a→recomputeLineStarts`). |
| `C0067q2` | `CodeLinesAdapter` | List adapter rendering highlighted code lines with a gutter (`f630a→lines`, `f631b→gutterWidth`, `f632c→activity`). |
| `D1` | `SyntaxHighlighter` | Regex-based syntax highlighting for code/JSON/HTML/CSS/Python/shell (`f67a→jsKeywords`, `f68b→pyKeywords`, `f69c→literals`; `a→highlight`, `b→paintSpan`). |
| `G1` | `IconView` | Canvas-drawn vector icon view (~28 icons: logo, folder, chat, lock, sun/moon, eye, trash, etc.) (`f107a→name`, `f108b→tint`, `f109c→strokeWidth`, `f110d→paint`; `a→drawClosed`, `b→drawOpen`, `set→setIcon`). |
| `F1` | `TickRunnable` | Periodic ticker: HostService notification watchdog (mode 0) and MainActivity UI ticker (mode 1) (`f96a→mode`, `f97b→owner`). |
| `G` | `TaskRunnable` | Mode-dispatched background/UI runnable (quick chat post, notifier poll loop, editor repaint, watchdog, scroll, package sync, …) (fields `mode`, `target`). |
| `U` | `HttpConnectionHandler` | Mode-dispatched runnable: chat theme/avatar/delete/sound operations and the local server's per-connection static-file handler (fields `mode`, `owner`, `target`; private `a→handleStaticFileRequest`). |
| `O` | `ActionRunnable` | Mode-dispatched runnable: chat-send result handling (mode 0) and NotifyReceiver's background worker (mode 1) (`f229a→mode`, `f230b→messageId`, remaining fields positional `first…fifth`). |
| `t2` | `FileFilters` | Filename filter used by terminal/package helpers (`f665a→mode`). |

### Synthetic dispatcher / callback classes (package `a`)

These are the `h.a`/`h.b`/`h.c` (kotlin Function0/1/2) implementations the UI is
wired with. All were renamed; their fields are `mode` plus positional
`first/second/third/fourth/fifth` captures.

| Old | New | Role |
|---|---|---|
| `K1` | `ActivityAction` | MainActivity actions: show files/home/chat, settings intents, logout flow, font loading, account-refresh thread, close terminal. |
| `Q1` | `SubmitAction` | Emoji-sheet close animation (mode 0) and the login submit flow (mode 1). |
| `X1` | `LinkAction` | Open WhatsApp / open URL / delete-instance thread starter. |
| `M1` | `UiTask` | MainActivity UI-thread tasks: account refresh results, terminal scroll-to-bottom, notification/battery prompts, logout. |
| `O1` | `ApiTask` | Background API tasks: create/delete instance, account refresh. |
| `C0090y0` | `PairAction` | Paired-value actions: chat input set-text, battery-optimisation prompt, cancel mode banner, copy terminal output, fill `cd`, hide terminal keys. |
| `C0057o0` | `DelegateAction` | Forwards invocation to another `h.a`. |
| `S1` | `CommitAction` | Editor commit bar (open commit sheet) and the actual file write. |
| `T1` | `DismissAndRun` | Dismisses a dialog, then runs an action. |
| `C0060p` | `DismissAction` | Dismisses its dialog only. |
| `C0027g2` | `PanelToggleAction` | Toggles the popup menu / terminal keys panel with animation. |
| `C0015d2` | `CreateRenameAction` | Create file/folder and rename flows from the file browser. |
| `C0028h` | `TextInputAction` | Dialog text submits: create instance, quick-reaction save, image-editor internals. |
| `G0` | `ValueAction` | File-view popup actions; chat image aspect layout; emoji-sheet drag handling. |
| `L1` | `DialogContent` | Builds the input-dialog content; emoji-sheet release behaviour. |
| `N1` | `ConfirmDialogContent` | Builds confirm dialogs (title/message/confirm button). |
| `C0055n2` | `PromptDialogContent` | Notification-permission and battery-optimisation prompt dialogs. |
| `D` | `MultiAction` | Multi-purpose action: video play/mute toggles, chat theme preview, message info, profile sheet builder, terminal Tab completion. |
| `R0` | `SharedTextWatcher` | Text watcher: chat typing state, editor change tracking, terminal draft saving. |
| `R1` | `FileConfirmAction` | Confirmed file operations: delete, discard edits, recursive delete, unzip. |
| `C0071s` | `ActionCallback` | Editor close/discard check, file-row tap handling, dialog submits, chat internals. |
| `RunnableC0056o` | `BackgroundTask` | Mode-dispatched background work: chat sync/media prefetch, unzip, zip upload copy, delete-instance cleanup, sheet animation, avatar fetch, shell-command runner. |
| `P` | `IdPredicate` | Predicate matching a chat message by id. |
| `C0031h2` | `NoopFunction2` | No-op / empty-sequence function used by sheet callbacks. |
| `C0001a0` | `ToastCallback` | Toast callback (chat toaster), terminal prompt callback, image-editor callback. |
| `ViewOnClickListenerC0016e` | `TripleClickListener` | Click listener: chat actions, dialog confirm, password visibility eye toggle. |
| `ViewOnClickListenerC0019e2` | `ActivityClickListener` | Theme toggle, hide popup menu, hide terminal keys. |
| `ViewOnClickListenerC0044l` | `ActionClickListener` | Click listener that invokes its `h.a` (used by `MainActivity.setAction`). |
| `ViewOnTouchListenerC0039j2` | `PressMediaTouchListener` | Press feedback (alpha) for media views. |
| `Y1` | `FocusBorderListener` | Input focus border colouring for dialogs and the login form. |
| `I0` | `RefAction` | Action stored through a reference holder (profile sheet, dismiss, install-cancelled check). |
| `I` | `ViewAnimTask` | Slide-in animation / hide-view runnables. |
| `E` | `LayoutTask` | Layout-change listener: chat keyboard handling, terminal scroll. |
| `C0011c2` | `ActivityRef` | Mutable holder for the MainActivity reference (`f446a→activity`). |
| `C0035i2` | `EmojiPanelToggle` | Emoji-panel open/close action for the terminal screen. |

## Referenced but not rewritten

These classes are used by the rewritten code but were left under their original
names — either library/kotlin-stdlib code merged by R8, or app helper classes
outside the dependency core (chat image editor, theme catalog, assorted
single-purpose runnables). References to them are unchanged.

- Default package: `J0` (string-concat shim, `J0.a(...)`), `N0` (comparator used
  for files, chat messages and Tab completion), `C0` (lazy value provider).
- Package `a`: `B1` (image editor screen), `C0091y1`, `O2` (image-editor
  helpers), `C0022f1` (chat theme palette), `E2` (dialog helper), `I2` (chat
  message list view), `N2`, `L0`, `C1` (video player holder), `C0029h0`
  (quick-reaction refresher), `O0` (chat message adapter), `X0` (chat poll
  runnable), `H`, `V`, `W`, `Y`, `T0`, `Z0`, `Q0`, `Y0`, `P0` (chat-internal
  runnables), `J1` (animator listener), `J2`, `C0085w1` (file sort keys),
  `C0036j`, `C0017e0`, `C0042k1`, `C0046l1`, `AbstractC0026g1` (theme catalog),
  `C0002a1` (network callback), `C0005b0`, `C0010c1`, `C0014d1`, `C0048m`,
  `C2` (executor holder), `S` (chat UI result runnable), `y2` (terminal helper
  singleton), `RunnableC0037j0` (media loader), `RunnableC0040k`,
  `RunnableC0049m0`, `RunnableC0064q`, `RunnableC0068r0`, `RunnableC0093z0`,
  `ViewOnClickListenerC0058o1`, `ViewOnClickListenerC0072s0`,
  `ViewOnClickListenerC0074t`, `ViewOnClickListenerC0077u`,
  `ViewOnLongClickListenerC0065q0`.
- Library packages kept as-is: `b.*` (kotlin Pair/Lazy/Unit), `c.*` (kotlin
  collections), `g.*` (kotlin.io), `h.*` (kotlin Function0/1/2), `i.*` (kotlin
  intrinsics and Ref types), `k.*` (kotlin ranges), `l.*`, `m.*` (kotlin text/io),
  `n.*` (zip), plus `kotlin.*`, `androidx.*`, `android.*`, `java.*`, `org.*`.

## Reconstruction notes

- `MainActivity.M` (showChat), `N` (showHome), `o` (onAccountStateChanged) and
  `onBackPressed` were recovered by jadx with `--show-bad-code`; they are
  reconstructed as single coherent passes (jadx duplicated some regions).
- A few dispatcher classes (`SubmitAction`, `CommitAction`) show a constant mode
  field for both constructors in the decompile; the mode is assigned per
  constructor here, matching how each instance is used.
- The tree mirrors the decompiled layout, including default-package helper
  classes; like the jadx output itself, it is a faithful source reconstruction
  rather than a guaranteed-compiling project (R8 artefacts such as
  default-package references and merged kotlin-stdlib members remain).
