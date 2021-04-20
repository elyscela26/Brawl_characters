package uca.edu.brawlcharacters.room

import uca.edu.brawlcharacters.model.Brawler
import uca.edu.brawlcharacters.utils.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor():
    EntityMapper<BrawlerCacheEntity, Brawler> {

    override fun mapFromEntity(entity: BrawlerCacheEntity): Brawler {
        return Brawler(
            id = entity.id,
            name = entity.name,
            url = entity.url,
            descripcion = entity.descripcion
        )
    }

    override fun mapToEntity(domainModel: Brawler): BrawlerCacheEntity {
        return BrawlerCacheEntity(
            id = domainModel.id,
            name = domainModel.name,
            url = domainModel.url,
            descripcion = domainModel.descripcion
        )
    }

    fun mapFromEntityList(entities: List<BrawlerCacheEntity>): List<Brawler>{
        return entities.map { mapFromEntity(it) }
    }
}