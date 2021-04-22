package uca.edu.brawlcharacters.intent

sealed class Intent{
    object GetBrawlEvent: Intent()
    object None: Intent()
}
