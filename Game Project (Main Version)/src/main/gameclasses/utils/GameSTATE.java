package main.gameclasses.utils;

/*
 * This enum is used to distinguish the current state of the game
 * Whether the game is on the Menu Screen or if game play has begun
 */

public enum GameSTATE {
	Menu,
	Intro,
	Hud,
	Gameplay,
	GameOver,
	GameWin;
}
