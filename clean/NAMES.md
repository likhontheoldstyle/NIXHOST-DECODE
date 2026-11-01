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

## Pass 2 — remaining app classes (rewritten)

The classes the first pass left under their original names have now all been
reconstructed as well, and every reference to them in the pass-1 files has been
updated to the new names. The clean tree now totals 147 Java files
(26,602 lines). All are in package `a` (the first pass wrongly listed `J0`,
`N0` and `C0` as default-package classes — their files declare `package a;`).

### Chat views, adapters and view helpers

| Old | New | What it does |
|---|---|---|
| `I2` | `ChatListView` | Chat message `ListView` with a pluggable touch hook (swipe-to-reply) (`f133a→hook`; `a→superDispatchTouchEvent`). |
| `O0` | `ChatAndMediaAdapter` | Dual-mode `BaseAdapter`: mode 0 renders the chat message list, mode 1 renders the media-picker grid (`f236a→mode`, `f237b→owner`). |
| `Q0` | `EmojiPanelAdapter` | Composer emoji-panel adapter (section headers + rows of 7 emoji) (`f274a→items`, `f275b→chatScreen`, `f276c→onEmojiSelected`). |
| `Y0` | `EmojiPickerAdapter` | Full-screen reaction emoji-picker adapter with a "Recent" section and a big-like sentinel row (`f379a→items`, `f380b→likeSentinel`, `f381c→chatScreen`, `f382d→dialog`, `f383e→onEmojiSelected`). |
| `C1` | `ChatIconView` | Canvas icon view for the chat/editor icon set (~35 icons, self-animating `load` spinner) (`f52a→name`, `f53b→color`, `f54c→cutColor`, `f55d→loadAngle`, `f56e→paint`; `a→drawPerson`, `b→drawRoundRect`, `set→setIcon`). Not to be confused with `IconView` (`G1`), `EditorIconView` (`C0046l1`), or `ChatScreen`'s unrelated field `groupId` (decoded name `C1`). |
| `P0` | `ChatScrollListener` | Chat list scroll listener: stick-to-bottom tracking and load-older triggering (`f248a→chatScreen`). |
| `N2` | `ThemedBackgroundView` | Chat background view: renders the theme artwork via `ThemeBackgroundPainter` into a cached bitmap and centre-crop-draws it (`f226a→fallbackColor`, `f227b→paint`, `f228c→themeBitmap`). |
| `C0042k1` | `SwipeDownSheetLayout` | Drag-down-to-dismiss container for `ChatScreen` bottom sheets (vertical `LinearLayout`) (`f569a→onDismiss`, `f570b→touchSlop`, `f571c→startY`, `f572d→dragging`, `f573e→velocityTracker`; `a→canScrollUp`). |
| `C0046l1` | `EditorIconView` | Small Canvas icon view for the editor/picker icon set (8 icons) (`f580a→name`, `f581b→color`, `f582c→cutColor`, `f583d→paint`; `a→drawRoundRect`, `b→drawTriangle`). |
| `P2` | `WaveformView` | Voice-message waveform view (recording live view + per-message playback bars) (`f256a→barWidth`, `f257b→barGap`, `f258c→values`, `f259d→progress`, `f260e→fgColor`, `f261f→live`, `f262g→cursor`, `f263h→paint`). |
| `R2` | `ZoomableImageView` | Pinch/pan/double-tap zoomable image viewer (scale clamped 0.5–6.0) (`f291a→matrix`, `f292b→drawableRect`, `f293c→scale`, `f294d→minScale`, `f295e→maxScale`, `f296f→lastX`, `f297g→lastY`, `f298h→scaleDetector`, `f299i→gestureDetector`; `a→applyScale`, `b→clampBounds`, `c→fitToView`). |
| `F2` | `LoadingSpinnerView` | Self-animating loading spinner overlaid on chat media thumbnails (`f98a→bgPaint`, `f99b→arcPaint`, `f100c→startAngle`). |
| `D2` | `DraggableListSheetLayout` | Drag-to-dismiss `FrameLayout` wrapper for a bottom sheet whose content is a `ListView` (emoji/reaction sheet) (`f70a→listView`, `f71b→onDismiss`, `f72c→touchSlop`, `f73d→startY`, `f74e→dragging`, `f75f→velocityTracker`). |
| `C0082v1` | `MediaGridItemView` | One square media-picker grid cell: thumbnail, duration label, numbered selection badge (`f682a→imageView`, `f683b→selectionBorder`, `f684c→durationLabel`, `f685d→selectionBadge`, `f686e→item`, `f687f→uriString`, `f688g→owner`). |
| `T0` | `RoundedOutlineProvider` | Mode-dispatched outline provider: per-corner radii (mode 0) or uniform 14dp rounding (mode 1) (`f318a→mode`, `f319b→target`). |
| `Z0` | `TopRoundedOutlineProvider` | Bottom-sheet outline provider rounding only the top corners (`f392a→mode`, `f393b→radius`; both mode branches decompile identically — preserved). |
| `E2` | `SlideDownDialog` | Bottom-sheet `Dialog` that slides its sheet down off-screen on dismiss (`f84a→sheetView`, `f85b→dismissing`; `a→dismissImmediately`). |
| `J2` | `SwipeReplyTag` | Row-tag holder for swipe-to-reply (`f142a→rowView`, `f143b→replyIconView`, `f144c→ownMessage`). |
| `L0` | `PendingReaction` | Optimistic-reaction bookkeeping for one message (`f188a→emoji`, `f189b→sentAtMs`, `f190c→acknowledged`). |
| `H2` | `BrushStroke` | One freehand stroke in the image editor (`f122a→path`, `f123b→color`, `f124c→strokeWidth`). |
| `C0094z1` | `MediaItem` | One device-media entry from the MediaStore queries (`f752a→uri`, `f753b→isVideo`, `f754c→durationMs`, `f755d→bucketName`, `f756e→dateAdded`, `f757f→filePath`). |
| `U0` | `MemberComparator` | Sorts group members so names containing the group id sort first (`f326a→chatScreen`). |
| `N0` | `SortComparator` | Mode-dispatched comparator: chat messages (modes 0/1), media items (mode 2), files (modes 3/4) (`f219a→mode`; compare bodies reconstructed — see notes). |
| `C2` | `SentSoundPlayer` | Static holder for the chat "message sent" sound: handler, executor and the lazily synthesised PCM chirp cache (`f57a→mainHandler`, `f58b→executor`, `f59c→sentSoundSamples`). |

### Chat tasks, runnables and function classes

All are synthetic mode dispatchers unless noted; the first field is `mode`
(per-constructor where jadx showed one constant for several constructors).

| Old | New | What it does |
|---|---|---|
| `X0` | `ChatTimerRunnable` | ChatScreen's three Handler tickers: playback progress (80 ms), sync poll (2.5 s), recording waveform sampler (70 ms) (`f372b→chatScreen`). |
| `H` | `ReactionDialogClickListener` | Reaction-confirm dialog buttons: clear reaction / open emoji picker (`f117b→dialog`, `f118c→chatScreen`, `f119d→message`). |
| `V` | `MessageDialogClickListener` | Reaction-emoji choice click (mode 0) and edit-message Save click (mode 1) (`f333b→dialog`, `f334c→chatScreen`, `f335d→message`, `f336e→value`, `f337f→extra`). |
| `W` | `MessageMenuAction` | Message long-press menu actions: copy, edit, reply, delete-for-me, delete-for-everyone (`f349b→dialog`, `f350c→chatScreen`, `f351d→message`). |
| `Y` | `DeleteOrRenameDialogContent` | Dialog content (Function2): delete-options sheet (mode 0), "Change name" sheet (mode 1) (`f377b→chatScreen`, `f378c→target`). |
| `K` | `QuadTaskRunnable` | R8-merged runnable: react POST + result, save chat photo/video, sync-result application, editor thumbnail load/delivery, chat image delivery, terminal `.deb` install (captures kept positional: `first/second/third/fourth`; private `a→loadEditorThumbnail`). |
| `L` | `SheetSlideRunnable` | Slides a drag-sheet in (mode 0) / its slide-out end-action invoking the dismiss callback (mode 1) (`f187b→sheet`). |
| `S` | `ChatResultRunnable` | UI-thread result handlers for chat admin/avatar/load-older API calls (`f301b→response`, `f302c→chatScreen`). |
| `T` | `MediaOpenRunnable` | Delivers a downloaded chat video to the fullscreen player (mode 0); decodes/opens a photo in the image editor (modes 1/2) (captures kept positional). |
| `C0036j` | `ChatScreenAction` | ChatScreen's main Function0 dispatcher (22 modes: group clear/info, emoji panel, camera, voice, send, members, themes, profile, back) (`f542b→chatScreen`). |
| `C0017e0` | `MediaPickerContent` | Media-picker result callback (mode 0) and "Change profile photo" sheet content (mode 1) (`f458b→chatScreen`). |
| `C0005b0` | `MessageAction` | Per-message Function0 dispatcher: hide/delete, edit history, voice play, reaction picker, fullscreen video player (`f412b→chatScreen`, `f413c→message`). |
| `C0029h0` | `QuickReactionRefresher` | Rebuilds/refreshes the quick-reaction bar in the group-info panel (`f519b→chatScreen`, `f520c→panel`). |
| `A0` | `ReactionAction` | Opens the "Reactions" viewers sheet (mode 0); applies a quick reaction (modes 1–3) (`f11b→chatScreen`, `f12c→reactions`, `f13d→message`). |
| `B0` | `ImageAspectCallback` | Bitmap callback resizing a media container to the bitmap's aspect ratio (`f24b→chatScreen`, `f25c→container`). |
| `C0024g` | `ReactionCallback` | Applies the picked emoji as a reaction (modes 0/1 identical in the decompile — preserved) (`f500b→chatScreen`, `f501c→message`). |
| `C0085w1` | `ValueFunction` | R8-merged stateless Function1 instances: file sort keys/filters, byte-hex formatting, entry formatting, no-ops (mode only, no captures). |
| `C0086x` | `ChatGestureFunction` | Swipe-to-reply touch handler (mode 0); member-pair predicate, emoji insert, quick-reaction send (modes 1–3) (`f704b→chatScreen`). |
| `u2` | `DownloadProgressCallback` | Terminal package-download progress callback, capped at 60% of the bar for its phase (`f673a→packageSize`, `f674b→progressState`, `f675c→progressBase`, `f676d→percentState`, `f677e→onProgress`). |
| `C0002a1` | `ChatNetworkCallback` | Connectivity callback for ChatScreen (non-synthetic) (`f404a→chatScreen`). |
| `C0010c1` | `SoundCompletionListener` | Releases the ChatNotifier sound player on completion (stateless). |
| `C0014d1` | `SoundErrorListener` | Same cleanup on playback error; always consumes the error (stateless). |
| `RunnableC0037j0` | `MultiWorkRunnable` | Message-edit POST + failure restore (modes 0/1), chat image decode/prefetch (mode 2), terminal `gclone` download (mode 3) (`f544b→first`, `f545c→text`, `f546d→sizeOrCount`, `f547e→owner`, `f548f→extra`). |
| `RunnableC0040k` | `ChatSendRunnable` | The chat send pipeline: send-result handling, image-batch preparation, video preparation, text send (`f561b→chatScreen`, `f562c→localId`, `f563d→message`, `f564e→first`, `f565f→second`). |
| `RunnableC0048m` | `ChatScreenRunnable` | ChatScreen's central runnable (15 modes): scroll/keyboard/panel helpers, network state, bg clear/avatar/members/outbox calls (`f588b→chatScreen`). |
| `RunnableC0049m0` | `ChatSyncRunnable` | Background chat sync fetches: history paging and the main poll, with presence/seen/ping side-calls (`f590b→cursorId`, `f591c→chatScreen`). |
| `RunnableC0064q` | `HideTextRunnable` | Delayed hide for the transient status text in the photo/video viewer (both modes identical) (`f628b→textView`). |
| `RunnableC0068r0` | `ChatSignalRunnable` | Posts typing on/off (modes 0/1); synthesises and plays the chat "pop" sent sound (mode 2) (mode only, no captures). |
| `RunnableC0093z0` | `SendAndPersistRunnable` | Background text-message send (mode 0); terminal output-persist watcher loop (mode 1) (`f748b→idOrInterval`, captures positional). |
| `RunnableC0032i` | `ProfileOrPrefetchRunnable` | Chat media prefetch + in-flight marker clear (modes 0/1); profile name-change POST (mode 2) (`f527b→chatScreen`, `f528c→value`). |
| `RunnableC0025g0` | `MembersOrVideoResultRunnable` | UI completions: video-send result (mode 0), members-refresh application (mode 1) (captures kept positional). |
| `RunnableC0080v` | `FocusInputRunnable` | Focuses a dialog input, cursor to end, opens the keyboard (both modes identical) (`f679b→editText`, `f680c→chatScreen`). |
| `W0` | `VideoProgressRunnable` | Fullscreen video player's 250 ms progress ticker (non-synthetic, no mode) (`f352a→prepared`, `f353b→seeking`, `f354c→duration`, `f355d→videoView`, `f356e→timeLabel`, `f357f→chatScreen`, `f358g→seekBar`). |

### Image editor, media picker and shared listeners

| Old | New | What it does |
|---|---|---|
| `B1` | `MediaPicker` | Media-picker controller/state: gallery grid, album filter menu, multi-select (max 10), single-item preview, hosts the image editor. (The first pass called it "image editor screen" — the editor proper is `ImageEditorView`.) Fields: `f26a→activity`, `f27b→darkTheme`, `f28c→onCameraAction`, `f29d→onMediaSelected`, `f30e→bgColor`, `f31f→textColor`, `f32g→surfaceColor`, `f33h→dividerColor`, `f34i→mainHandler`, `f35j→executor`, `f36k→bitmapCache`, `f37l→loadingUris`, `f38m→allMedia`, `f39n→filteredMedia`, `f40o→selectedItems`, `p→filterKey`, `q→keepScreenOn`, `f41r→pickerDialog`, `f42s→rootView`, `f43t→titleView`, `f44u→chevronIcon`, `f45v→gridView`, `w→filterMenuScroll`, `x→filterMenuColumn`, `y→cameraFab`, `z→actionBar`, `A→previewButton`, `B→sendButton`, `C→emptyView`, `D→previewRoot`, `E→previewVideoView`, `F→editorView`, `G→previewItem`, `H→drawMode`, `I→brushColor`, `J→gridAdapter`. Methods: `h→circleDrawable` (static), `a→applyFilter`, `b→showTextOverlayDialog`, `c→applyDialogBarColors`, `d→closePreview`, `e→dp`, `f→deliverSelection`, `g→addFilterMenuRow`, `i→refreshColorSwatches`, `j→toggleFilterMenu`, `k→makeIconButton`, `l→makeText`. |
| `C0091y1` | `ImageEditorView` | Editor canvas: freehand strokes, draggable/pinch-resizable text overlays, tap-to-edit (`f720a→bitmap`, `f721b→annotations`, `f722c→drawMode`, `f723d→brushColor`, `f724e→onTextTap`, `f725f→imageMatrix`, `f726g→inverseMatrix`, `f727h→paint`, `f728i→currentStrokePath`, `f729j→draggedText`, `f730k→dragMoved`, `f731l→lastBitmapX`, `f732m→lastBitmapY`, `f733n→touchStartX`, `f734o→touchStartY`, `p→touchSlop`, `q→scaleDetector`, `f735r→picker`; `a→drawAnnotations`, `b→configureStrokePaint`, `c→configureTextPaint`). Its synthetic marker `f719s` keeps its decoded name. |
| `O2` | `ImageTextOverlay` | One text annotation on the edited image (`f241a→text`, `f242b→x`, `f243c→y`, `f244d→textSize`, `f245e→color`; constructor order is `(text, y, textSize, color)` — `x` is set afterwards). |
| `ViewOnClickListenerC0058o1` | `MediaPickerClickListener` | All MediaPicker clicks by mode: close preview, undo, send preview (edited bitmap flattened to `cache/edit_*.jpg`), camera, open preview/editor, send selection, dismiss, filter menu (`f611a→mode`, `f612b→picker`). |
| `ViewOnClickListenerC0072s0` | `PairClickListener` | Generic two-object click dispatcher (chat mute toggle, `h.b` invocations, video play/pause, picker selection toggle) (`f650a→mode`, `f651b→first`, `f652c→second`). |
| `ViewOnClickListenerC0074t` | `DialogDismissClickListener` | Dismisses the captured dialog (modes 0–2); mode 3 hides ChatScreen's emoji panel instead (`f660a→mode`, `f661b→target`). |
| `ViewOnClickListenerC0077u` | `ChatSettingsClickListener` | Group-name submit (EditText constructor) and chat-theme apply (theme constructor); mode assigned per constructor (`f667b→chatScreen`, `f668c→dialog`, `f669d→first`, `f670e→second`). |
| `ViewOnClickListenerC0054n1` | `MediaFilterClickListener` | One picker filter-menu row: set filter key, retitle, re-filter, close menu (`f600b→picker`, `f601c→filterKey`, `f602d→label`; both modes execute identical code). |
| `ViewOnLongClickListenerC0065q0` | `NoopLongClickListener` | Stateless; `onLongClick` always returns `false` (parallels `NoopFunction2`). |
| `C0070r2` | `SheetDismissAnimatorListener` | On sheet-dismiss animation end: removes sheet + scrim, runs the completion action (`f641a→container`, `f642b→sheet`, `f643c→scrimView`, `f644d→onFinished`). |
| `C0088x1` | `PinchScaleListener` | Pinch handler: resizes the editor's text overlay (mode 0) / pinch-zooms the image viewer (mode 1) (`f711a→mode`, `f712b→targetView`). |
| `V0` | `VideoSeekBarListener` | Chat video-player seek bar: time label while dragging, seek on release if playing (`f338a→durationRef`, `f339b→timeLabel`, `f340c→chatScreen`, `f341d→seekingRef`, `f342e→playingRef`, `f343f→videoView`). |
| `S0` | `CheckButtonTextWatcher` | Re-runs the check-button state refresher after text changes in chat edit dialogs (`f303a→checkButtonFrame`, `f304b→chatScreen`, `f305c→checkIcon`, `f306d→editText`, `f307e→originalText`). |
| `DialogInterfaceOnDismissListenerC0033i0` | `SharedOnDismissListener` | Dialog-dismiss cleanup: clears ChatScreen's quick-reaction refresher (mode 0); stops picker preview video, shuts down its executor and evicts its bitmap cache (mode 1) (`f529a→mode`, `f530b→owner`). |
| `J1` | `SheetSlideAnimatorListener` | Per-frame bottom-sheet slide updater (slide-in / settle-back); mode assigned per constructor (`f139b→sheet`, `f140c→slideDistance`, `f141d→scrimView`). |
| `Q2` | `DoubleTapZoomListener` | Double-tap zoom toggle for `ZoomableImageView` (reset if scaled, else 2.5× at the tap point) (`f285a→zoomView`). |

### Theme, terminal package manager and misc core

| Old | New | What it does |
|---|---|---|
| `C0022f1` | `ChatTheme` | One chat theme: id, display strings and the full colour palette (17-arg constructor, order preserved): `f481a→id`, `f482b→displayName`, `f483c→emoji`, `f484d→isDefault`, `f485e→statusBarColor`, `f486f→navigationBarColor`, `f487g→titleTextColor`, `f488h→subTextColor`, `f489i→iconColor`, `f490j→ownBubbleGradientStart`, `f491k→ownBubbleGradientEnd`, `f492l→otherBubbleColor`, `f493m→otherBubbleTextColor`, `f494n→headerBarColor`, `f495o→barBackgroundColor`, `p→inputPillColor`, `q→lightBars`. |
| `AbstractC0026g1` | `ChatThemeCatalog` | Static catalog of the 17 built-in themes plus lookup by id with fallback to `"default"` (`f511a→themes`, `a→byId`). |
| `M2` | `ThemeBackgroundPainter` | Static Canvas painter drawing each theme's decorative chat-background artwork; bitmap cache is declared here but managed by `ThemedBackgroundView` (`f216a→bitmapCache`; `a→toColorInt`, `b→drawBackground`, `c→drawCloud`, `d→drawGlowCircle`, `e→fillVerticalGradient`). |
| `y2` | `TermuxPackageManager` | The terminal's self-contained Termux-APT package manager and prefix runtime fixer: Packages-index parsing, dependency resolution, resumable SHA-256-verified `.deb` downloads, ar/tar extraction with Termux-prefix rebasing, npm/python/script shims. Fields: `f736a→INSTANCE`, `f737b→MIRRORS`, `f738c→preinstalledPackages`, `f739d→binNamePattern`, `f740e→rewrittenScriptKeys`, `f741f→binEntriesCache`, `f742g→shimContentsCache`. Methods: `A→parsePackageIndex`, `B→prefixDir`, `C→prefixPath`, `D→readFully`, `E→readInstalled`, `F→isPrefixRecorded`, `G→stripTermuxPrefix`, `H→resolveDependencies`, `I→collectPackage`, `J→sha256Hex`, `K→rewriteShebangLine`, `L→shimDirFor`, `M→shimScriptFor`, `N→skipBytes`, `R→deleteRecursively`, `a→buildEnvironment`, `b→termuxArch`, `c→chmod`, `d→replaceTermuxPrefix`, `e→tarHeaderString`, `f→appContext`, `g→downloadWithRetries`, `h→downloadPackage`, `i→installLdconfigShim`, `j→installNpmWrappers`, `k→installDistutilsShim`, `m→rewriteScriptShebang`, `n→createPrefixSkeleton`, `o→reportProgress`, `p→extractDeb`, `q→isExternalStorage`, `r→symlinkIfMissing`, `s→fetchPackageIndex`, `t→recordInstalled`, `u→recordPrefix`, `v→recordToolsVersion`, `w→nodeModulesDirFor`, `x→defaultPackages`, `y→parseTarNumber`, `z→openConnection`, `O→refreshShimsAndHelpers`, `P→syncBinShims`, `Q→extractTar`, `l→rewriteScriptsIn`. |
| `w2` | `PackageEntry` | One package record from the Termux `Packages` index (`f697a→name`, `f698b→version`, `f699c→depends`, `f700d→filename`, `f701e→sha256`, `f702f→size`). |
| `x2` | `StoppedException` | Cancellation exception for package installs (`IOException`, message `"stopped"`). |
| `v2` | `LimitedInputStream` | Length-bounded delegating stream confining reads to one ar member (`f689a→delegate`, `f690b→remaining`; only the two `read` overrides — deliberately no `skip`/`available`/`close`). |
| `J0` | `StringPlus` | String-concatenation shim (`a→stringPlus`). R8-relocated kotlin `Intrinsics.stringPlus` shape, but referenced pervasively by app code, so reconstructed with the rest for consistency. |
| `C0` | `ValueProvider` | Mode-dispatched Function0 provider: mode 1 lazily loads the `"hidden_msgs"` preference into a `HashSet<Long>`; modes 0/2 are no-op `Unit` providers (kept distinct, as decoded) (`f51a→mode`). |

## Not rewritten — definitive list

Everything else in the decode is library code or empty R8 artefacts; the list
below is exhaustive for `sources/` (258 files = 147 reconstructed + 108 library
+ 3 stubs). These keep their decoded names and are referenced as-is.

- Package `a`, empty synthetic stubs (no members, no references anywhere in
  the tree, nothing to reconstruct): `AbstractC0012d` (originally `a.d`),
  `AbstractC0050m1` (originally `a.m1`), `H1`.
- `b.*` (4 files): kotlin core — `Unit`, `Pair`, `Lazy` and helpers.
- `c.*` (11): kotlin collections.
- `d.*` (1): kotlin comparators helper.
- `e.*` (1), `f.*` (1): kotlin stdlib helpers.
- `g.*` (18): kotlin sequences / io.
- `h.*` (3): kotlin `Function0`/`Function1`/`Function2` interfaces.
- `i.*` (10): kotlin intrinsics and `Ref` types.
- `j.*` (1): kotlin functional interface.
- `k.*` (3): kotlin ranges.
- `l.*` (6): kotlin misc, incl. concurrency helpers.
- `m.*` (14): kotlin text / io.
- `n.*` (22): org.tukaani XZ for Java (the `.xz` decoder used by
  `TermuxPackageManager`) plus zip helpers.
- `o.*` (4), `r.*` (1): kotlin/io zip-related helpers.
- `s.*` (1), `t.*` (3), `u.*` (1), `v.*` (3): R8-relocated kotlin-stdlib
  classes.
- The merged kotlin-stdlib members inside `AppState` (documented in its row
  above) likewise keep their letter names.

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
- Pass 2 additions:
  - `SortComparator.compare` (modes 0/1/2): jadx omitted the switch bodies;
    the chat-message ordering (timestamp, then id tie-break) was recovered
    from the two call sites, and mode 2 sorts `MediaItem` by `dateAdded`
    descending — the descending direction is a judgement call, the one
    ungrounded choice in this class. Modes 3/4 use the surviving
    File-name comparison.
  - `ChatSendRunnable`: the mode-1 JPEG compress loop was rebuilt around its
    surviving constants (start quality 78, −15 per pass, threshold
    1,300,000 bytes, floor 35), and the mode-1 photo-error branch condition
    was restored as `bytes == null` (jadx rendered the success value in the
    error branch — an apparently dropped negation). The mode-2 video path
    was stitched from its skeleton; every constant and string comes from
    the decompile.
  - `QuadTaskRunnable` mode 8 (terminal `.deb` install) sits in the most
    jadx-damaged region; its flow follows the rendered skeleton, two unnamed
    locals were initialised in place, and collapsed empty catch tails were
    filled with the same strings its fully rendered catches use
    ("Stopped." / "Failed: …"). Treat mode 8 as approximate.
  - `ChatSignalRunnable` mode 2: the sent-sound decay term referenced a
    register jadx never assigned; a normalised decay envelope was
    substituted — the one numeric expression in pass 2 not sourced from the
    decompile.
  - `ChatScreenRunnable` mode 3 was preserved exactly as decompiled,
    including an outbox loop condition that looks inverted and an
    unreachable tail; it was deliberately not "fixed".
  - `SlideDownDialog` and `ChatListView`: jadx recovered no constructor;
    the single-argument constructors were supplied from their call sites.
    `SlideDownDialog.dismissImmediately` was reconstructed from a jadx
    artefact that rendered a `super.dismiss()` call inside a static method.
  - `ChatThemeCatalog.byId`: the fallback (fall back to the `"default"`
    theme, else throw `NoSuchElementException` with the stdlib message) was
    reconstructed; jadx rendered the method unrecognisably.
  - `TermuxPackageManager`: `fetchPackageIndex` now parses the decompressed
    stream (jadx passed the compressed stream to the parser, which cannot
    have been the shipped behaviour); `extractTar` was rebuilt as a single
    coherent loop and its regular-file routing includes the standard `'0'`
    typeflag (the decompile's guard left `'0'` unrouted, which would
    extract nothing — one added char literal against the decompile);
    `extractDeb`'s stream handling was made coherent the same way.
    Otherwise every string literal matches the decompile (machine-checked).
  - Mode constants that jadx collapsed to a single value were restored per
    constructor for `ChatSettingsClickListener` (name-submit vs
    theme-apply), `SheetSlideAnimatorListener` (slide-in vs settle-back),
    `QuickReactionRefresher`, `MessageDialogClickListener`,
    `MultiWorkRunnable`, `MembersOrVideoResultRunnable`,
    `SendAndPersistRunnable`, `ChatSendRunnable` and
    `ProfileOrPrefetchRunnable`, using the surviving constructor shapes and
    call sites.
  - Duplicate switch arms in the decompile were preserved, not merged away:
    `ReactionCallback` modes 0 = 1, `ReactionAction` modes 1 = 2,
    `HideTextRunnable` modes 0 = 1, `FocusInputRunnable` modes 0 = 1,
    `ValueFunction` modes 4 = 5, `ChatScreenRunnable` modes 2 = 12,
    `MediaFilterClickListener` modes, and `TopRoundedOutlineProvider`'s two
    branches.
  - `MediaPicker.darkTheme` follows the picker's own internal colour
    evidence (true = dark palette). The value originates from the ChatScreen
    field pass 1 named `lightBars`, which is itself assigned from
    `AppState.darkTheme`; the naming tension is noted, the logic unchanged.
  - `VideoSeekBarListener.playingRef`'s name is inferred from its gating
    role on `seekTo` at its single call site; `seekingRef` is certain.
  - In pass-1 files, local variables that jadx happened to name with the
    same letters as classes (e.g. a `LinearLayout` local named `P2`, a root
    view named `V`) were left as-is: only class and member references were
    aligned to the new names.
