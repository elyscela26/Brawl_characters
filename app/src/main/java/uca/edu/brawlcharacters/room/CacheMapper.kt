package uca.edu.brawlcharacters.room

import uca.edu.brawlcharacters.model.Brawl
import uca.edu.brawlcharacters.utils.EntityMapper
import javax.inject.Inject


class CacheMapper
@Inject
constructor():
    EntityMapper<BrawlCacheEntity, Brawl>{

        override fun mapFromEntity(entity: BrawlCacheEntity): Brawl {
            return Brawl(
                id = entity.id,
                name = entity.name,
                description = entity.description,
                image = entity.image
            )
        }

        override fun mapToEntity(domainModel: Brawl): BrawlCacheEntity {
            return BrawlCacheEntity(
                id = domainModel.id,
                name = domainModel.name,
                description = domainModel.description,
                image = domainModel.image
            )
        }

        fun mapFromEntityList(entities: List<BrawlCacheEntity>): List<Brawl>{
            return entities.map { mapFromEntity(it) }
        }
    }