package uca.edu.brawlcharacters.retrofit

import javax.inject.Inject
import uca.edu.brawlcharacters.model.Brawl
import uca.edu.brawlcharacters.utils.EntityMapper

class NetworkMapper
@Inject
constructor() : EntityMapper<BrawlNetworkEntity, Brawl>{
    override fun mapFromEntity(entity: BrawlNetworkEntity): Brawl {
        return Brawl(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            image = entity.image
        )
    }

    override fun mapToEntity(domainModel: Brawl): BrawlNetworkEntity {
        return  BrawlNetworkEntity(
            id = domainModel.id,
            name = domainModel.name,
            description = domainModel.description,
            image = domainModel.image
        )
    }

    fun mapFromEntityList(entities: List<BrawlNetworkEntity>): List<Brawl>{
        return entities.map { mapFromEntity(it) }
    }
}