package org.globalytd.projectnexus.domain.repository

import org.globalytd.projectnexus.domain.model.Blueprint

interface BlueprintRepository {
    suspend fun getBlueprints(): Result<List<Blueprint>>
    suspend fun getBlueprintById(id: String): Result<Blueprint>
}
