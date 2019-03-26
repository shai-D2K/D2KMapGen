There are two ways to use this program. 

	1. 'run.bat' will run the program normally, using all the settings as they are specified in the 'settings.ini' file

	2. 'runGUI.bat' will run the program with an interface meant to simplify the process by automatically choosing some of the settings based on the size of the map



[General]
exportName 
	The name of the map 

exportAll 
	Setting this to true will export every step of the generation 
	Disabled when running under 'runGUI.bat'

exitImediatly 
	Setting this to true will prompt the user to hit a key before exiting 
	Disabled when running under 'runGUI.bat'

useSettings 
	Setting this to true will automatically choose some of the settings and ignore what's in the 'settings.ini' file
	Disabled when running under 'runGUI.bat', this will be used no matter what

addTimeStamp 
	Setting this to true will add a time stamp to the end of the map file name

addMis 
	Setting this to true will create a .mis file to go with the .map file


[Map]
boardR
	The width of the map

boardC
	The height of the map

tileset
	The tileset to use

numberOfSpawnsToAdd
	This is the number of spawn points that will be added to the map. It is essentially the number of rock plains, where the players will spawn, that will be added to the map. Extras will be added/removed to fit the game requirement of 8 in total

scrambleSpawnRange
	This is how far up/down/left/right a spawn can be moved from it's original position. This is meant to add some extra randomness to the location of the player spawns

spaceBetweenPoints
	This is how far apart each player spawn point needs to be

autoSpawnSpawns
	Setting this to true will ignore the above setting, 'spaceBetweenPoints', and evenly distribute the player spawn points across the map, starting from them needing to be extremly spaced apart, to them being able to be close to together. This is to better lay out the spawn points and to prevent the program from locking up


[Rock]
broadSize
	From the centre, this is the starting widths/heights of each rock plain 

rockFreq
	This is roughly the percentage of the total tiles on the map that will be a rock tile. Ex. '0.35' will have 35% (0.35 * 100) of tiles being a rock tile


[Spice]
numberOfBlooms
	This is the number of spice blooms that will be added all around the map. As well, they will act as the starting areas for the spice fields

numberOfEmptyBlooms
	This is the number of small spice patches that will be added all around the map. They will act as the starting areas for the spice fields too, but they will not have a spice bloom

spiceFreq
	This is roughly the percentage of the total tiles on the map that will be a spice tile. Ex. '0.6' will have 60% (0.6 * 100) of tiles being a spice tile


[Dunes]
numberOfDuneStarts
	This is the number of small patches of sand dunes that will be added all around the map. They will act as the starting areas for the patches of dunes

duneFreq
	This is the roughly percentage of the total tiles on the map that will be a dune tile. Ex. '0.2' will have 20% (0.2 * 100) of tiles being a dune tile


[Rock Chunks]
numberOfIslandsToAdd
	This is the number of small patches of rock, seperated from the rock plains, that will be added all around the map

numberOfIslandSquares
	This is the roughly percentage of the total tiles on the map that will be a rock tile that is an island. Ex. '0.2' will have 20% (0.2 * 100) of tiles being a rock tile that is an island


[Other]
numberOfWorms
	This is the number of worm spawns that will be added all around the map

sandSpecialFreq
	This is the percentage of sand tiles that will have a 'sand special' placed on it. Ex. '0.004' will have 0.4% (0.004 * 100) of tiles being a sand special tile

rockSpecialFreq
	This is the percentage of rock tiles that will have a 'rock special' placed on it. Ex. '0.004' will have 0.4% (0.004 * 100) of tiles being a rock special tile


infantryClimbsToAdd
	This is the number of infantry only paths up the cliffs that will be added all around the map. This setting is used as many as three seperate times, so depending on the tileset there could be 3 times the number of infantry paths, but, they are all varied in type


[Shared settings, these are not intended to be altered]
_____Top, _____Right, _____Bottom, _____Left
	From the centre, these are the widths/heights of each square of rock/spice etc.
	

_____Divisor
	When divided by the setting that is above them, the resulting number is how many of each 'square' that will be added at a time, to eaven out their placements. Ex. (numberToAdd / numberAtATimeDivisor) = numberAtATime
