# Open storage build (modified)

Changes against the stock Android fork:

* **Data folder.** The game keeps its data in the private app folder. No "All files access" or
  storage permission is requested.
* **"All files" document root.** The system Files app (Open Files in the launcher) now shows an
  extra `All files` folder: the whole data folder, dotfiles included, writable while the game runs.
  Account and session files are inside it, so do not share that folder.
* **Permissions.** None for storage (only `WRITE_EXTERNAL_STORAGE` up to Android 9 for screenshots).

Skins (Wardrobe) and Ely.by sign-in were already part of this fork.
Not built or tested in the environment that produced this change.
