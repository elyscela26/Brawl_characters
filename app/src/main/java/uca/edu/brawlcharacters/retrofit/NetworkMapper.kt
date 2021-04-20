package uca.edu.brawlcharacters.retrofit

import uca.edu.brawlcharacters.model.Brawler
import uca.edu.brawlcharacters.utils.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor() : EntityMapper<BrawlerNetworkEntity, Brawler>{
    override fun mapFromEntity(entity: BrawlerNetworkEntity): Brawler {
        return Brawler(
            id = entity.id,
            name = entity.name,
            url = entity.url,
            descripcion = entity.descripcion
        )
    }

    override fun mapToEntity(domainModel: Brawler): BrawlerNetworkEntity {
        return BrawlerNetworkEntity(
            id = domainModel.id,
            name = domainModel.name,
            url = domainModel.url,
            descripcion = domainModel.descripcion
        )
    }

    fun mapFromEntityList(entities: List<BrawlerNetworkEntity>): List<Brawler>{
        return entities.map{ mapFromEntity(it) }
    }
}