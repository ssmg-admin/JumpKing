# JumpKing (student project)

This repository contains a small 2D game prototype built for learning purposes.
The code is intentionally simple and focuses on teaching the basics of:

- Java + Maven project structure
- Swing GUI fundamentals (EDT thread model, painting, event listeners)
- A simple game loop (update → repaint)
- Input handling (keyboard/mouse state)
- Basic entity representation (position/size + drawing + bounds)

The current gameplay is minimal (placeholder rendering + empty update logic).
Students are expected to implement physics, movement, collisions, and rules.

---

## Technology used (what and why)

### Java 21
The project targets Java 21 (see `pom.xml`). This allows modern Java syntax
and keeps the toolchain up-to-date.

### Maven
Maven provides a standard project layout and a repeatable build.
Important directories:

- `src/main/java` – application source code
- `src/main/resources` – images and other resources loaded at runtime
- `target` – build output (created by Maven)

### Swing (GUI)
Swing is Java’s built-in desktop UI toolkit. It is great for teaching because:

- there are no external game libraries to learn first,
- the rendering pipeline is explicit (paintComponent),
- input is event-driven (KeyListener/MouseListener),
- you must understand the EDT (Event Dispatch Thread), which is core UI knowledge.

---

## How to run the project

### Option A: IntelliJ IDEA (recommended for students)
1. Open the project folder in IntelliJ.
2. Ensure a Java 21 SDK is configured for the project.
3. Run the main class: `jumpKing.Game`.

### Option B: Maven (command line)
From the project root:

1. Build:
   - `mvn clean package`
2. Run (one easy approach):
   - Run `jumpKing.Game` from your IDE, or
   - Use IntelliJ’s Maven tool window to build, then run the main class.

Note: the `pom.xml` does not currently configure an executable “fat jar”.
If you want a runnable jar from the command line, you can add a Maven plugin
later as an exercise.

---

## Project architecture (how the program is organized)

### High-level flow
The application has two “screens”:

1. Menu screen (`MenuPanel`)
2. Game screen (`GameFrame`)

The main window (`Game`) uses `CardLayout` to switch between these screens.

### Why CardLayout?
`CardLayout` is a simple way to build multi-screen desktop apps:

- you add multiple panels to one container,
- each panel gets a string name (“card key”),
- `layout.show(container, key)` switches the visible card.

This keeps menu logic and game logic separated and easier to understand.

---

## The game loop (update → repaint)

### Where the loop lives
The loop is implemented in `GameFrame` using a `javax.swing.Timer`.

Why a Swing Timer?
- It fires events on the Swing EDT.
- It plays nicely with Swing painting (also on the EDT).
- It is simple and safe for beginner projects.

### How the loop works step-by-step
When the game starts:
1. `Game.startGame()` creates a `GameFrame`, shows it, and calls `gameFrame.startGame()`.
2. `GameFrame.startGame()` calls `timer.start()`.
3. Every ~16 ms, the timer triggers:
   - `updateGame()` – update positions, read input, resolve collisions, update rules
   - `repaint()` – request a redraw
4. Swing calls `paintComponent(Graphics)` when it is ready to paint.

### Important rule: keep the EDT fast
Swing is single-threaded for UI:
- input callbacks run on the EDT,
- timer events run on the EDT,
- painting runs on the EDT.

If you do heavy work (sleep, file IO, long loops) on the EDT, the window will freeze.

---

## Rendering (how drawing works)

### paintComponent(Graphics)
In Swing, you draw by overriding `JPanel.paintComponent(Graphics g)`.

Key rules students should follow:
- Always call `super.paintComponent(g)` first (clears the panel properly).
- Never call `paintComponent` directly; call `repaint()` and let Swing schedule it.
- Draw using your entity state (x/y/width/height) so the visuals match the logic.

Current implementation:
- `Player.draw(g)` draws a green rectangle
- `Platform.draw(g)` draws a red rectangle

These are placeholders; later you can replace them with sprites.

---

## Input handling (keyboard and mouse)

### Why “state-based” input?
Swing gives input via events (keyPressed, keyReleased, mousePressed, ...).
But games usually want “continuous input”, e.g.:

- “the key is held down” (move left every frame)
- “mouse button is held” (charge a jump)

That’s why `KeyInput` and `MouseInput` store boolean states.
Then the game loop can poll these states in `GameFrame.updateGame()`.

### Keyboard focus (common beginner issue)
KeyListener only works if the component has focus.
In `GameFrame`, we set:
- `setFocusable(true)`
- `setFocusTraversalKeysEnabled(false)` (prevents Tab from stealing focus)

And in `Game.startGame()` we call:
- `gameFrame.requestFocusInWindow()`

If key input does not work, focus is the first thing to check.

---

## Entities (Entita, Player, Platform)

### Entita (base class)
`Entita` stores:
- position (x, y)
- size (width, height)
- alive flag (isAlive)

It provides:
- `getBounds()` which creates a new `Rectangle` for collision checks
- getters/setters for the fields
- `draw(Graphics g)` which is meant to be overridden

### Player / Platform
`Player` and `Platform` extend `Entita` and override `draw(...)`.
Right now they only render colored rectangles.

---

## Collision and position helper tools

### CollisionTools
`CollisionTools.collisionRectangle(a, b)`:
- gets each entity’s bounding rectangle
- uses `Rectangle.intersects(...)` to check AABB overlap

This is fast and simple, but approximate (rectangles, not pixel-perfect).

### PositionTools
Contains small helper checks:
- `isAbove(a, b)` – compares bottom edge of A to top edge of B
- `isBelow(a, b)` – compares top edge of A to bottom edge of B
- `distanceToEntita(a, b)` – distance between entity centers

These methods become useful when implementing collision resolution
(e.g., snapping the player to stand on a platform).

---

## Resources (images)

The menu loads an image from:
- `src/main/resources/title_logo.png`

In code, this is accessed via:
- `MenuPanel.class.getResource("/title_logo.png")`

How resource loading works:
- Maven copies resources into the build output.
- `getResource("/...")` looks inside the classpath (works in IDE and in jars).

If the image does not show:
- verify the file exists in `src/main/resources`
- verify the name and path match exactly

---

## Suggested student exercises (next steps)

1. Implement basic player movement in `GameFrame.updateGame()`
   - gravity (velocityY += gravity)
   - jump (set velocityY negative on input)
2. Add collision resolution with `Platform`
   - detect intersection
   - push the player out of the platform from the correct side
3. Use input states:
   - WASD / arrows for movement
   - mouse hold to charge jump strength
4. Add more platforms and a camera (scrolling)
5. Replace rectangles with sprites (optional)

---

## Troubleshooting

- “Keyboard doesn’t work”
  - Make sure the game panel has focus (`requestFocusInWindow()` after showing it).
- “The window freezes”
  - Do not do slow operations inside updateGame() or paintComponent().
- “Image not found”
  - Check `src/main/resources/title_logo.png` and the resource path in code.
