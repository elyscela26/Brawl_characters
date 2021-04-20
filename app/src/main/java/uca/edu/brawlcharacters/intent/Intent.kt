package uca.edu.brawlcharacters.intent

sealed class Intent{
    object GetBrawlerEvent: Intent()
    object None: Intent()
}