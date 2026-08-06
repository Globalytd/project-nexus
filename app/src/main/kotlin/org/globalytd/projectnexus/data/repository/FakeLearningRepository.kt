package org.globalytd.projectnexus.data.repository

import org.globalytd.projectnexus.domain.model.Lesson
import org.globalytd.projectnexus.domain.model.LearningCategory
import org.globalytd.projectnexus.domain.repository.LearningRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * FAKE IMPLEMENTATION – demonstration data only.
 */
@Singleton
class FakeLearningRepository @Inject constructor() : LearningRepository {

    private val categories = listOf(
        LearningCategory("cat1", "Investment Basics", "Learn the fundamentals of investing", 5),
        LearningCategory("cat2", "Crypto Education", "Understand blockchain and digital assets", 4),
        LearningCategory("cat3", "Portfolio Diversification", "Spread risk across asset classes", 3),
        LearningCategory("cat4", "Risk Management", "Manage and minimise investment risk", 4),
        LearningCategory("cat5", "Personal Finance", "Master your personal finances", 6)
    )

    private val lessons = listOf(
        Lesson("l1", "cat1", "What is Investing?", "Placeholder lesson content for investment basics.", false, 5),
        Lesson("l2", "cat1", "Stocks vs Bonds", "Placeholder lesson content comparing asset classes.", true, 7),
        Lesson("l3", "cat2", "Intro to Bitcoin", "Placeholder lesson content about Bitcoin.", false, 8)
    )

    override suspend fun getCategories(): Result<List<LearningCategory>> = Result.success(categories)

    override suspend fun getLessonsForCategory(categoryId: String): Result<List<Lesson>> =
        Result.success(lessons.filter { it.categoryId == categoryId })

    override suspend fun getLessonById(lessonId: String): Result<Lesson> {
        val lesson = lessons.find { it.id == lessonId }
            ?: return Result.failure(Exception("Lesson not found"))
        return Result.success(lesson)
    }
}
