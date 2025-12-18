public interface ActivityCategoryService {
    ActivityCategory createCategory(ActivityCategory category);
    List<ActivityCategory> getAllCategories();
    ActivityCategory getCategory(Long id);
}
