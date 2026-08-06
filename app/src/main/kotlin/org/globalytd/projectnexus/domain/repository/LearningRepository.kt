package org.globalytd.projectnexus.domain.repository

import org.globalytd.projectnexus.domain.model.Lesson
import org.globalytd.projectnexus.domain.model.LearningCategory

interface LearningRepository {
    suspend fun getCategories(): Result<List<LearningCategory>>
    suspend fun getLessonsForCategory(categoryId: String): Result<List<Lesson>>
    suspend fun getLessonById(lessonId: String): Result<Lesson>
}
